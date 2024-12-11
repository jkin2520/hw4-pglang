package geometry;

/**
 * Represents a node in the GeometryLinkedList.
 */
class GeometryNode {
    Geometry data;
    GeometryNode next;

    /**
     * Constructs a GeometryNode with the specified Geometry object.
     * 
     * @param data The Geometry object to store in the node.
     */
    public GeometryNode(Geometry data) {
        this.data = data;
        this.next = null;
    }
}
