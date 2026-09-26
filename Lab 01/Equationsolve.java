import java.util.Scanner;

public class Equationsolve {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Equation Solver ---");
        System.out.println("1. First-degree equation with one variable (ax + b = 0)");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation with one variable (ax^2 + bx + c = 0)");
        System.out.print("Select an option (1-3): ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                solveLinearEquation(scanner);
                break;
            case 2:
                solveLinearSystem(scanner);
                break;
            case 3:
                solveQuadraticEquation(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        
        scanner.close();
    }
    private static void solveLinearEquation(Scanner scanner) {
        System.out.println("\n-- First-degree equation (ax + b = 0) --");
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }
    private static void solveLinearSystem(Scanner scanner) {
        System.out.println("\n-- System of linear equations --");
        System.out.println("Format: a11*x1 + a12*x2 = b1");
        System.out.println("        a21*x1 + a22*x2 = b2");
        System.out.print("Enter a11: "); double a11 = scanner.nextDouble();
        System.out.print("Enter a12: "); double a12 = scanner.nextDouble();
        System.out.print("Enter b1: ");  double b1 = scanner.nextDouble();
        System.out.print("Enter a21: "); double a21 = scanner.nextDouble();
        System.out.print("Enter a22: "); double a22 = scanner.nextDouble();
        System.out.print("Enter b2: ");  double b2 = scanner.nextDouble();
        double d = a11 * a22 - a21 * a12;
        double d1 = b1 * a22 - b2 * a12;
        double d2 = a11 * b2 - a21 * b1;
        if (d == 0) {
            if (d1 == 0 && d2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = d1 / d;
            double x2 = d2 / d;
            System.out.println("The system has a unique solution:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
    private static void solveQuadraticEquation(Scanner scanner) {
        System.out.println("\n-- Second-degree equation (ax^2 + bx + c = 0) --");
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Coefficient 'a' is 0. Treating as a first-degree equation (bx + c = 0).");
            if (b == 0) {
                if (c == 0) {
                    System.out.println("The equation has infinitely many solutions.");
                } else {
                    System.out.println("The equation has no solution.");
                }
            } else {
                double x = -c / b;
                System.out.println("The solution is x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;
            
            if (delta < 0) {
                System.out.println("The equation has no real roots.");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("The equation has a double root: x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("The equation has two distinct real roots:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        }
    }
}