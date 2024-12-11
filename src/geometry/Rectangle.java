package geometry;

/**
 * Represents a Rectangle in 2D space.
 */
public class Rectangle implements Geometry2D {
    private double length;
    private double width;

    /**
     * Constructs a Rectangle with the specified length and width.
     * 
     * @param length The length of the rectangle.
     * @param width  The width of the rectangle.
     * @throws IllegalArgumentException if length or width is not positive.
     */
    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive.");
        }
        this.length = length;
        this.width = width;
    }

    /**
     * Calculates the area of the rectangle.
     * 
     * @return The area.
     */
    @Override
    public double getArea() {
        return length * width;
    }

    /**
     * Calculates the perimeter of the rectangle.
     * 
     * @return The perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Getters and Setters (optional)

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive.");
        }
        this.width = width;
    }

    /**
     * Returns a string representation of the rectangle.
     * 
     * @return A string containing length, width, area, and perimeter.
     */
    @Override
    public String toString() {
        return String.format("Rectangle [Length=%.2f, Width=%.2f, Area=%.2f, Perimeter=%.2f]",
                length, width, getArea(), getPerimeter());
    }
}
