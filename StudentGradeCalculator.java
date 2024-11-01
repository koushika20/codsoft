import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input marks for each subject
        System.out.print("Enter marks for subject 1 (out of 100): ");
        int subject1 = scanner.nextInt();
        System.out.print("Enter marks for subject 2 (out of 100): ");
        int subject2 = scanner.nextInt();
        System.out.print("Enter marks for subject 3 (out of 100): ");
        int subject3 = scanner.nextInt();
        
        // Calculate total marks
        int totalMarks = subject1 + subject2 + subject3;
        
        // Calculate average percentage
        double averagePercentage = (totalMarks * 1.0) / 3;
        
        // Assign grade based on average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        // Display results
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
    }
}