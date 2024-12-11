package geometry;

/**
 * Interface for 3D geometries.
 */
public interface Geometry3D extends Geometry {
    /**
     * Calculates the volume of the geometry.
     * 
     * @return The volume.
     */
    double getVolume();

    /**
     * Calculates the surface area of the geometry.
     * 
     * @return The surface area.
     */
    double getSurfaceArea();
}
