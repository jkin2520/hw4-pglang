package geometry;

/**
 * A singly linked list to store Geometry objects.
 */
public class GeometryLinkedList {
    private GeometryNode head;

    /**
     * Constructs an empty GeometryLinkedList.
     */
    public GeometryLinkedList() {
        this.head = null;
    }

    /**
     * Adds a Geometry object to the end of the linked list.
     * 
     * @param geometry The Geometry object to add.
     */
    public void add(Geometry geometry) {
        GeometryNode newNode = new GeometryNode(geometry);
        if (head == null) {
            head = newNode;
        } else {
            GeometryNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Removes a Geometry object from the linked list by its index.
     * 
     * @param index The index of the Geometry object to remove (0-based).
     * @return True if removal was successful, false otherwise.
     */
    public boolean removeByIndex(int index) {
        if (head == null || index < 0) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            return true;
        }

        GeometryNode current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) {
                return false;
            }
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        return true;
    }

    /**
     * Finds a Geometry object by its index in the linked list.
     * 
     * @param index The index of the Geometry object to find (0-based).
     * @return The Geometry object if found, null otherwise.
     */
    public Geometry findByIndex(int index) {
        if (head == null || index < 0) {
            return null;
        }

        GeometryNode current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }
            current = current.next;
            currentIndex++;
        }

        return null;
    }

    /**
     * Prints all Geometry objects in the linked list along with their indices.
     */
    public void printAll() {
        GeometryNode current = head;
        int index = 0;
        while (current != null) {
            System.out.println("Index " + index + ": " + current.data.toString());
            current = current.next;
            index++;
        }
    }

    /**
     * Returns the size of the linked list.
     * 
     * @return The number of Geometry objects in the list.
     */
    public int size() {
        int count = 0;
        GeometryNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Represents a node in the GeometryLinkedList.
     */
    private static class GeometryNode {
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
}
