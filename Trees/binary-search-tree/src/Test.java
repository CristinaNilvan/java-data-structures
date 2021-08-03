public class Test {
    public static void testsInsertion(BinarySearchTree myTree) {
        int nodesToInsert = 11;
        int[] keys = {15, 6, 18, 17, 20, 3, 7, 2, 4, 13, 9};

        myTree.root = myTree.insertNode(keys[0]);

        for (int i = 1; i < nodesToInsert; i++)
            myTree.insertNode(keys[i]);

        myTree.inOrderPrinting(myTree.root);

        System.out.println();
    }

    public static void testsSearch(BinarySearchTree myTree) {
        int key = 15;
        Node node = myTree.searchNode(myTree.root, key);

        if (node != null)
            System.out.println("The node has been found.");
        else
            System.out.println("The node has not been found.");
    }

    public static void testsSuccessor(BinarySearchTree myTree) {
        int key = 15;
        Node node = myTree.searchNode(myTree.root, key);

        Node successor = myTree.findSuccessor(myTree.root, node);

        if (successor != null)
            System.out.println("The node with key = " + node.key + " has " + successor.key + " as successor.");
        else
            System.out.println("The node doesn't have a successor.");
    }

    public static void testsPredecessor(BinarySearchTree myTree) {
        int key = 15;
        Node node = myTree.searchNode(myTree.root, key);

        Node predecessor = myTree.findPredecessor(myTree.root, node);

        if (predecessor != null)
            System.out.println("The node with key = " + node.key + " has " + predecessor.key + " as predecessor.");
        else
            System.out.println("The node doesn't have a predecessor.");
    }

    public static void testsDeletion(BinarySearchTree myTree) {
        int key = 15;

        System.out.println("Node to delete : " + key);

        myTree.root = myTree.deleteNode(myTree.root, key);

        myTree.inOrderPrinting(myTree.root);
        System.out.println();
    }

    public static void testsPrinting(BinarySearchTree myTree) {
        myTree.inOrderPrinting(myTree.root);
        System.out.println();

        myTree.preOrderPrinting(myTree.root);
        System.out.println();

        myTree.postOrderPrinting(myTree.root);
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();

        testsInsertion(myTree);

        testsSearch(myTree);

        testsSuccessor(myTree);
        testsPredecessor(myTree);

        testsPrinting(myTree);

        testsDeletion(myTree);
    }
}
