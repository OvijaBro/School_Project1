import java.util.Scanner;

public class projectOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ASCII art
        System.out.println("+==========================================================+");
        System.out.println("| _____ _____ ____ _____  __   _____  _   _ ____           |");
        System.out.println("||_   _| ____/ ___|_   _| \\ \\ / / _ \\| | | |  _ \\          |");
        System.out.println("|  | | |  _| \\___ \\ | |    \\ V / | | | | | | |_) |         |");
        System.out.println("|  | | | |___ ___) || |     | || |_| | |_| |  _ <          |");
        System.out.println("| _|_|_|_____|____/ |_|    _|_| \\___/_\\___/|_| \\_\\__ _____ |");
        System.out.println("|| |/ / \\ | |/ _ \\ \\      / / |   | ____|  _ \\ / ___| ____||");
        System.out.println("|| ' /|  \\| | | | \\ \\ /\\ / /| |   |  _| | | | | |  _|  _|  |");
        System.out.println("|| . \\| |\\  | |_| |\\ V  V / | |___| |___| |_| | |_| | |___ |");
        System.out.println("||_|\\_\\_| \\_|\\___/  \\_/\\_/  |_____|_____|____/ \\____|_____||");
        System.out.println("+==========================================================+");

        // Welcome message
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Welcome, " + playerName + "... you are about to be tested.");
        System.out.println("Answer correctly to proceed, but beware too many wrong answers, and you'll never learn the secrets at the end.");

        // Start Tutorial
        Quiz quiz = new Quiz(scanner, tutorialQuestions(), tutorialOptions(), tutorialAnswers());
        startQuiz(scanner, playerName, quiz, "Let us begin with some basics.");

        // Start Level One
        quiz.setQuestions(levelOneQuestions(), levelOneOptions(), levelOneAnswers());
        startQuiz(scanner, playerName, quiz, "Welcome to Level One. Answer the following riddles.");

        //Start Level Two
        quiz.setQuestions(levelTwoQuestions(), levelTwoOptions(), levelTwoAnswers());
        startQuiz(scanner, playerName, quiz, "Level Two, don't give up now.");

        // Check rewards
        showRewards(quiz.getScore());

        scanner.close();
    }

    // Utility to start and display score for a quiz round
    private static void startQuiz(Scanner scanner, String playerName, Quiz quiz, String message) {
        System.out.println(message);
        quiz.startQuiz();
        System.out.println("Good job, " + playerName + ".");
        System.out.println("Your score: " + quiz.getScore() + "/" + quiz.getTotalQuestions());
    }

    // Reward display based on score
    private static void showRewards(int score) {
        switch (score) {
            case 5 -> System.out.println("Outstanding! you have managed to excel expectations.");
            case 4 -> System.out.println("Excellent work! You found a way out of your first room.");
            case 3 -> System.out.println("Good job. You found a way out of your first room.");
            case 2 -> System.out.println("Not bad, but you can do better. You made it through, though.");
            case 1 -> System.out.println("Just a step forward, try again?");
            case 0 -> System.out.println("How unfortunate. It seems you are trapped. Try again?");
            default -> System.out.println("Score out of bounds! Please check your scoring logic.");
        }
    }

    // Sample questions and answers
    private static String[] tutorialQuestions() {
        return new String[]{
                "What is the capital of France?",
                "2 + 2 = what?",
                "How many states does the USA have?"
        };
    }

    private static String[][] tutorialOptions() {
        return new String[][]{
                {"A. London", "B. Paris", "C. Rome", "D. Madrid"},
                {"A. 3", "B. 4", "C. 5", "D. 6"},
                {"A. 60", "B. 25", "C. 50", "D. 13"}
        };
    }

    private static char[] tutorialAnswers() {
        return new char[]{'B', 'B', 'C'};
    }

    private static String[] levelOneQuestions() {
        return new String[]{
                "The more of this there is, the less you see. What is it?",
                "Turn once, what is out will not get in. I turn again, what is in will not get out. What am I?",
                "What travels faster, sound or light?",
                "Which number does every Major League Baseball player wear on April 15?"
        };
    }

    private static String[][] levelOneOptions() {
        return new String[][]{
                {"A. Fog", "B. Darkness", "C. Light", "D. Wind"},
                {"A. A door key", "B. A wheel", "C. A clock", "D. A lock"},
                {"A. Sound", "B. Light", "C. Both", "D. Neither"},
                {"A. 42", "B. 13", "C. 1", "D. 15"}
        };
    }

    private static char[] levelOneAnswers() {
        return new char[]{'B', 'D', 'B', 'A'};
    }

    private static String[] levelTwoQuestions() {
        return new String[]{
                "I can make time stand still, yet everyone keeps moving; What am I?",
                "Which ancient Greek mathematician is known as the father of Geometry?",
                "What is the longest river in Asia?",
                "In the show Friends, what is the name of Ross's pet monkey?",
                "Which country has the most Olympic medals in men's field hockey?"
        };
    }

    private static String[][] levelTwoOptions() {
        return new String[][]{
                {"A. Movie", "B. Clock", "C. Photograph", "D. Phone"},
                {"A. Euclid", "B. Aristotle", "C. Plato", "D. Haley"},
                {"A. Mekong", "B. Ganges", "C. Indus", "D. Yangtze"},
                {"A. Mickey", "B. Marcel", "C. Marty", "D. Marshall"},
                {"A. Japan", "B. India", "C. Canada", "D. U.S.A"}
        };
    }

    private static char[] levelTwoAnswers(){
        return new char[]{'C', 'A', 'D', 'B', 'B'};
    }
}

// Simplified Quiz class for better callback
class Quiz {
    private int score;
    private int totalQuestions;
    private Scanner scanner;
    private String[] questions;
    private String[][] options;
    private char[] answers;

    public Quiz(Scanner scanner, String[] questions, String[][] options, char[] answers) {
        this.scanner = scanner;
        setQuestions(questions, options, answers);
    }

    public void setQuestions(String[] questions, String[][] options, char[] answers) {
        this.questions = questions;
        this.options = options;
        this.answers = answers;
        this.totalQuestions = questions.length;
        this.score = 0;
    }

    public void startQuiz() {
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) System.out.println(option);

            char userAnswer;
            while (true) {
                System.out.print("Enter your answer (A/B/C/D): ");
                userAnswer = scanner.next().toUpperCase().charAt(0);

                // Check if the user input is valid
                if (userAnswer >= 'A' && userAnswer <= 'D') {
                    break; // valid input, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter A, B, C, or D.");
                }
            }

            // Check if the answer is correct
            if (userAnswer == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + answers[i]);
            }
            System.out.println();
        }
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }
}
