package geometry;

/**
 * Represents a Circle in 2D space.
 */
public class Circle implements Geometry2D {
    private double radius;

    /**
     * Constructs a Circle with the specified radius.
     * 
     * @param radius The radius of the circle.
     * @throws IllegalArgumentException if radius is not positive.
     */
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    /**
     * Calculates the area of the circle.
     * 
     * @return The area.
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Calculates the perimeter (circumference) of the circle.
     * 
     * @return The perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Getters and Setters (optional)

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    /**
     * Returns a string representation of the circle.
     * 
     * @return A string containing radius, area, and perimeter.
     */
    @Override
    public String toString() {
        return String.format("Circle [Radius=%.2f, Area=%.2f, Perimeter=%.2f]",
                radius, getArea(), getPerimeter());
    }
}
