import java.util.*;
public class Quiz {
    private String question;
    private String[] options;
    private int correctAnswer;

    public Quiz(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

 class QuizApplication {
    private static final int TIME_LIMIT = 30; // Time limit in seconds
    private Quiz[] quizzes;
    private int currentQuestionIndex;
    private int score;
    private long startTime;

    public QuizApplication(Quiz[] quizzes) {
        this.quizzes = quizzes;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        startTime = System.currentTimeMillis();

        while (currentQuestionIndex < quizzes.length) {
            Quiz currentQuiz = quizzes[currentQuestionIndex];
            displayQuestion(currentQuiz);
            int userAnswer = getUserAnswer(scanner, currentQuiz.getOptions());

            if (userAnswer == currentQuiz.getCorrectAnswer()) {
                score++;
            }

            currentQuestionIndex++;
            if (currentQuestionIndex < quizzes.length) {
                checkTimeLimit();
            }
        }

        displayResults();
    }

    private void displayQuestion(Quiz quiz) {
        System.out.println(quiz.getQuestion());
        String[] options = quiz.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private int getUserAnswer(Scanner scanner, String[] options) {
        System.out.print("Enter your answer (1-" + options.length + "): ");
        return scanner.nextInt();
    }

    private void checkTimeLimit() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime / 1000 >= TIME_LIMIT) {
            System.out.println("Time's up! Moving to the next question.");
        }
    }

    private void displayResults() {
        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + " out of " + quizzes.length);
    }

    public static void main(String[] args) {
        Quiz[] quizzes = {
            new Quiz("What is the capital of France?", new String[]{"Paris", "London", "Rome", "Berlin"}, 1),
            new Quiz("What is the largest ocean in the world?", new String[]{"Pacific", "Atlantic", "Indian", "Arctic"}, 1),
            new Quiz("Who invented the telephone?", new String[]{"Alexander Graham Bell", "Thomas Edison", "Nikola Tesla", "Guglielmo Marconi"}, 1)
        };

        QuizApplication quizApp = new QuizApplication(quizzes);
        quizApp.start();
    }
}