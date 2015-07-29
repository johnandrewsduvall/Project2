Project 2 - Movie Quiz 101
by Jesse Steinberg (jmsteinb) and John Andrew Duvall  (jsduvall)

||Packages||
edu.ncsu.csc216.movie101.question
-Contains classes for building questions and controlling the execution and sequence of the quiz.

	||Classes||
	MovieQuestions
	-A Finite State Machine that take the specific lists of questions and handles the transition between the question states, built with nested classes.
	
		AdvancedQuestionState
		-Nested class that builds and defines advanced level questions

		StandardQuestionState
		-Nested class that builds and defines standard level questions

		ElementaryQuestionState
		-Nested class that builds and defines elementary level questions

edu.ncsu.csc216.movie101.quiz
-Coordinates between the front end UI and the back-end elements of the question package as well and sending the filename to the question_libaray package and receving the question lists back from the question_library package.

	||Classes||
	MovieQuiz
	-Class containing the logic for the package, implements QuizMaster

	QuizMaster
	-provided interface defining methods used by MovieQuiz

edu.ncsu.csc216.movie101.ui
-Contains the graphical user interface for the quiz.

	||Classes||
	Movie101GUI
	-The class contains the code for the GUI and the main method.  Catches error from the rest of the program.

edu.ncsu.csc216.movie101.util
-Contains an an exception class
	||Classes||
	EmptyQuestionListException
	-Error thrown if the quiz runs out of questions of a certain type.
