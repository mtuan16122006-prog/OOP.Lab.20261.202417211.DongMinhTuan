import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculatedouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();
            double sum = num1 + num2;
            double difference = num1 - num2;
            double product = num1 * num2;
            System.out.println("\n--- Results ---");
            System.out.println("Sum: " + sum);
            System.out.println("Difference: " + difference);
            System.out.println("Product: " + product);
            if (num2 != 0) {
                double quotient = num1 / num2;
                System.out.println("Quotient: " + quotient);
            } else {
                System.out.println("Quotient: Cannot divide by zero.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid numeric value.");
        } finally {
            scanner.close();
        }
    }
}