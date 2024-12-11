package geometry;

/**
 * Represents a Triangular Prism in 3D space.
 */
public class TriangularPrism implements Geometry3D {
    private double sideA;
    private double sideB;
    private double sideC;
    private double height;

    /**
     * Constructs a TriangularPrism with the specified side lengths and height.
     * 
     * @param sideA  The length of side A of the triangular base.
     * @param sideB  The length of side B of the triangular base.
     * @param sideC  The length of side C of the triangular base.
     * @param height The height (length) of the prism.
     * @throws IllegalArgumentException if the triangle is invalid or height is not positive.
     */
    public TriangularPrism(double sideA, double sideB, double sideC, double height) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Invalid triangle side lengths.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.height = height;
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
     * Calculates the volume of the triangular prism.
     * 
     * Volume = Area of base triangle × height
     * 
     * @return The volume.
     */
    @Override
    public double getVolume() {
        double baseArea = calculateBaseArea();
        return baseArea * height;
    }

    /**
     * Calculates the surface area of the triangular prism.
     * 
     * Surface Area = 2 × Area of base triangle + Perimeter of base triangle × height
     * 
     * @return The surface area.
     */
    @Override
    public double getSurfaceArea() {
        double baseArea = calculateBaseArea();
        double perimeter = sideA + sideB + sideC;
        return 2 * baseArea + perimeter * height;
    }

    /**
     * Calculates the area of the base triangle using Heron's formula.
     * 
     * @return The area of the base triangle.
     */
    private double calculateBaseArea() {
        double s = (sideA + sideB + sideC) / 2.0;
        double areaSquared = s * (s - sideA) * (s - sideB) * (s - sideC);
        if (areaSquared <= 0) {
            throw new IllegalStateException("Cannot calculate area with given side lengths.");
        }
        return Math.sqrt(areaSquared);
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive.");
        }
        this.height = height;
    }

    /**
     * Returns a string representation of the triangular prism.
     * 
     * @return A string containing side lengths, height, volume, and surface area.
     */
    @Override
    public String toString() {
        return String.format("TriangularPrism [SideA=%.2f, SideB=%.2f, SideC=%.2f, Height=%.2f, Volume=%.2f, Surface Area=%.2f]",
                sideA, sideB, sideC, height, getVolume(), getSurfaceArea());
    }
}
