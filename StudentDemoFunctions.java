import java.util.ArrayList;
import java.util.Scanner;

public class StudentDemoFunctions {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        boolean exitCase = true;
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("\nWelcome to the Student Information System!");
                while (exitCase) {
                    displayMenu();
                while (!scanner.hasNextInt()) {
                    System.out.println("\nInvalid input. Please enter a number between 1 and 5.\n");
                    scanner.nextLine(); // Consume the invalid input
                    displayMenu();
                }
                int selection = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                if (selection == 1) {
                    addStudentInfo(students, scanner);
                } else if (selection == 2) {
                    displayStudentInfo(students);
                } else if (selection == 3) {
                    changeStudentInfo(students, scanner);
                } else if (selection == 4) {
                    deleteStudentInfo(students, scanner);
                } else if (selection == 5) {
                    exitCase = false;
                } else {
                    System.out.println("\nInvalid selection. Please choose a number between 1 and 5.\n");
                }
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Add Student Information");
        System.out.println("2. Display Student Information");
        System.out.println("3. Change Student Information");
        System.out.println("4. Delete Student Information");
        System.out.println("5. Exit");
        System.out.print("Enter your selection (1-5): ");
    }

    public static void addStudentInfo(ArrayList<Student> students, Scanner scanner) {
        while (true) {
            System.out.print("\nEnter the name of the student (First Last) or type 'exit' to stop: "); //get student info
            String firstAndLast = scanner.nextLine();
            if (firstAndLast.equalsIgnoreCase("exit")) {
                System.out.println();
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
    }

    public static void deleteStudentInfo(ArrayList<Student> students, Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("\nNo students available to delete. Please add students first.\n");
            return;
        }
        System.out.print("Enter the Student # of the student you would like to delete: ");
        int studentIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume the newline character
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student number. Please try again.\n");
            return;
        }
        students.remove(studentIndex);
        System.out.println("\nStudent #" + (studentIndex + 1) + " has been deleted.\n");
    }


    public static void displayStudentInfo(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("\nNo students available to display. Please add students first.\n");
            return;
        }
        for (Student student : students) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("(Student #" + (students.indexOf(student) + 1) + "'s Information): ");
            System.out.println("Name: " + student.getFirstAndLast(student));
            System.out.println("Major: " + student.getMajor(student));
            System.out.println("GPA: " + student.getGpa(student));
            if (students.indexOf(student) == students.size() - 1) {
                System.out.println("--------------------------------------------------\n");
            }
        }
    }
    public static void changeStudentInfo(ArrayList<Student> students, Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("\nNo students available to change. Please add students first.\n");
            return;
        }
        while (true) {
            System.out.print("\nWhich student would you like to change (enter the Student #): ");
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

                System.out.print("\nWould you like to change any other students' information at this time? (yes or no): ");
                String change = scanner.nextLine();
                if(change.equalsIgnoreCase("no")) {
                    System.out.println();
                    break;
                }
            }
        }
    }
}