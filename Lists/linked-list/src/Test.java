public class Test {
    public static void testsInsertion(LinkedList myList) {
        myList.insertFirst(6);
        myList.insertFirst(7);

        myList.insertLast(3);
        myList.insertLast(5);

        myList.insertAfterKey(6, 8);
        myList.insertAfterKey(3, 9);

        myList.printList();
    }

    public static void testsSearch(LinkedList myList) {
        if (myList.searchNode(6) != null)
            System.out.println("The key was found.");
        else
            System.out.println("The key was not found.");

        if (myList.searchNode(15) != null)
            System.out.println("The key was found.");
        else
            System.out.println("The key was not found.");
    }

    public static void testsDeletion(LinkedList myList) {
        myList.deleteFirst();

        myList.deleteLast();

        myList.deleteGivenKey(8);

        myList.printList();
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        testsInsertion(myList);

        System.out.println();
        System.out.println();

        testsSearch(myList);

        System.out.println();

        testsDeletion(myList);
    }
}
