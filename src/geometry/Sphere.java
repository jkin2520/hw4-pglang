package geometry;

/**
 * Represents a Sphere in 3D space.
 */
public class Sphere implements Geometry3D {
    private double radius;

    /**
     * Constructs a Sphere with the specified radius.
     * 
     * @param radius The radius of the sphere.
     * @throws IllegalArgumentException if radius is not positive.
     */
    public Sphere(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    /**
     * Calculates the volume of the sphere.
     * 
     * @return The volume.
     */
    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    /**
     * Calculates the surface area of the sphere.
     * 
     * @return The surface area.
     */
    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
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
     * Returns a string representation of the sphere.
     * 
     * @return A string containing radius, volume, and surface area.
     */
    @Override
    public String toString() {
        return String.format("Sphere [Radius=%.2f, Volume=%.2f, Surface Area=%.2f]",
                radius, getVolume(), getSurfaceArea());
    }
}
