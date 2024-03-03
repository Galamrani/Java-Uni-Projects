import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner firstScanner = new Scanner(System.in);
        Scanner secondScanner = new Scanner(System.in);

        // Get input for the first polynomial
        System.out.println("Enter coefficients and powers for the first polynomial (Enter a non-number to finish): ");
        ArrayList<Double> poly1Input = readCoefficients(firstScanner);

        // Get input for the second polynomial
        System.out.println("Enter coefficients and powers for the second polynomial (Enter a non-number to finish): ");
        ArrayList<Double> poly2Input = readCoefficients(secondScanner);

        // Create polynomials using the provided input
        Polynom poly1 = new Polynom(poly1Input);
        Polynom poly2 = new Polynom(poly2Input);

        // Display the input polynomials
        System.out.println("First polynomial: " + poly1.toString());
        System.out.println("Second polynomial: " + poly2.toString());

        // Perform addition
        ArrayList<Double> sum = poly1.plus(poly2.getPolynom());
        Polynom resultSum = new Polynom(sum);
        System.out.println("Sum: " + resultSum.toString());

        // Perform subtraction
        ArrayList<Double> difference = poly1.minus(poly2.getPolynom());
        Polynom resultDifference = new Polynom(difference);
        System.out.println("Difference: " + resultDifference.toString());

        // Perform derivative on the first polynomial
        ArrayList<Double> firstDerivative = poly1.derivative();
        Polynom resultDerivative = new Polynom(firstDerivative);
        System.out.println("Derivative of the first polynomial: " + resultDerivative.toString());

        // Perform derivative on the second polynomial
        ArrayList<Double> secondDerivative = poly2.derivative();
        resultDerivative = new Polynom(secondDerivative);
        System.out.println("Derivative of the second polynomial: " + resultDerivative.toString());

        firstScanner.close();
        secondScanner.close();
    }

    private static ArrayList<Double> readCoefficients(Scanner scanner) {
        ArrayList<Double> coefficients = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            coefficients.add(scanner.nextDouble());
        }
        return coefficients;
    }
}
