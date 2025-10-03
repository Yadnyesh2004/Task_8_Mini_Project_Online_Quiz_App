# 🎯 Console-Based Quiz Application

### **1. Import Statements**
```java
import java.util.*;
```
- Imports all utility classes from java.util package
- Provides access to Scanner (for input), ArrayList, List, and Arrays classes

---

### **2. Question Class Declaration**

```java
class Question {
```
- Defines a blueprint for creating question objects
- This is a separate class to organize quiz question data

#### **2.1 Private Instance Variables**
```java
private String questionText;
private List<String> options;
private int correctAnswer;
```
- `questionText`: Stores the actual question as a String
- `options`: A List that holds 4 answer choices as Strings
- `correctAnswer`: Stores the index (1-4) of the correct answer
- All marked `private` for encapsulation (data hiding)

#### **2.2 Constructor**
```java
public Question(String questionText, List<String> options, int correctAnswer) {
    this.questionText = questionText;
    this.options = options;
    this.correctAnswer = correctAnswer;
}
```
- Constructor to initialize a Question object
- Takes 3 parameters: question text, list of options, and correct answer index
- `this` keyword refers to current object's instance variables
- Assigns parameter values to instance variables

#### **2.3 Getter Methods**
```java
public String getQuestionText() {
    return questionText;
}

public List<String> getOptions() {
    return options;
}
```
- `getQuestionText()`: Returns the question text
- `getOptions()`: Returns the list of answer options
- These allow controlled access to private variables

#### **2.4 Answer Validation Method**
```java
public boolean checkAnswer(int userAnswer) {
    return userAnswer == correctAnswer;
}
```
- Compares user's answer with the correct answer
- Returns `true` if they match, `false` otherwise
- Uses comparison operator `==`

#### **2.5 Correct Answer Getter**
```java
public int getCorrectAnswer() {
    return correctAnswer;
}
```
- Returns the correct answer index
- Used to display correct answer when user is wrong

---

### **3. QuizApp Class Declaration**

```java
public class QuizApp {
```
- Main class marked `public` so it can be accessed from anywhere
- Contains the `main` method to run the application

#### **3.1 Instance Variables**
```java
private List<Question> questions;
private int score;
private Scanner scanner;
```
- `questions`: ArrayList to store all Question objects
- `score`: Integer to track correct answers (starts at 0)
- `scanner`: Scanner object to read user input from console

#### **3.2 Constructor**
```java
public QuizApp() {
    questions = new ArrayList<>();
    score = 0;
    scanner = new Scanner(System.in);
    initializeQuestions();
}
```
- Initializes the QuizApp object
- Creates empty ArrayList for questions
- Sets initial score to 0
- Creates Scanner object connected to standard input (keyboard)
- Calls `initializeQuestions()` to populate questions

---

### **4. initializeQuestions() Method**

```java
private void initializeQuestions() {
```
- Private method to set up all quiz questions
- Called automatically when QuizApp object is created

#### **4.1 Adding Questions**
```java
questions.add(new Question(
    "What is the capital of France?",
    Arrays.asList("1. London", "2. Paris", "3. Berlin", "4. Madrid"),
    2
));
```
- `questions.add()`: Adds a new Question to the list
- `new Question(...)`: Creates a new Question object
- First parameter: The question text
- Second parameter: `Arrays.asList()` creates a List from array elements
- Third parameter: 2 (indicating option 2 "Paris" is correct)
- This pattern repeats for all 5 questions

**Point of Each Question:**
1. **Question 1**: Geography question about France's capital
2. **Question 2**: Astronomy question about Mars
3. **Question 3**: Math question (addition: 15 + 27)
4. **Question 4**: Art history question about Mona Lisa
5. **Question 5**: Geography question about largest ocean

---

### **5. startQuiz() Method**

```java
public void startQuiz() {
```
- Main method that runs the entire quiz
- Public so it can be called from `main` method

#### **5.1 Welcome Display**
```java
System.out.println("================================");
System.out.println("   WELCOME TO THE QUIZ APP!");
System.out.println("================================");
System.out.println("Total Questions: " + questions.size());
System.out.println("Enter the number of your answer (1-4)\n");
```
- `System.out.println()`: Prints text to console with newline
- Displays welcome banner with formatting
- `questions.size()`: Returns number of questions in the list (5)
- Provides instructions to user

#### **5.2 Main Quiz Loop**
```java
for (int i = 0; i < questions.size(); i++) {
```
- `for` loop iterates through all questions
- `i` starts at 0, continues while less than total questions
- `i++` increments after each iteration

#### **5.3 Display Question**
```java
displayQuestion(i + 1, questions.get(i));
```
- Calls `displayQuestion()` method
- `i + 1`: Converts 0-based index to 1-based question number for display
- `questions.get(i)`: Retrieves the Question object at index i

#### **5.4 Get User Answer**
```java
int userAnswer = getUserAnswer();
```
- Calls `getUserAnswer()` method
- Stores the validated user input in `userAnswer` variable

#### **5.5 Check Answer & Update Score**
```java
if (questions.get(i).checkAnswer(userAnswer)) {
    System.out.println("✓ Correct!\n");
    score++;
} else {
    System.out.println("✗ Wrong! The correct answer was: " + 
        questions.get(i).getCorrectAnswer() + "\n");
}
```
- `if` statement checks if answer is correct
- Calls `checkAnswer()` method from Question object
- If correct: Prints success message and increments score by 1
- If wrong: Prints failure message with correct answer
- `score++` is shorthand for `score = score + 1`

#### **5.6 Display Results**
```java
displayResults();
```
- After loop ends, calls method to show final results

---

### **6. displayQuestion() Method**

```java
private void displayQuestion(int questionNumber, Question question) {
```
- Takes question number (for display) and Question object
- Formats and displays the question with options

#### **6.1 Display Question Text**
```java
System.out.println("Question " + questionNumber + ": " + question.getQuestionText());
```
- Prints question number and text
- Uses string concatenation with `+` operator

#### **6.2 Display Options**
```java
for (String option : question.getOptions()) {
    System.out.println(option);
}
```
- Enhanced `for` loop (for-each loop)
- Iterates through each option in the list
- Prints each option on a new line

#### **6.3 Prompt for Answer**
```java
System.out.print("Your answer: ");
```
- `System.out.print()`: Prints without newline (cursor stays on same line)
- Prompts user to enter their answer

---

### **7. getUserAnswer() Method**

```java
private int getUserAnswer() {
```
- Handles user input with validation
- Returns a valid integer between 1 and 4

#### **7.1 Initialize Variables**
```java
int answer = -1;
boolean validInput = false;
```
- `answer`: Stores user's answer, initialized to -1 (invalid value)
- `validInput`: Flag to control the validation loop, starts as false

#### **7.2 Validation Loop**
```java
while (!validInput) {
```
- `while` loop continues as long as input is invalid
- `!validInput` means "not valid" (while validInput is false)

#### **7.3 Try-Catch Block**
```java
try {
    answer = scanner.nextInt();
```
- `try` block attempts to read an integer
- `scanner.nextInt()`: Reads next integer from input
- May throw `InputMismatchException` if input isn't a number

#### **7.4 Range Validation**
```java
if (answer >= 1 && answer <= 4) {
    validInput = true;
} else {
    System.out.print("Please enter a number between 1 and 4: ");
}
```
- Checks if answer is in valid range (1-4)
- `&&` is logical AND operator (both conditions must be true)
- If valid: Sets flag to true (exits loop)
- If invalid: Prompts user to try again

#### **7.5 Exception Handling**
```java
} catch (InputMismatchException e) {
    System.out.print("Invalid input! Please enter a number (1-4): ");
    scanner.next();
}
```
- `catch` block executes if exception is thrown
- Prints error message
- `scanner.next()`: Clears the invalid input from scanner buffer
- Loop continues, prompting user again

#### **7.6 Return Value**
```java
return answer;
```
- Returns the validated answer to calling method

---

### **8. displayResults() Method**

```java
private void displayResults() {
```
- Shows final quiz results and performance evaluation

#### **8.1 Results Header**
```java
System.out.println("================================");
System.out.println("         QUIZ COMPLETED!");
System.out.println("================================");
```
- Displays formatted header for results section

#### **8.2 Display Score**
```java
System.out.println("Your Score: " + score + "/" + questions.size());
```
- Shows score in format "X/Y" (e.g., "4/5")
- Concatenates score and total questions

#### **8.3 Calculate Percentage**
```java
double percentage = (score * 100.0) / questions.size();
```
- Calculates percentage score
- `score * 100.0`: Multiplies by 100.0 (double) to get decimal result
- Divides by total questions
- Result stored as `double` for decimal precision

#### **8.4 Display Percentage**
```java
System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
```
- `String.format("%.2f", percentage)`: Formats number to 2 decimal places
- `%.2f` is format specifier (2 digits after decimal point)

#### **8.5 Performance Message**
```java
System.out.println("\nPerformance: " + getPerformanceMessage(percentage));
System.out.println("================================");
```
- Calls `getPerformanceMessage()` with percentage
- `\n` creates blank line before performance message
- Prints closing border

---

### **9. getPerformanceMessage() Method**

```java
private String getPerformanceMessage(double percentage) {
```
- Evaluates performance based on percentage
- Returns appropriate feedback message

#### **9.1 Performance Logic**
```java
if (percentage >= 80) {
    return "Excellent! 🌟";
} else if (percentage >= 60) {
    return "Good Job! 👍";
} else if (percentage >= 40) {
    return "Not Bad! Keep Practicing! 📚";
} else {
    return "Need More Practice! 💪";
}
```
- Nested `if-else` statements evaluate percentage
- **80% or higher**: Excellent rating
- **60-79%**: Good rating
- **40-59%**: Average rating
- **Below 40%**: Needs improvement
- Returns String based on performance tier

---

### **10. main() Method**

```java
public static void main(String[] args) {
    QuizApp quiz = new QuizApp();
    quiz.startQuiz();
}
```
- Entry point of the program
- `public static void`: Standard signature for main method
- `String[] args`: Command line arguments (not used here)
- Creates new QuizApp object (triggers constructor)
- Calls `startQuiz()` to begin the quiz

---

## 🔄 Program Flow Summary

1. **Program starts** → main() method executes
2. **QuizApp object created** → Constructor initializes variables and questions
3. **startQuiz() called** → Displays welcome message
4. **Loop through questions** → For each question:
    - Display question and options
    - Get user input with validation
    - Check answer and update score
    - Provide immediate feedback
5. **Display results** → Show final score, percentage, and performance
6. **Program ends**

---

## 🎯 Key Programming Concepts Demonstrated

1. **Object-Oriented Programming**: Classes, objects, encapsulation
2. **Data Structures**: ArrayList, List interface
3. **Control Flow**: if-else, for loops, while loops
4. **Exception Handling**: try-catch blocks
5. **Input Validation**: Ensuring correct data types and ranges
6. **Method Design**: Breaking code into reusable methods
7. **String Manipulation**: Concatenation and formatting
8. **Boolean Logic**: Logical operators and conditions