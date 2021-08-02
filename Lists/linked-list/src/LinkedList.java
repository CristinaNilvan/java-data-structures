class LinkedList {
    Node first;
    Node last;

    public void insertFirst(int key) {
        Node newNode = new Node(key);

        if (first == null)
            last = newNode;
        else
            newNode.next = first;

        first = newNode;
    }

    public void insertLast(int key) {
        Node newNode = new Node(key);

        if (last == null)
            first = newNode;
        else
            last.next = newNode;

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

        newNode.next = currentNode.next;
        currentNode.next = newNode;

        if (currentNode == last)
            last = newNode;
    }

    public void deleteFirst() {
        if (first == null)
            return;

        first = first.next;
    }

    public void deleteLast() {
        Node toDelete = first;
        Node previousNode = null;

        if (toDelete == null)
            return;

        while (toDelete != last) {
            previousNode = toDelete;
            toDelete = toDelete.next;
        }

        previousNode.next = null;
        last = previousNode;
    }

    public void deleteGivenKey(int givenKey) {
        Node toDelete = first;

        if (toDelete == null)
            return;

        Node previousNode = null;

        while (toDelete != null) {
            if (toDelete.key == givenKey)
                break;

            previousNode = toDelete;
            toDelete = toDelete.next;
        }

        if (toDelete == first) {
            first = first.next;

            if (first == null)
                last = null;
        } else {
            previousNode.next = toDelete.next;

            if (toDelete == last)
                last = previousNode;
        }
    }

    public void printList() {
        System.out.println("My list is :");

        Node currentNode = first;

        while (currentNode != null) {
            System.out.print(currentNode.key + " ");
            currentNode = currentNode.next;
        }
    }
}
