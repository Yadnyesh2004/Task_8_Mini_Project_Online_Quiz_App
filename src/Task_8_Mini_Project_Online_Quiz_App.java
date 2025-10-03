import java.util.*;

// Question class to represent each quiz question
class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswer;

    public Question(String questionText, List<String> options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

// Main Quiz Application
public class Task_8_Mini_Project_Online_Quiz_App {
    private List<Question> questions;
    private int score;
    private Scanner scanner;

    public Task_8_Mini_Project_Online_Quiz_App() {
        questions = new ArrayList<>();
        score = 0;
        scanner = new Scanner(System.in);
        initializeQuestions();
    }

    private void initializeQuestions() {
        // Question 1
        questions.add(new Question(
                "What is the capital of France?",
                Arrays.asList("1. London", "2. Paris", "3. Berlin", "4. Madrid"),
                2
        ));

        // Question 2
        questions.add(new Question(
                "Which planet is known as the Red Planet?",
                Arrays.asList("1. Venus", "2. Jupiter", "3. Mars", "4. Saturn"),
                3
        ));

        // Question 3
        questions.add(new Question(
                "What is 15 + 27?",
                Arrays.asList("1. 40", "2. 42", "3. 43", "4. 45"),
                2
        ));

        // Question 4
        questions.add(new Question(
                "Who painted the Mona Lisa?",
                Arrays.asList("1. Vincent van Gogh", "2. Pablo Picasso", "3. Leonardo da Vinci", "4. Michelangelo"),
                3
        ));

        // Question 5
        questions.add(new Question(
                "What is the largest ocean on Earth?",
                Arrays.asList("1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"),
                4
        ));
    }

    public void startQuiz() {
        System.out.println("================================");
        System.out.println("   WELCOME TO THE QUIZ APP!");
        System.out.println("================================");
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Enter the number of your answer (1-4)\n");

        for (int i = 0; i < questions.size(); i++) {
            displayQuestion(i + 1, questions.get(i));
            int userAnswer = getUserAnswer();

            if (questions.get(i).checkAnswer(userAnswer)) {
                System.out.println("✓ Correct!\n");
                score++;
            } else {
                System.out.println("✗ Wrong! The correct answer was: " +
                        questions.get(i).getCorrectAnswer() + "\n");
            }
        }

        displayResults();
    }

    private void displayQuestion(int questionNumber, Question question) {
        System.out.println("Question " + questionNumber + ": " + question.getQuestionText());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
        System.out.print("Your answer: ");
    }

    private int getUserAnswer() {
        int answer = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                answer = scanner.nextInt();
                if (answer >= 1 && answer <= 4) {
                    validInput = true;
                } else {
                    System.out.print("Please enter a number between 1 and 4: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Please enter a number (1-4): ");
                scanner.next(); // Clear invalid input
            }
        }

        return answer;
    }

    private void displayResults() {
        System.out.println("================================");
        System.out.println("         QUIZ COMPLETED!");
        System.out.println("================================");
        System.out.println("Your Score: " + score + "/" + questions.size());

        double percentage = (score * 100.0) / questions.size();
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");

        System.out.println("\nPerformance: " + getPerformanceMessage(percentage));
        System.out.println("================================");
    }

    private String getPerformanceMessage(double percentage) {
        if (percentage >= 80) {
            return "Excellent! 🌟";
        } else if (percentage >= 60) {
            return "Good Job! 👍";
        } else if (percentage >= 40) {
            return "Not Bad! Keep Practicing! 📚";
        } else {
            return "Need More Practice! 💪";
        }
    }

    public static void main(String[] args) {
        Task_8_Mini_Project_Online_Quiz_App quiz = new Task_8_Mini_Project_Online_Quiz_App();
        quiz.startQuiz();
    }
}