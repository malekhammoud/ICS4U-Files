package LinkedLists;
public class LinkedList {
    private Node head;

    /**
     * Constructor
     */
    public LinkedList() {
        head = null;
    }

    /**
     * Adds a node to the linked list
     * @param str   The data stored in the new node
     */
    public void addAtFront(String str) {
        Node newNode = new Node(str);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Deletes a node in the linked list
     * @param str	The data of the node to be deleted
     */
    public void remove(String str) {
        Node current = head;
        Node previous = head;

        //If head is the node to be deleted, remove it
        if (current.getData().equals(str)) {
            head = current.getNext();
        }
        //If not head, search until we find the node to delete
        else {
            while (current.getNext() != null) {
                previous = current;
                current = current.getNext();
                if (current.getData().equals(str)) {
                    previous.setNext(current.getNext());
                }
            }
        }
    }

    /**
     * Creates a string that lists the nodes of the linked list
     */
    public String toString() {
        Node current = head;
        String listString;

        if (current != null) {
            listString = current.getData() + "\n";
            while (current.getNext() != null) {
                current = current.getNext();
                listString += current.getData() + "\n";
            }
            return listString;
        } else return "There are no items in the list.";
    }
    public int size(){
        Node current = head;
        Node previous = head;
        int count = 1;
        while (current.getNext() != null) {
            count += 1;
            previous = current;
            current = current.getNext();
            if (current.getData() == null) {
                break;
            }
        }
        return count;
    }
    public void add_last(String str){
        Node current = head;
        Node newNode = new Node(str);
        while (current.getNext() != null) {
            current = current.getNext();
            if (current.getData() == null) {
                current.setNext(newNode);
                return;
            }
        }

    }

    private class Node{
        private String data;
        private Node next;

        /**
         * Constructor
         * @param data	The data stored by the node
         */
        public Node(String data) {
            this.data = data;
            next = null;
        }

        /**
         * Gets the next Node in the list
         * @return	The next Node in the list
         */
        public Node getNext() { return next; }
        /**
         * Changes the node that attribute next points to
         * @param node	The new node to point to
         */
        public void setNext(Node node) { next = node; }

        /**
         * Gets the data stored in the node
         * @return	Returns the value of data
         */
        public String getData() { return data; }
    }
}