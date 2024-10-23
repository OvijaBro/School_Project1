import java.util.Scanner;

public class projectOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for User's name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        // Welcome message
        System.out.println("Welcome, " + playerName + "... you are about to be tested.");
        System.out.println("Before you, " + playerName + " are a series of questions and riddles.");
        System.out.println("Answer the following questions correctly and you may continue on your way.");
        System.out.println("Answer too many wrong and you have failed.");

        // Further prompt to continue
        System.out.print("Are you ready? Press Enter to proceed... ");
        scanner.nextLine();

        // Tutorial Prompt
        System.out.println("Let us begin with some basics. Answer the following questions.");

        // Creating a Quiz instance and starting the quiz
        Quiz quiz = new Quiz(scanner); // Pass scanner to the Quiz constructor
        quiz.tutorialQuiz();

        // Score display
        System.out.println("Thanks for playing, " + playerName + ".");
        System.out.println("Your final score for the first round is: " + quiz.getScore() + "/" + quiz.getTotalQuestions());

        // Depending on score, the following statements are provided.
        if (quiz.getScore() < 3) {
            System.out.println("Oh my, this game will go poorly for you. Continue to the next round? ");
            scanner.nextLine();
        } else {
            System.out.println("Good job. Are you ready to continue to the next round? ");
            scanner.nextLine();
        }

        // Start Level One (second set of questions)
        System.out.println("Welcome to Level One. Answer the following riddles.");

        levelOne levelOneQuiz = new levelOne(scanner);
        levelOneQuiz.startLevelOneQuiz();

        // Score display for Level One
        System.out.println("Your final score for Level One is: " + levelOneQuiz.getScoreOne() + "/" + levelOneQuiz.getTotalQuestionsOne());

        // Check if the player unlocked any rewards
        if (levelOneQuiz.getScoreOne() == 2) {
            System.out.println("Congratulations. Before you a key has dropped at your feet.");
        } else if (levelOneQuiz.getScoreOne() == 3) {
            System.out.println("Congratulations. Before you a key has dropped at your feet, as well as a candle.");
        } else if (levelOneQuiz.getScoreOne() == 4) {
            System.out.println("Congratulations. Before you, is a key, a candle, and a hint.");
        } else {
            System.out.println("How unfortunate for you. It seems you are trapped here. Try again?");
        }

        scanner.close(); // Close the scanner to avoid resource leaks
    }
}

// Class for the first quiz
class Quiz {
    private int score;
    private int totalQuestions;
    private Scanner scanner; // Keep the Scanner as a field

    // Sample questions for the quiz
    private String[] questions = {
            "What is the capital of France?",
            "2 + 2 = what?",
            "How many states does the USA have?"
    };

    // Sample answers (multiple choice)
    private String[][] options = {
            {"A. London", "B. Paris", "C. Rome", "D. Madrid"},
            {"A. 3", "B. 4", "C. 5", "D. 6"},
            {"A. 60", "B. 25", "C. 50", "D. 13"}
    };

    // Correct answers in correspondence with the multiple-choice questions
    private char[] correctAnswers = {'B', 'B', 'C'};

    // Constructor to initialize scanner and total questions
    public Quiz(Scanner scanner) {
        this.score = 0;
        this.totalQuestions = questions.length;
        this.scanner = scanner;
    }

    // Method to start the quiz
    public void tutorialQuiz() {
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]); // Displays questions
            for (String option : options[i]) {
                System.out.println(option); // Displays answer options
            }

            // Get user answer
            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = scanner.next().charAt(0);

            // Check if answer is correct
            if (Character.toUpperCase(userAnswer) == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + correctAnswers[i]);
            }

            System.out.println(); // Places blank line between questions
        }
    }

    // Getter for the score
    public int getScore() {
        return score;
    }

    // Getter for the total number of questions
    public int getTotalQuestions() {
        return totalQuestions;
    }
}

// Class for Level One (second set of questions)
class levelOne {
    private int scoreOne;
    private int totalQuestionsOne;
    private Scanner scanner;

    // Sample questions for Level One
    private String[] questionsOne = {
            "The more of this there is, the less you see. What is it?",
            "Turn once, what is out will not get in. I turn again, what is in will not get out. What am I?",
            "What travels faster, sound or light?",
            "Which number does every Major League Baseball player wear on April 15?"
    };

    // Sample answers (multiple choice)
    private String[][] optionsOne = {
            {"A. Fog", "B. Darkness", "C. Light", "D. Wind"},
            {"A. A door key", "B. A wheel", "C. A clock", "D. A lock"},
            {"A. Sound", "B. Light", "C. Both", "D. Neither"},
            {"A. 42", "B. 13", "C. 1", "D. 15"}
    };

    // Correct answers for Level One
    private char[] correctAnswersOne = {'B', 'D', 'B', 'A'};

    // Constructor to initialize scanner and total questions
    public levelOne(Scanner scanner) {
        this.scoreOne = 0;
        this.totalQuestionsOne = questionsOne.length;
        this.scanner = scanner;
    }

    // Method to start Level One quiz
    public void startLevelOneQuiz() {
        for (int i = 0; i < questionsOne.length; i++) {
            System.out.println(questionsOne[i]); // Displays questions
            for (String option : optionsOne[i]) {
                System.out.println(option); // Displays answer options
            }

            // Get user answer
            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = scanner.next().charAt(0);

            // Check if answer is correct
            if (Character.toUpperCase(userAnswer) == correctAnswersOne[i]) {
                System.out.println("Correct!");
                scoreOne++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + correctAnswersOne[i]);
            }

            System.out.println(); // Places blank line between questions
        }
    }

    // Getter for the score
    public int getScoreOne() {
        return scoreOne;
    }

    // Getter for the total number of questions
    public int getTotalQuestionsOne() {
        return totalQuestionsOne;
    }
}
