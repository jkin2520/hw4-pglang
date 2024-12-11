package geometry;

/**
 * Represents a Rectangular Prism in 3D space.
 */
public class RectangularPrism implements Geometry3D {
    private double length;
    private double width;
    private double height;

    /**
     * Constructs a RectangularPrism with the specified dimensions.
     * 
     * @param length The length of the prism.
     * @param width  The width of the prism.
     * @param height The height of the prism.
     * @throws IllegalArgumentException if any dimension is not positive.
     */
    public RectangularPrism(double length, double width, double height) {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException("All dimensions must be positive.");
        }
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Calculates the volume of the rectangular prism.
     * 
     * @return The volume.
     */
    @Override
    public double getVolume() {
        return length * width * height;
    }

    /**
     * Calculates the surface area of the rectangular prism.
     * 
     * @return The surface area.
     */
    @Override
    public double getSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
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
     * Returns a string representation of the rectangular prism.
     * 
     * @return A string containing length, width, height, volume, and surface area.
     */
    @Override
    public String toString() {
        return String.format("RectangularPrism [Length=%.2f, Width=%.2f, Height=%.2f, Volume=%.2f, Surface Area=%.2f]",
                length, width, height, getVolume(), getSurfaceArea());
    }
}
