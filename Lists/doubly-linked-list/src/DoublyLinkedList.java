public class DoublyLinkedList {
    Node first;
    Node last;

    static class Node {
        int key;
        Node next;
        Node prev;

        Node(int data) {
            key = data;
            next = null;
            prev = null;
        }
    }

    public void insertFirst(int key) {
        Node newNode = new Node(key);

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
    }

    public void insertLast(int key) {
        Node newNode = new Node(key);

        if (last == null) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
    }

    public Node searchNode(int givenKey) {
        Node currentNode = first;

        while (currentNode != null) {
            if (currentNode.key == givenKey)
                break;

            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public void insertAfterKey(int afterKey, int givenKey) {
        Node currentNode = searchNode(afterKey);

        if (currentNode == null)
            return;

        Node newNode = new Node(givenKey);

        newNode.prev = currentNode;
        newNode.next = currentNode.next;

        if (currentNode.next != null)
            currentNode.next.prev = newNode;

        currentNode.next = newNode;

        if (last == currentNode)
            last = newNode;
    }

    public void deleteFirst() {
        if (first == null)
            return;

        first = first.next;

        if (first == null)
            last = null;
        else
            first.prev = null;
    }

    public void deleteLast() {
        if (last == null)
            return;

        last = last.prev;

        if (last == null)
            first = null;
        else
            last.next = null;
    }

    public void deleteGivenKey(int givenKey) {
        Node toDelete = searchNode(givenKey);

        if (toDelete.prev != null)
            toDelete.prev.next = toDelete.next;
        else
            first = toDelete.next;

        if (toDelete.next != null)
            toDelete.next.prev = toDelete.prev;
        else
            last = toDelete.prev;
    }

    public void printList() {
        if (first == null)
            return;

        System.out.println("My list is :");

        Node currentNode = first;

        while (currentNode != null) {
            System.out.print(currentNode.key + " ");
            currentNode = currentNode.next;
        }
    }

    public static void testsInsertion(DoublyLinkedList myList) {
        myList.insertFirst(6);
        myList.insertFirst(7);

        myList.insertLast(3);
        myList.insertLast(5);

        myList.insertAfterKey(6, 8);
        myList.insertAfterKey(3, 9);

        myList.printList();
    }

    public static void testsSearch(DoublyLinkedList myList) {
        if (myList.searchNode(6) != null)
            System.out.println("The key was found.");
        else
            System.out.println("The key was not found.");

        if (myList.searchNode(15) != null)
            System.out.println("The key was found.");
        else
            System.out.println("The key was not found.");
    }

    public static void testsDeletion(DoublyLinkedList myList) {
        myList.deleteFirst();

        myList.deleteLast();

        myList.deleteGivenKey(8);

        myList.printList();
    }

    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();

        testsInsertion(myList);

        System.out.println();
        System.out.println();

        testsSearch(myList);

        System.out.println();

        testsDeletion(myList);

    }
}
