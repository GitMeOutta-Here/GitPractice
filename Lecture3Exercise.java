import java.util.Scanner;

public class Lecture3Exercise {
    public static void main(String[] args) {
        String input;
        boolean validInput = false;
        System.out.print("Please select one of the four options (square, circle, triangle, or exit): ");

        try (Scanner scanner = new Scanner(System.in)) {
            input = scanner.nextLine();
        
        while (!input.equalsIgnoreCase("exit")) {

            if (input.equalsIgnoreCase("square")) {
                validInput = squareChoice(scanner, validInput);
            }
            else if (input.equalsIgnoreCase("circle")) {
                validInput = circleChoice(scanner, validInput);
            }
            else if (input.equalsIgnoreCase("triangle")) {
                validInput = triChoice(scanner, validInput);
            }
            else {
                System.out.print("Invalid input. Please select one of the four options (square, circle, triangle, or exit): ");
                input = scanner.nextLine();
                validInput = false;
            }
            if (validInput == true) {
                System.out.print("\nNice One! Please select another one of the four options (square, circle, triangle, or exit): ");
                input = scanner.nextLine();
            }
        }
    }
        System.out.print("Program exiting. Goodbye!");
    }

    public static boolean squareChoice(Scanner scanner, boolean checker) {
                checker = true;
                System.out.print("How long are the sides of the square? ");
                int sideLength = scanner.nextInt();
                scanner.nextLine();
                int area = sideLength * sideLength;
                System.out.print("The area of the square is: " + area);
                return checker;
}

    public static boolean circleChoice(Scanner scanner, boolean checker) {
                checker = true;
                System.out.print("What is the radius of the circle? ");
                int radius = scanner.nextInt();
                scanner.nextLine();
                double area = Math.PI * radius * radius;
                System.out.print("The area of the circle is: " + area);
                return checker;
}
    
    public static boolean triChoice(Scanner scanner, boolean checker) {
                checker = true;
                System.out.print("What is the base of the triangle? ");
                int base = scanner.nextInt();
                scanner.nextLine();
                System.out.print("What is the height of the triangle? ");
                int height = scanner.nextInt();
                scanner.nextLine();
                double area = 0.5 * base * height;
                System.out.print("The area of the triangle is: " + area);
                return checker;
}
}

