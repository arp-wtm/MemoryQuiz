# MemoryQuiz  <br>
ADVICE: this is create by beginner student for project 3 Udacity Android Basic challenge, Object Oriented Programming.<br> Well accepted corrections and suggestions <br>
This APP is a simple memory test: observe an image, then answer to questions.<br>
The java code is divided into 3 different files so i try to implement a Model View Controller: <br>
 1.) the usual MainActivity (opens the first screen with the image to observe and a button to start quiz. When start button is clicked, an intent is send to QuestionActivity)<br>
 2.) the QuestionActivity (displays the second screen, updating text of the question and a radio button group with 3 choices. When Next is clicked the method updateData fills the view with the next data question.If last question is reached(4) display the score<br>
3.) the QuizModel contains the data model: the texts to display, the score, the position of the current question. Here I defined an array of 4 element corresponding to each question. Every element is a combination of question text, choice1 answer, choice2 answer, choice3 answer, number of the right choice answer.
