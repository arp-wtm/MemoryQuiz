package com.example.antonella.memoryquiz;

/**
 * Created by Antonella on 30/01/18.
 * here is defined the data model
 * update state of currentQuestion and send to the SecondScreen View
 * the new information
 */

public class QuizModel {

    /**
     * this is the structure that will contain 5
     * different element of type Ques
     */

    private static int NUM_QUESTION = 4;
    private int score = 0;
    private int currentQuestion = 0;
    Ques[] quesiti = new Ques[NUM_QUESTION];

    QuizModel() {
        setScore(0);
        setCurrentQuestion(0);
        quesiti[0] = new Ques("quante case gialle vedi?", "3", "nessuna", "8", 0);
        quesiti[1] = new Ques("quante case verdi vedi?", "3", "nessuna", "8", 0);
        quesiti[2] = new Ques("quante case rosse vedi?", "3", "nessuna", "8", 0);
        quesiti[3] = new Ques("quante case rosse vedi?", "3", "nessuna", "8", 0);
    }

    Ques getQuesito() {
        return quesiti[getCurrentQuestion()];
    }

    boolean isLast() {
        return getCurrentQuestion() == NUM_QUESTION - 1;
    }

    void incCurrentQuestion() {
        if (!isLast()) {
            setCurrentQuestion(getCurrentQuestion() + 1);
        }
    }

    void incScore() {
        setScore(getScore() + 1);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public int getNumQuestion() {
        return NUM_QUESTION;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}

/**
 * define the element Ques as combination
 * of 3 different answer and an integer
 * that indicates the position of the right one
 */

class Ques {
    private int ANSWER_NUMBER = 3;
    private String domanda;
    private String[] answerItem = new String[getANSWER_NUMBER()];
    private int rightAnswer;

    Ques(String dom, String r0, String r1, String r2, int rightPosition) {
        domanda = dom;
        answerItem[0] = r0;
        answerItem[1] = r1;
        answerItem[2] = r2;
        rightAnswer = rightPosition;
    }

    public int getANSWER_NUMBER() {
        return ANSWER_NUMBER;
    }

    public void setANSWER_NUMBER(int ANSWER_NUMBER) {
        this.ANSWER_NUMBER = ANSWER_NUMBER;
    }

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public String[] getAnswerItem() {
        return answerItem;
    }

    public void setAnswerItem(String[] answerItem) {
        this.answerItem = answerItem;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}