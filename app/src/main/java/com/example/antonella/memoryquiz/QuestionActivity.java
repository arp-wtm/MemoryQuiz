package com.example.antonella.memoryquiz;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuestionActivity extends AppCompatActivity {
    QuizModel qm = new QuizModel();
    int score = 0;
    RadioButton item0, item1, item2;
    int right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         *this method change the view of the user with second screen
         * and update the display information
         */
        setContentView(R.layout.activity_question);
        updateData();
    }

    /**
     * fill the screen with the new data question
    */

    void updateData() {
        // displays number of current question
        //
        EditText questionNumber = findViewById(R.id.numQuestionPT);
        questionNumber.setText((qm.getCurrentQuestion() + 1) + getString(R.string.slash) + qm.getNumQuestion());

        // displays text of current question
        EditText questionView = findViewById(R.id.questionET);
        questionView.setText(qm.getQuesito().getDomanda());


        // display text description of the three radio button for each answer

        item0 = findViewById(R.id.answerRB0);
        item0.setText(qm.getQuesito().getAnswerItem()[0]);
        // display text description of second radio button answer
        item1 = findViewById(R.id.answerRB1);
        item1.setText(qm.getQuesito().getAnswerItem()[1]);
        // display text description of three radio button answer
        item2 = findViewById(R.id.answerRB2);
        item2.setText(qm.getQuesito().getAnswerItem()[2]);
        right = qm.getQuesito().getRightAnswer();


    }

    /**
     * called by user when button NEXT is pressed
     */

    public void doNext(View view) {
        updateScore();
        if (qm.isLast()) {
            displayScore();
        } else {
            nextQuestion();

        }
    }

    /**
     * called by user when button NEXT is pressed on last question
     */

    private void displayScore() {
        //final int time = Toast.LENGTH_LONG;
        //Toast scoreToast = Toast.makeText(this, "YOUR SCORE IS " + qm.getScore() + "/" + qm.getNumQuestion(),time);
        //scoreToast.show();
        AlertDialog.Builder scoreMessage = new AlertDialog.Builder(QuestionActivity.this);
        scoreMessage.setMessage(getString(R.string.yourScoreIs) + qm.getScore() + "/" + qm.getNumQuestion());

        AlertDialog alert = scoreMessage.create();
        alert.show();


    }

    /**
     * updateScore method control if the
     * right answer position is equal to
     * number of the radio button checked
     */
    private void updateScore() {
        switch (right) {
            case 0:
                checkAnswer(item0);
                break;
            case 1:
                checkAnswer(item1);
                break;
            case 2:
                checkAnswer(item2);
                break;
        }
    }

    private void checkAnswer(RadioButton item) {
        if (item.isChecked()) {
            qm.incScore();
        }
    }

    private void nextQuestion() {
        qm.incCurrentQuestion();
        updateData();
    }
}
