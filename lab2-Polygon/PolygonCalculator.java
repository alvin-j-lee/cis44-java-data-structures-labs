import java.util.Scanner;

/*
    User interface class
 */

public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a polygon: (1) Rectangle (2) Square (3) Equilateral Triangle");

        int choice = scanner.nextInt();

        Polygon polygon = null;

        if (choice == 1) {
            System.out.print("Enter length: ");
            double length = scanner.nextDouble();
            System.out.print("Enter width: ");
            double width = scanner.nextDouble();
            polygon = new Rectangle(length, width);
        } else if (choice == 2) {
            System.out.print("Enter side length: ");
            double side = scanner.nextDouble();
            polygon = new Square(side);
        } else if (choice == 3) {
            System.out.print("Enter side length: ");
            double side = scanner.nextDouble();
            polygon = new EquilateralTriangle(side);
        }
        else {
            System.out.println("Invalid choice!");
            System.exit(0);
        }

        System.out.println("Area: " + polygon.area());
        System.out.println("Perimeter: " + polygon.perimeter());

        scanner.close();

    }
}
