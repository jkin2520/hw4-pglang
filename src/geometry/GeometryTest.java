package geometry;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for geometry classes and GeometryLinkedList.
 */
public class GeometryTest {
    private GeometryLinkedList geometryList;

    /**
     * Initializes a fresh GeometryLinkedList before each test to ensure test isolation.
     */
    @BeforeEach
    void setUp() {
        geometryList = new GeometryLinkedList();
    }

    /**
     * Tests the add method and verifies the size of the list after additions.
     */
    @Test
    void testAddAndSize() {
        Rectangle rect = new Rectangle(5.0, 3.0);
        geometryList.add(rect);
        assertEquals(1, geometryList.size());
        // After adding one geometry, the list size should be 1

        Circle circle = new Circle(2.5);
        geometryList.add(circle);
        assertEquals(2, geometryList.size());
        // After adding a second geometry, the list size should be 2
    }

    /**
     * Tests the findByIndex method to ensure it retrieves the correct geometry.
     */
    @Test
    void testFindByIndex() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        geometryList.add(triangle);
        // Adds a Triangle to the geometry list

        Geometry found = geometryList.findByIndex(0);
        // Attempts to retrieve the geometry at index 0

        assertNotNull(found);
        // Ensures that the retrieved geometry is not null

        assertTrue(found instanceof Triangle);
        // Checks that the retrieved geometry is an instance of Triangle

        // Casts the found Geometry to Triangle to access getArea()
        Triangle foundTriangle = (Triangle) found;
        assertEquals(triangle.getArea(), foundTriangle.getArea(), 0.0001);
        // Ensures that the area of the found Triangle matches the expected area
    }

    /**
     * Tests the removeByIndex method to ensure geometries are correctly removed from the list.
     */
    @Test
    void testRemoveByIndex() {
        Sphere sphere = new Sphere(3.0);
        RectangularPrism rp = new RectangularPrism(2.0, 3.0, 4.0);
        geometryList.add(sphere);
        geometryList.add(rp);
        // Adds a Sphere and a RectangularPrism to the geometry list

        assertEquals(2, geometryList.size());
        // Verifies that the list size is 2 after additions

        boolean removed = geometryList.removeByIndex(0);
        // Attempts to remove the geometry at index 0 (Sphere)

        assertTrue(removed);
        // Confirms that the removal was successful

        assertEquals(1, geometryList.size());
        // Ensures that the list size is now 1 after removal

        Geometry found = geometryList.findByIndex(0);
        // Attempts to retrieve the geometry at the new index 0

        assertTrue(found instanceof RectangularPrism);
        // Checks that the remaining geometry is a RectangularPrism
    }

    /**
     * Tests the area and perimeter calculations of 2D geometries.
     */
    @Test
    void testCalculateAreaAndPerimeter() {
        Rectangle rect = new Rectangle(5.0, 3.0);
        assertEquals(15.0, rect.getArea(), 0.0001);
        // Verifies that the area of the rectangle is correctly calculated as 15.0

        assertEquals(16.0, rect.getPerimeter(), 0.0001);
        // Ensures that the perimeter of the rectangle is correctly calculated as 16.0

        Circle circle = new Circle(2.0);
        assertEquals(Math.PI * 4, circle.getArea(), 0.0001);
        // Checks that the area of the circle is correctly calculated as 4π

        assertEquals(Math.PI * 4, circle.getPerimeter(), 0.0001);
        // Verifies that the perimeter (circumference) of the circle is correctly calculated as 4π
    }

    /**
     * Tests the volume and surface area calculations of 3D geometries.
     */
    @Test
    void testCalculateVolumeAndSurfaceArea() {
        Sphere sphere = new Sphere(2.0);
        assertEquals((4.0 / 3.0) * Math.PI * 8, sphere.getVolume(), 0.0001);
        // Ensures that the volume of the sphere is correctly calculated as (4/3)πr³

        assertEquals(16.0 * Math.PI, sphere.getSurfaceArea(), 0.0001);
        // Verifies that the surface area of the sphere is correctly calculated as 16π

        RectangularPrism rp = new RectangularPrism(2.0, 3.0, 4.0);
        assertEquals(24.0, rp.getVolume(), 0.0001);
        // Checks that the volume of the rectangular prism is correctly calculated as 24.0

        assertEquals(52.0, rp.getSurfaceArea(), 0.0001);
        // Ensures that the surface area of the rectangular prism is correctly calculated as 52.0
    }

    /**
     * Tests the volume and surface area calculations of a TriangularPrism.
     */
    @Test
    void testTriangularPrism() {
        TriangularPrism tp = new TriangularPrism(3.0, 4.0, 5.0, 10.0);
        assertEquals(60.0, tp.getVolume(), 0.0001);
        // Verifies that the volume of the triangular prism is correctly calculated as 60.0

        assertEquals(132.0, tp.getSurfaceArea(), 0.0001);
        // Ensures that the surface area of the triangular prism is correctly calculated as 132.0
    }

    /**
     * Tests the functionality of listing all geometries in the linked list.
     */
    @Test
    void testListGeometries() {
        assertEquals(0, geometryList.size());
        // Confirms that the initial list size is 0

        Rectangle rect = new Rectangle(5.0, 3.0);
        Sphere sphere = new Sphere(2.0);
        geometryList.add(rect);
        geometryList.add(sphere);
        // Adds a Rectangle and a Sphere to the geometry list

        assertEquals(2, geometryList.size());
        // Verifies that the list size is 2 after additions

        Geometry foundRect = geometryList.findByIndex(0);
        Geometry foundSphere = geometryList.findByIndex(1);
        // Retrieves the geometries at indices 0 and 1

        assertTrue(foundRect instanceof Rectangle);
        // Checks that the first geometry is a Rectangle

        assertTrue(foundSphere instanceof Sphere);
        // Ensures that the second geometry is a Sphere
    }
}
