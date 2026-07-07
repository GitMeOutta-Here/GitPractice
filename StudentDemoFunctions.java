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
                    System.out.println("Invalid input. Please enter a number between 1 and 5.\n");
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
            System.out.print("Enter the name of the student (First Last) or type 'exit' to stop: "); //get student info
            while (scanner.hasNextInt() || scanner.hasNextDouble()) { //check if user input is valid
                System.out.print("Invalid input. Please enter a name (First Last) or 'exit' to stop: ");
                scanner.nextLine();
            }
            String firstAndLast = scanner.nextLine();
            if (firstAndLast.equalsIgnoreCase("exit")) {
                System.out.println();
                return;
            }
            
            String[] nameParts = firstAndLast.split(" "); //create array to split first and last
            String firstName = nameParts[0];//first name is first part of array
            while(nameParts.length < 2) { //check if user input is valid
                firstName = nameParts[0];
                System.out.print("Invalid input. Please enter a name (First Last) or 'exit' to stop: ");
                firstAndLast = scanner.nextLine();
                nameParts = firstAndLast.split(" ");
                if (nameParts[0].equalsIgnoreCase("exit")) {
                    System.out.println();
                    return;
                }
            }
            String lastName = nameParts[1]; //last name is second part of array

            System.out.print("Enter the major of the student: ");
            while (scanner.hasNextInt() || scanner.hasNextDouble()) { 
                System.out.print("Invalid input. Please enter a major: ");
                scanner.nextLine();
            }
            String major = scanner.nextLine();
            System.out.print("Enter the GPA of the student (0.0 - 4.0): ");
            double checkGpa = 0;
            boolean isValidGpa = false;
            while (!isValidGpa) {
                while (!scanner.hasNextDouble()) {
                    System.out.print("Invalid input. Please enter a GPA (0.0 - 4.0): ");
                    scanner.nextLine();
                }
                    checkGpa = scanner.nextDouble();
                if (checkGpa < 0.0 || checkGpa > 4.0) {
                    System.out.print("Invalid input. Please enter a GPA (0.0 - 4.0): ");
                    scanner.nextLine();
                    continue;
                }
                else if (checkGpa >= 0.0 && checkGpa <= 4.0) {
                    isValidGpa = true;
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.print("Invalid input. Please enter a GPA (0.0 - 4.0): ");
                    scanner.nextLine();
                }
            }
            Student student = new Student(firstName, lastName, major, checkGpa); //create a new Student object with user input
            students.add(student); //Add the student to the ArrayList
        }
    }

    public static void deleteStudentInfo(ArrayList<Student> students, Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("\nNo students available to delete. Please add students first.\n");
            return;
        }
        System.out.print("Enter the Student # of the student you would like to delete: ");
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. (Enter a number between 1 and " + students.size() + "): ");
                scanner.nextLine();
            }
            int studentIndex = scanner.nextInt() - 1;
            if (studentIndex < 0 || studentIndex >= students.size()) {
                System.out.print("Invalid student number. (Enter a number between 1 and " + students.size() + "): ");
                continue;
            }
            else {
                students.remove(studentIndex);
                System.out.println("\nStudent #" + (studentIndex + 1) + " has been deleted.\n");
                return;
            }

        }
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
        boolean validInput = false;
        if (students.isEmpty()) {
            System.out.println("\nNo students available to change. Please add students first.\n");
            return;
        }
        while (true) {
            if (!validInput) {
            System.out.print("Which student would you like to change (Enter a number from 1 - " + students.size() + "): ");
            }
            else {
                System.out.print("Invalid input. (Enter a number from 1 - " + students.size() + "): ");
            }
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Invalid input. (Enter a number from 1 - " + students.size() + "): ");
            }
            int studentIndex = scanner.nextInt() - 1;
            scanner.nextLine();
            if (studentIndex < 0 || studentIndex >= students.size()) {
                validInput = true;
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
                    while (scanner.hasNextInt() || scanner.hasNextDouble()) {
                        System.out.print("Invalid input. Please enter a first name: ");
                        scanner.nextLine(); 
                    }
                    String newFirst = scanner.nextLine();
                    studentToChange.setFirst(studentToChange, newFirst);
                }
                else if (changeField.equalsIgnoreCase("last name")) {
                    System.out.print("Enter the new last name: ");
                    while (scanner.hasNextInt() || scanner.hasNextDouble()) { 
                        System.out.print("Invalid input. Please enter a last name: ");
                        scanner.nextLine();
                    }
                    String newLast = scanner.nextLine();
                    studentToChange.setLast(studentToChange, newLast);
                }
                else if (changeField.equalsIgnoreCase("major")) {
                    System.out.print("Enter the new major: ");
                    while (scanner.hasNextInt() || scanner.hasNextDouble()) {
                        System.out.print("Invalid input. Please enter a major: ");
                        scanner.nextLine();
                    }
                    String newMajor = scanner.nextLine();
                    studentToChange.setMajor(studentToChange, newMajor);
                }
                else if (changeField.equalsIgnoreCase("GPA")) {
                    System.out.print("Enter the new GPA: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Invalid input. Please enter a GPA: ");
                        scanner.nextLine();
                    }
                    double newGpa = scanner.nextDouble();
                    scanner.nextLine();
                    studentToChange.setGpa(studentToChange, newGpa);      
                }

                System.out.print("\nWould you like to change any other students' information at this time? (yes or no): ");
                while (scanner.hasNextInt() || scanner.hasNextDouble()) { 
                    System.out.print("Invalid input. Please enter 'yes' or 'no': ");
                    scanner.nextLine();
                }
                String change = scanner.nextLine();
                while (!change.equalsIgnoreCase("yes") && !change.equalsIgnoreCase("no")) {
                    System.out.print("Invalid input. Please enter 'yes' or 'no': ");
                    scanner.nextLine();
                }
                if (change.equalsIgnoreCase("no")) {
                    System.out.println();
                    return;
                }
            }
        } 
    }
}