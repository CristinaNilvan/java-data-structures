class LinkedList
{
    Node first;
    Node last;

    static class Node
    {
        int key;
        Node next;

        Node(int data) {key = data; next = null; }
    }

    public void insertFirst(int key)
    {
        Node newNode = new Node(key);

        if (first == null)
            last = newNode;
        else
            newNode.next = first;

        first = newNode;
    }

    public void insertLast(int key)
    {
        Node newNode = new Node(key);

        if (last == null)
            first = newNode;
        else
            last.next = newNode;

        last = newNode;
    }

    public Node searchNode(int givenKey)
    {
        Node currentNode = first;

        while (currentNode != null)
        {
            if (currentNode.key == givenKey)
                break;

            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public void insertAfterKey(int afterKey, int givenKey)
    {
        Node currentNode = searchNode(afterKey);

        Node newNode = new Node(givenKey);

        newNode.next = currentNode.next;
        currentNode.next = newNode;

        if (currentNode == last)
            last = newNode;
    }

    public void deleteFirst()
    {
        if (first == null)
            return;

        first = first.next;
    }

    public void deleteLast()
    {
        Node toDelete = first;
        Node previousNode = null;

        if (toDelete == null)
            return;

        while (toDelete != last)
        {
            previousNode = toDelete;
            toDelete = toDelete.next;
        }

        previousNode.next = null;
        last = previousNode;
    }

    public void deleteGivenKey(int givenKey)
    {
        Node toDelete = first;
        Node previousNode = null;

        while (toDelete != null)
        {
            if (toDelete.key == givenKey)
                break;

            previousNode = toDelete;
            toDelete = toDelete.next;
        }

        if (toDelete == null)
            return;

        if (toDelete == first)
        {
            first = first.next;

            if (first == null)
                last = null;
        }
        else
        {
            previousNode.next = toDelete.next;

            if (toDelete == last)
                last = previousNode;
        }
    }

    public void printList()
    {
        System.out.println("My list is :");

        Node currentNode = first;

        while (currentNode != null)
        {
            System.out.print(currentNode.key + " ");
            currentNode = currentNode.next;
        }
    }

    public static void testsInsertion(LinkedList myList)
    {
        myList.insertFirst(6);
        myList.insertFirst(7);

        myList.insertLast(3);
        myList.insertLast(5);

        myList.insertAfterKey(6, 8);
        myList.insertAfterKey(3, 9);

        myList.printList();
    }

    public static void testsSearch(LinkedList myList)
    {
        if (myList.searchNode(6) != null)
            System.out.println("The key was found.");
        else
            System.out.println("The key was not found.");

        if (myList.searchNode(15) != null)
            System.out.println("The key was found.");
        else
            System.out.println("The key was not found.");
    }

    public static void testsDeletion(LinkedList myList)
    {
        myList.deleteFirst();

        myList.deleteLast();

        myList.deleteGivenKey(8);

        myList.printList();
    }

    public static void main (String[] args)
    {
        LinkedList myList = new LinkedList();

        testsInsertion(myList);

        System.out.println();
        System.out.println();

        testsSearch(myList);

        System.out.println();

        testsDeletion(myList);
    }
}
