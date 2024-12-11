package geometry;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class to run the Geometry Management REPL.
 */
public class Main {
    /**
     * Entry point of the program.
     * 
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        GeometryLinkedList geometryList = new GeometryLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Geometry Management System!");

        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addGeometry(geometryList, scanner, false);
                    break;
                case "2":
                    removeGeometry(geometryList, scanner);
                    break;
                case "3":
                    findGeometry(geometryList, scanner);
                    break;
                case "4":
                    listGeometries(geometryList);
                    break;
                case "5":
                    running = false;
                    System.out.println("Exiting the Geometry Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.\n");
            }
        }

        scanner.close();
    }

    /**
     * Prints the main menu options.
     */
    private static void printMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add a Geometry");
        System.out.println("2. Remove a Geometry");
        System.out.println("3. Find a Geometry");
        System.out.println("4. List All Geometries");
        System.out.println("5. Exit");
    }

    /**
     * Handles adding a geometry (either 2D or 3D) based on user input.
     * 
     * @param list    The GeometryLinkedList to add the geometry to.
     * @param scanner The Scanner for user input.
     * @param is3D    Flag indicating whether to add a 3D geometry.
     */
    private static void addGeometry(GeometryLinkedList list, Scanner scanner, boolean is3D) {
        if (!is3D) {
            System.out.println("\n--- Add a 2D Geometry ---");
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            System.out.println("3. Triangle");
            System.out.print("Choose a 2D geometry to add: ");
            String geomChoice = scanner.nextLine().trim();

            switch (geomChoice) {
                case "1":
                    addRectangle(list, scanner);
                    break;
                case "2":
                    addCircle(list, scanner);
                    break;
                case "3":
                    addTriangle(list, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Returning to main menu.\n");
            }
        } else {
            System.out.println("\n--- Add a 3D Geometry ---");
            System.out.println("1. Sphere");
            System.out.println("2. Rectangular Prism");
            System.out.println("3. Triangular Prism");
            System.out.print("Choose a 3D geometry to add: ");
            String geomChoice = scanner.nextLine().trim();

            switch (geomChoice) {
                case "1":
                    addSphere(list, scanner);
                    break;
                case "2":
                    addRectangularPrism(list, scanner);
                    break;
                case "3":
                    addTriangularPrism(list, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Returning to main menu.\n");
            }
        }
    }

    /**
     * Prompts user to add a Rectangle and adds it to the list.
     * 
     * @param list    The GeometryLinkedList.
     * @param scanner The Scanner for user input.
     */
    private static void addRectangle(GeometryLinkedList list, Scanner scanner) {
        try {
            System.out.print("Enter length of the Rectangle: ");
            double length = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter width of the Rectangle: ");
            double width = Double.parseDouble(scanner.nextLine());

            Rectangle rectangle = new Rectangle(length, width);
            list.add(rectangle);
            System.out.println("Rectangle added successfully.\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.\n");
        }
    }

    /**
     * Prompts user to add a Circle and adds it to the list.
     * 
     * @param list    The GeometryLinkedList.
     * @param scanner The Scanner for user input.
     */
    private static void addCircle(GeometryLinkedList list, Scanner scanner) {
        try {
            System.out.print("Enter radius of the Circle: ");
            double radius = Double.parseDouble(scanner.nextLine());

            Circle circle = new Circle(radius);
            list.add(circle);
            System.out.println("Circle added successfully.\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.\n");
        }
    }

    /**
     * Prompts user to add a Triangle and adds it to the list.
     * 
     * @param list    The GeometryLinkedList.
     * @param scanner The Scanner for user input.
     */
    private static void addTriangle(GeometryLinkedList list, Scanner scanner) {
        try {
            System.out.print("Enter length of side A: ");
            double sideA = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter length of side B: ");
            double sideB = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter length of side C: ");
            double sideC = Double.parseDouble(scanner.nextLine());

            // Optional: Validate triangle inequality here

            Triangle triangle = new Triangle(sideA, sideB, sideC);
            list.add(triangle);
            System.out.println("Triangle added successfully.\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.\n");
        }
    }

    /**
     * Prompts user to add a Sphere and adds it to the list.
     * 
     * @param list    The GeometryLinkedList.
     * @param scanner The Scanner for user input.
     */
    private static void addSphere(GeometryLinkedList list, Scanner scanner) {
        try {
            System.out.print("Enter radius of the Sphere: ");
            double radius = Double.parseDouble(scanner.nextLine());

            Sphere sphere = new Sphere(radius);
            list.add(sphere);
            System.out.println("Sphere added successfully.\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.\n");
        }
    }

    /**
     * Prompts user to add a Rectangular Prism and adds it to the list.
     * 
     * @param list    The GeometryLinkedList.
     * @param scanner The Scanner for user input.
     */
    private static void addRectangularPrism(GeometryLinkedList list, Scanner scanner) {
        try {
            System.out.print("Enter length of the Rectangular Prism: ");
            double length = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter width of the Rectangular Prism: ");
            double width = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter height of the Rectangular Prism: ");
            double height = Double.parseDouble(scanner.nextLine());

            RectangularPrism rp = new RectangularPrism(length, width, height);
            list.add(rp);
            System.out.println("Rectangular Prism added successfully.\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.\n");
        }
    }

    /**
     * Prompts user to add a Triangular Prism and adds it to the list.
     * 
     * @param list    The GeometryLinkedList.
     * @param scanner The Scanner for user input.
     */
    private static void addTriangularPrism(GeometryLinkedList list, Scanner scanner) {
        try {
            System.out.print("Enter length of side A of the Triangular Prism: ");
            double sideA = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter length of side B of the Triangular Prism: ");
            double sideB = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter length of side C of the Triangular Prism: ");
            double sideC = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter height (length) of the Triangular Prism: ");
            double height = Double.parseDouble(scanner.nextLine());

            // Optional: Validate triangle inequality here

            TriangularPrism tp = new TriangularPrism(sideA, sideB, sideC, height);
            list.add(tp);
            System.out.println("Triangular Prism added successfully.\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.\n");
        }
    }

    /**
     * Handles removing a geometry by its index.
     * 
     * @param list    The GeometryLinkedList.
     * @param scanner The Scanner for user input.
     */
    private static void removeGeometry(GeometryLinkedList list, Scanner scanner) {
        if (list.size() == 0) {
            System.out.println("No geometries to remove.\n");
            return;
        }

        list.printAll();
        try {
            System.out.print("Enter the index of the geometry to remove: ");
            int index = Integer.parseInt(scanner.nextLine());

            if (list.removeByIndex(index)) {
                System.out.println("Geometry removed successfully.\n");
            } else {
                System.out.println("Invalid index. No geometry removed.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer index.\n");
        }
    }

    /**
     * Handles finding and displaying a geometry by its index.
     * 
     * @param list    The GeometryLinkedList.
     * @param scanner The Scanner for user input.
     */
    private static void findGeometry(GeometryLinkedList list, Scanner scanner) {
        if (list.size() == 0) {
            System.out.println("No geometries to find.\n");
            return;
        }

        list.printAll();
        try {
            System.out.print("Enter the index of the geometry to find: ");
            int index = Integer.parseInt(scanner.nextLine());

            Geometry geometry = list.findByIndex(index);
            if (geometry != null) {
                System.out.println("Found: " + geometry.toString() + "\n");
            } else {
                System.out.println("Invalid index. No geometry found.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer index.\n");
        }
    }

    /**
     * Lists all geometries in the linked list.
     * 
     * @param list The GeometryLinkedList.
     */
    private static void listGeometries(GeometryLinkedList list) {
        if (list.size() == 0) {
            System.out.println("No geometries to display.\n");
        } else {
            System.out.println("\n--- List of Geometries ---");
            list.printAll();
            System.out.println();
        }
    }
}
