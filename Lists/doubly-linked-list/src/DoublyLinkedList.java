public class DoublyLinkedList {
    Node first;
    Node last;

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
}
