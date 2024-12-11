package geometry;

/**
 * Interface for 2D geometries.
 */
public interface Geometry2D extends Geometry {
    /**
     * Calculates the area of the geometry.
     * 
     * @return The area.
     */
    double getArea();

    /**
     * Calculates the perimeter of the geometry.
     * 
     * @return The perimeter.
     */
    double getPerimeter();
}
