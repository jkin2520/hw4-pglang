package geometry;

/**
 * Represents a Triangle in 2D space.
 */
public class Triangle implements Geometry2D {
    private double sideA;
    private double sideB;
    private double sideC;

    /**
     * Constructs a Triangle with the specified side lengths.
     * 
     * @param sideA The length of side A.
     * @param sideB The length of side B.
     * @param sideC The length of side C.
     * @throws IllegalArgumentException if the sides do not satisfy the triangle inequality.
     */
    public Triangle(double sideA, double sideB, double sideC) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Invalid triangle side lengths.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Validates the triangle inequality.
     * 
     * @param a Length of side A.
     * @param b Length of side B.
     * @param c Length of side C.
     * @return True if valid, false otherwise.
     */
    private boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    /**
     * Calculates the area of the triangle using Heron's formula.
     * 
     * @return The area of the triangle.
     */
    @Override
    public double getArea() {
        double s = getPerimeter() / 2.0;
        double areaSquared = s * (s - sideA) * (s - sideB) * (s - sideC);
        if (areaSquared <= 0) {
            throw new IllegalStateException("Cannot calculate area with given side lengths.");
        }
        return Math.sqrt(areaSquared);
    }

    /**
     * Calculates the perimeter of the triangle.
     * 
     * @return The perimeter.
     */
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    // Getters and Setters (optional)

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        if (!isValidTriangle(sideA, this.sideB, this.sideC)) {
            throw new IllegalArgumentException("Invalid triangle side lengths.");
        }
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        if (!isValidTriangle(this.sideA, sideB, this.sideC)) {
            throw new IllegalArgumentException("Invalid triangle side lengths.");
        }
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        if (!isValidTriangle(this.sideA, this.sideB, sideC)) {
            throw new IllegalArgumentException("Invalid triangle side lengths.");
        }
        this.sideC = sideC;
    }

    /**
     * Returns a string representation of the triangle.
     * 
     * @return A string containing side lengths, area, and perimeter.
     */
    @Override
    public String toString() {
        return String.format("Triangle [SideA=%.2f, SideB=%.2f, SideC=%.2f, Area=%.2f, Perimeter=%.2f]",
                sideA, sideB, sideC, getArea(), getPerimeter());
    }
}
