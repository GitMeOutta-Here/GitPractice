import java.util.ArrayList;
import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        boolean exitCase = true;

            try (Scanner scanner = new Scanner(System.in)) {
                while (exitCase) {
                System.out.print("Enter the name of the student (First Last) or type 'exit' to quit: "); //get student info
                String firstAndLast = scanner.nextLine();
                if (firstAndLast.equalsIgnoreCase("exit")) {
                    exitCase = false;
                    break;
                }
                
                String[] nameParts = firstAndLast.split(" "); //create array to split first and last
                String firstName = nameParts[0];//first name is first part of array
                String lastName = nameParts[1]; //last name is second part of array

                System.out.print("Enter the major of the student: ");
                String major = scanner.nextLine();
                System.out.print("Enter the GPA of the student: ");
                double gpa = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                Student student = new Student(firstName, lastName, major, gpa); //create a new Student object with user input
                students.add(student); //Add the student to the ArrayList
            }
            for (Student student : students) {
                System.out.println("--------------------------------------------------");
                System.out.println("Student Information " + "(Student #" + (students.indexOf(student) + 1) + "):");
                System.out.println("Student: " + student.getFirstAndLast(student));
                System.out.println("Major: " + student.getMajor(student));
                System.out.println("GPA: " + student.getGpa(student));
                if (students.indexOf(student) == students.size() - 1) {
                    System.out.println("--------------------------------------------------");
                }
            }
            while (exitCase) {
                System.out.print("Would you like to change any of the students information (yes or no)? ");
                String change = scanner.nextLine();
                if(change.equalsIgnoreCase("no")) {
                    break;
                }

                System.out.print("Which student would you like to change (enter the Student #): ");
                int studentIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consume the newline character
                if (studentIndex < 0 || studentIndex >= students.size()) {
                    System.out.println("Invalid student number. Please try again.");
                    continue;
                }
                else {
                    Student studentToChange = students.get(studentIndex);
                    System.out.print("What would you like to change (full name, first name, last name, major, or GPA)? ");
                    String changeField = scanner.nextLine();
                    if (changeField.equalsIgnoreCase("full name")) {
                        System.out.print("Enter the new full name (first and last): ");
                        String newName = scanner.nextLine();

                        String[] newNameParts = newName.split(" "); //See above comment
                        String newFirst = newNameParts[0];
                        String newLast = newNameParts[1];

                        studentToChange.setFirstandLast(studentToChange, newFirst, newLast);
                        }
                    else if (changeField.equalsIgnoreCase("first name")) {
                        System.out.print("Enter the new first name: ");
                        String newFirst = scanner.nextLine();
                        studentToChange.setFirst(studentToChange, newFirst);
                        }
                    else if (changeField.equalsIgnoreCase("last name")) {
                        System.out.print("Enter the new last name: ");
                        String newLast = scanner.nextLine();
                        studentToChange.setLast(studentToChange, newLast);
                        }
                    else if (changeField.equalsIgnoreCase("major")) {
                        System.out.print("Enter the new major: ");
                        String newMajor = scanner.nextLine();
                        studentToChange.setMajor(studentToChange, newMajor);
                        }
                    else if (changeField.equalsIgnoreCase("GPA")) {
                        System.out.print("Enter the new GPA: ");
                        double newGpa = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        studentToChange.setGpa(studentToChange, newGpa);      
                        }
                    }
                }
                for (Student student : students) {
                System.out.println("--------------------------------------------------");
                System.out.println("Revised Student Information " + "(Student #" + (students.indexOf(student) + 1) + "):");
                System.out.println("Student: " + student.getFirstAndLast(student));
                System.out.println("Major: " + student.getMajor(student));
                System.out.println("GPA: " + student.getGpa(student));
                if (students.indexOf(student) == students.size() - 1) {
                    System.out.println("--------------------------------------------------");
                }
            }
        }
    }
}