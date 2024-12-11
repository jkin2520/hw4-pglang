package geometry;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * GeometryApp provides a REPL for managing geometrical shapes.
 */
public class GeometryApp {
    private static GeometryLinkedList geometryList = new GeometryLinkedList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Geometry Management System!");
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addGeometry();
                    break;
                case 2:
                    removeGeometry();
                    break;
                case 3:
                    findGeometry();
                    break;
                case 4:
                    listAllGeometries();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the Geometry Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-5).");
            }
        }

        scanner.close();
    }

    /**
     * Prints the main menu options.
     */
    private static void printMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Add Geometry");
        System.out.println("2. Remove Geometry by Index");
        System.out.println("3. Find Geometry by Index");
        System.out.println("4. List All Geometries");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
    }

    /**
     * Retrieves and validates the user's menu choice.
     * 
     * @return The chosen menu option as an integer.
     */
    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            // Invalid input; choice remains -1
        }
        return choice;
    }

    /**
     * Handles adding a new geometry to the linked list.
     */
    private static void addGeometry() {
        System.out.println("\nChoose the type of geometry to add:");
        System.out.println("1. Triangle (2D)");
        System.out.println("2. Rectangle (2D)");
        System.out.println("3. Circle (2D)");
        System.out.println("4. Sphere (3D)");
        System.out.println("5. Rectangular Prism (3D)");
        System.out.println("6. Triangular Prism (3D)");
        System.out.print("Your choice: ");

        int typeChoice = getUserChoice();
        Geometry geometry = null;

        try {
            switch (typeChoice) {
                case 1:
                    geometry = createTriangle();
                    break;
                case 2:
                    geometry = createRectangle();
                    break;
                case 3:
                    geometry = createCircle();
                    break;
                case 4:
                    geometry = createSphere();
                    break;
                case 5:
                    geometry = createRectangularPrism();
                    break;
                case 6:
                    geometry = createTriangularPrism();
                    break;
                default:
                    System.out.println("Invalid geometry type selected.");
                    return;
            }

            if (geometry != null) {
                geometryList.add(geometry);
                System.out.println("Geometry added successfully: " + geometry.toString());
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error adding geometry: " + e.getMessage());
        }
    }

    /**
     * Handles removing a geometry from the linked list by index.
     */
    private static void removeGeometry() {
        System.out.print("\nEnter the index of the geometry to remove: ");
        int index = getUserChoice();

        boolean removed = geometryList.removeByIndex(index);
        if (removed) {
            System.out.println("Geometry at index " + index + " removed successfully.");
        } else {
            System.out.println("Failed to remove geometry at index " + index + ". Please ensure the index is valid.");
        }
    }

    /**
     * Handles finding and displaying a geometry from the linked list by index.
     */
    private static void findGeometry() {
        System.out.print("\nEnter the index of the geometry to find: ");
        int index = getUserChoice();

        Geometry found = geometryList.findByIndex(index);
        if (found != null) {
            System.out.println("Geometry at index " + index + ": " + found.toString());
        } else {
            System.out.println("No geometry found at index " + index + ".");
        }
    }

    /**
     * Lists all geometries stored in the linked list.
     */
    private static void listAllGeometries() {
        System.out.println("\nListing all geometries:");
        if (geometryList.size() == 0) {
            System.out.println("No geometries stored.");
            return;
        }

        geometryList.printAll();
    }

    /**
     * Prompts the user to input sides for a Triangle and creates a Triangle object.
     * 
     * @return A new Triangle instance.
     */
    private static Triangle createTriangle() {
        System.out.println("\nCreating a Triangle:");
        double sideA = getPositiveDouble("Enter length of side A: ");
        double sideB = getPositiveDouble("Enter length of side B: ");
        double sideC = getPositiveDouble("Enter length of side C: ");
        return new Triangle(sideA, sideB, sideC);
    }

    /**
     * Prompts the user to input dimensions for a Rectangle and creates a Rectangle object.
     * 
     * @return A new Rectangle instance.
     */
    private static Rectangle createRectangle() {
        System.out.println("\nCreating a Rectangle:");
        double length = getPositiveDouble("Enter length: ");
        double width = getPositiveDouble("Enter width: ");
        return new Rectangle(length, width);
    }

    /**
     * Prompts the user to input the radius for a Circle and creates a Circle object.
     * 
     * @return A new Circle instance.
     */
    private static Circle createCircle() {
        System.out.println("\nCreating a Circle:");
        double radius = getPositiveDouble("Enter radius: ");
        return new Circle(radius);
    }

    /**
     * Prompts the user to input the radius for a Sphere and creates a Sphere object.
     * 
     * @return A new Sphere instance.
     */
    private static Sphere createSphere() {
        System.out.println("\nCreating a Sphere:");
        double radius = getPositiveDouble("Enter radius: ");
        return new Sphere(radius);
    }

    /**
     * Prompts the user to input dimensions for a Rectangular Prism and creates a RectangularPrism object.
     * 
     * @return A new RectangularPrism instance.
     */
    private static RectangularPrism createRectangularPrism() {
        System.out.println("\nCreating a Rectangular Prism:");
        double length = getPositiveDouble("Enter length: ");
        double width = getPositiveDouble("Enter width: ");
        double height = getPositiveDouble("Enter height: ");
        return new RectangularPrism(length, width, height);
    }

    /**
     * Prompts the user to input dimensions for a Triangular Prism and creates a TriangularPrism object.
     * 
     * @return A new TriangularPrism instance.
     */
    private static TriangularPrism createTriangularPrism() {
        System.out.println("\nCreating a Triangular Prism:");
        double sideA = getPositiveDouble("Enter length of side A of the triangular base: ");
        double sideB = getPositiveDouble("Enter length of side B of the triangular base: ");
        double sideC = getPositiveDouble("Enter length of side C of the triangular base: ");
        double height = getPositiveDouble("Enter height (length) of the prism: ");
        return new TriangularPrism(sideA, sideB, sideC, height);
    }

    /**
     * Prompts the user to enter a positive double value.
     * 
     * @param prompt The message to display to the user.
     * @return A positive double entered by the user.
     */
    private static double getPositiveDouble(String prompt) {
        double value = -1;
        while (value <= 0) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                value = Double.parseDouble(input);
                if (value <= 0) {
                    System.out.println("Value must be positive. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numerical value.");
                value = -1;
            }
        }
        return value;
    }
}
