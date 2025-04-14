package LinkedLists;

public class LinkedListDemo {
    public static void main(String[] args) {
        //    Create a Stack class or a Queue class (your choice) that uses a Linked List to store the data in the structure.\s

        //    Compare your code with your classes from last lesson. What are the pros/cons of using a linked list for a stack/queue as opposed to an array or ArrayList?
        LinkedList list = new LinkedList();

        list.addAtFront("Leo");
        list.addAtFront("Hari");
        list.addAtFront("Ben");
        System.out.println(list);

        System.out.println(list);
        System.out.println(list.size());

    }
}
