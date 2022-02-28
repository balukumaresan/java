function quiz(questions) {
    this.score = 0;
    this.questions = questions;
    this.questionIndex = 0;
};

quiz.prototype.isEnded = function() {   
return this.questionIndex === this.questions.length;
};

quiz.prototype.getQuestionByIndex = function() {
    return this.questions[this.questionIndex];
};

quiz.prototype.checkOptionsWithAnswer = function(ans) {
    if (this.getQuestionByIndex().isCorrectAnswer(ans)) {
        this.score++;
    }
    this.questionIndex++;
}

question.prototype.isCorrectAnswer = function(ans) {
    return this.answer === ans;
};

function question(text, choice, answer){
    this.text = text;
    this.choice = choice,
    this.answer =answer;
};

var questions = [
    new question('Java Script supports?',['Events', 'Inheritence', 'File Handling', 'Polymorphism'], 'Events'),
    new question('Which Language is used for Styling?',['CSS', 'JQuery', 'HTML', 'XML'], 'CSS'),
    new question('Which is not a JS Framework?',['Pyhton Script', 'JQuery', 'DJango', 'NODE JS'],'DJango'),
    new question('Which is used to connect DB?',['PHP', 'HTML', 'JS', 'ALL'],'PHP'),
    new question('Java Script is a?',['Language', 'Scripting Language', 'DBMS', 'ALL'], 'Scripting Language'),
];

var q =  new quiz(questions);

function loadQuestions() {
    if (q.isEnded()) {
        showScores();
    }
    else {
        var element = document.getElementById('question');
        element.innerHTML = q.getQuestionByIndex().text;

        var choices =q.getQuestionByIndex().choice;
        for (var i =0; i < choices.length; i++) {
            var element = document.getElementById('choice'+ i);
            element.innerHTML = choices[i];
            handleOptionButton('btn'+i, choices[i]);
        }
        showProgress();
    }
};

function showProgress() {
    var currentQuestionNumber = q.questionIndex +1;
    var element = document.getElementById('progress');
    element.innerHTML = 'Question' + currentQuestionNumber + 'of' + questions.length;
    
};

function showScores() {    
    var quizOver = "<h1>Results</h1>";
    quizOver += "<h2 id='score'>Your Scores " + q.score + " and your score is " + ((q.score/questions.length)*100) + "%</h2>";
    var element = document.getElementById('quiz');
    element.innerHTML = quizOver;
};

function handleOptionButton(id, choice) {
    var button = document.getElementById(id);
    button.onclick = function() {
        q.checkOptionsWithAnswer(choice);
        loadQuestions();
    }
};
loadQuestions();
