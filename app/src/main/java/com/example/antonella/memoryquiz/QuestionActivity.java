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
    RadioButton item0,item1,item2;
    int right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         *this method change the view of the user with second screen
         * and update the display information
         */
        setContentView(R.layout.activity_question);
        updateData();
    }

    /*
     *
    */
    void updateData() {
        // displays number of current question
        //
        EditText questionNumber = (EditText) findViewById(R.id.numQuestionPT);
        questionNumber.setText((qm.getCurrentQuestion()+ 1) + "/" + qm.getNumQuestion());

        // displays text of current question
        EditText questionView = (EditText) findViewById(R.id.questionET);
        questionView.setText(qm.getQuesito().getDomanda());


        //RadioGroup questRG = (RadioGroup) findViewById(R.id.questionRadioGroup);

        // display text description of first radio button answer

        item0 = (RadioButton) findViewById(R.id.answerRB0);
        item0.setText(qm.getQuesito().getAnswerItem()[0]);
        // display text description of second radio button answer
        item1 = (RadioButton) findViewById(R.id.answerRB1);
        item1.setText(qm.getQuesito().getAnswerItem()[1]);
        // display text description of three radio button answer
        item2 = (RadioButton) findViewById(R.id.answerRB2);
        item2.setText(qm.getQuesito().getAnswerItem()[2]);
        right = qm.getQuesito().getRightAnswer();


    }
    
    public void doNext(View view) {
        updateScore();
        if (qm.isLast()) {
            displayScore();
        } else {
            nextQuestion();
            
        }
    }

    private void displayScore() {
        //final int time = Toast.LENGTH_LONG;
        //Toast scoreToast = Toast.makeText(this, "YOUR SCORE IS " + qm.getScore() + "/" + qm.getNumQuestion(),time);
        //scoreToast.show();
        AlertDialog.Builder scoreMessage = new AlertDialog.Builder(QuestionActivity.this);
        scoreMessage.setMessage("YOUR SCORE IS " + qm.getScore() + "/" + qm.getNumQuestion());

        AlertDialog alert = scoreMessage.create();
        alert.show();




    }
    private void updateScore() {
        switch(right){
            case 0: if (item0.isChecked()){
                qm.incScore();
            }
                break;
            case 1: if (item1.isChecked()){
                qm.incScore();
            }
                break;
            case 2: if (item2.isChecked()){
                qm.incScore();
            }
                break;
        }
    }
    private void nextQuestion() {
        qm.incCurrentQuestion();
        updateData();
    }
}
