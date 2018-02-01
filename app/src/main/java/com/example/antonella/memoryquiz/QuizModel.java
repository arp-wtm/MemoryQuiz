package com.example.antonella.memoryquiz;

/**
 * Created by Antonella on 30/01/18.
 * here is defined the data model
 * update state of currentQuestion and send to the SecondScreen View
 * the new information
 */

class QuizModel {

    /**
     * this is the structure that will contain 4
     * different element of type Ques
     */

    private static int NUM_QUESTION = 4;
    private int score = 0;
    private int currentQuestion = 0;
    private Ques[] quesiti = new Ques[NUM_QUESTION];

    QuizModel() {
        setScore(0);
        setCurrentQuestion(0);
        getQuesiti()[0] = new Ques("how many different java language keywords are into the image? ", "3", "no", "9", 2);
        getQuesiti()[1] = new Ques("Nougat is the name of the 7 version of Android mobile operating system. How many times you can see into the initial screen?", "3", "none", "8", 1);
        getQuesiti()[2] = new Ques("implements is a reserved Java keyword. It appears 3 times", "it is not a keyword, 3 times present", "it is a keyword, not present ", "it is a keyword, twice present", 1);
        getQuesiti()[3] = new Ques("Ringo is the last Android version. How many times does it appear? ", "it is not a name version, it is not present ", "2", "3", 0);
    }

    Ques getQuesito() {
        return getQuesiti()[getCurrentQuestion()];
    }

    boolean isLast() {
        return getCurrentQuestion() == NUM_QUESTION - 1;
    }

    void incCurrentQuestion() {
        if (!isLast()) {
            setCurrentQuestion(getCurrentQuestion() + 1);
        }
    }

    // is called by checkAnswer method of QuestionActivity control right answer
    void incScore() {
        setScore(getScore() + 1);
    }

    int getScore() {
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }

    int getCurrentQuestion() {
        return currentQuestion;
    }

    int getNumQuestion() {
        return NUM_QUESTION;
    }

    private void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    private Ques[] getQuesiti() {
        return quesiti;
    }

    public void setQuesiti(Ques[] quesiti) {
        this.quesiti = quesiti;
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

    private int getANSWER_NUMBER() {
        return ANSWER_NUMBER;
    }

    public void setANSWER_NUMBER(int ANSWER_NUMBER) {
        this.ANSWER_NUMBER = ANSWER_NUMBER;
    }

    String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    String[] getAnswerItem() {
        return answerItem;
    }

    public void setAnswerItem(String[] answerItem) {
        this.answerItem = answerItem;
    }

    int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}