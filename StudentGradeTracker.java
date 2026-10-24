import java.util.ArrayList;
import java.util.Scanner;

class Student {
String name;
double marks;

Student(String name, double marks) {
    this.name = name;
    this.marks = marks;
}

}

public class StudentGradeTracker {

static ArrayList<Student> students = new ArrayList<>();
static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {

    int choice;

    do {
        System.out.println("\n===== STUDENT GRADE TRACKER =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Calculate Average Marks");
        System.out.println("4. Find Highest Marks");
        System.out.println("5. Find Lowest Marks");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        while (!sc.hasNextInt()) {
            System.out.print("Please enter a number from 1 to 6: ");
            sc.next();
        }

        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                addStudent();
                break;

            case 2:
                displayStudents();
                break;

            case 3:
                calculateAverage();
                break;

            case 4:
                findHighest();
                break;

            case 5:
                findLowest();
                break;

            case 6:
                System.out.println("Thank you for using Student Grade Tracker!");
                break;

            default:
                System.out.println("Invalid choice. Please select 1 to 6.");
        }

    } while (choice != 6);

    sc.close();
}

static void addStudent() {

    System.out.print("Enter student name: ");
    String name = sc.nextLine().trim();

    if (name.isEmpty()) {
        System.out.println("Student name cannot be empty.");
        return;
    }

    System.out.print("Enter marks out of 100: ");

    if (!sc.hasNextDouble()) {
        System.out.println("Invalid marks. Please enter a number.");
        sc.nextLine();
        return;
    }

    double marks = sc.nextDouble();
    sc.nextLine();

    if (marks < 0 || marks > 100) {
        System.out.println("Marks must be between 0 and 100.");
        return;
    }

    students.add(new Student(name, marks));
    System.out.println("Student added successfully!");
}

static void displayStudents() {

    if (students.isEmpty()) {
        System.out.println("No student records available.");
        return;
    }

    System.out.println("\n===== STUDENT REPORT =====");

    System.out.printf("%-20s %10s%n", "Student Name", "Marks");
    System.out.println("--------------------------------");

    for (Student s : students) {
        System.out.printf("%-20s %10.2f%n", s.name, s.marks);
    }
}

static void calculateAverage() {

    if (students.isEmpty()) {
        System.out.println("Please add students first.");
        return;
    }

    double total = 0;

    for (Student s : students) {
        total += s.marks;
    }

    double average = total / students.size();

    System.out.printf("Average marks: %.2f%n", average);
}

static void findHighest() {

    if (students.isEmpty()) {
        System.out.println("Please add students first.");
        return;
    }

    Student highest = students.get(0);

    for (Student s : students) {
        if (s.marks > highest.marks) {
            highest = s;
        }
    }

    System.out.println("Highest marks: " + highest.marks);
    System.out.println("Student name: " + highest.name);
}

static void findLowest() {

    if (students.isEmpty()) {
        System.out.println("Please add students first.");
        return;
    }

    Student lowest = students.get(0);

    for (Student s : students) {
        if (s.marks < lowest.marks) {
            lowest = s;
        }
    }

    System.out.println("Lowest marks: " + lowest.marks);
    System.out.println("Student name: " + lowest.name);
}

}