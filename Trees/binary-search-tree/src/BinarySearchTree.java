public class BinarySearchTree
{
    Node root = null;

    static class Node
    {
        int key;
        Node right;
        Node left;

        Node(int data) {key = data; right = null; left = null; }
    }

    public Node insertNode(int key)
    {
        Node newNode = new Node(key);

        Node currentNode = root;
        Node toInsert = null;

        while (currentNode != null)
        {
            toInsert = currentNode;

            if (key < currentNode.key)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }

        if (toInsert == null)
            toInsert = newNode;
        else
            if (key < toInsert.key)
                toInsert.left = newNode;
            else
                toInsert.right = newNode;

        return toInsert;
    }

    public Node searchNode(Node node, int key)
    {
        if (node == null || node.key == key)
            return node;

        if (node.key < key)
            return searchNode(node.right, key);

        return searchNode(node.left, key);
    }

    public Node findMinimum(Node root)
    {
        if (root == null)
            return null;

        Node currentNode = root;

        while (currentNode.left != null)
            currentNode = currentNode.left;

        return currentNode;
    }

    public Node findMaximum(Node root)
    {
        if (root == null)
            return null;

        Node currentNode = root;

        while (currentNode.right != null)
            currentNode = currentNode.right;

        return currentNode;
    }

    public Node findSuccessor(Node root, Node node)
    {
        if (node == null || root == null)
            return null;

        if (node.right != null)
            return findMinimum(node.right);

        Node currentNode = root;
        Node successor = null;

        while (currentNode != null && currentNode.key != node.key)
        {
            if (node.key < currentNode.key)
            {
                successor = currentNode;
                currentNode = currentNode.left;
            }
            else
                currentNode = currentNode.right;
        }

        if (currentNode == null)
            return null;

        return successor;
    }

    public Node findPredecessor(Node root, Node node)
    {
        if (node == null || root == null)
            return null;

        if (node.left != null)
            return findMaximum(node.left);

        Node currentNode = root;
        Node predecessor = null;

        while (currentNode != null && currentNode.key != node.key)
        {
            if (node.key < currentNode.key)
                currentNode = currentNode.left;
            else
            {
                predecessor = currentNode;
                currentNode = currentNode.right;
            }
        }

        if (currentNode == null)
            return null;

        return predecessor;
    }

    public Node deleteNode (Node root, int key)
    {
        if (root == null)
            return null;

        Node node;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else
            if (key > root.key)
                root.right = deleteNode(root.right, key);
            else
            {
                if (root.left == null)
                {
                    node = root.right;
                    return node;
                }

                if (root.right == null)
                {
                    node = root.left;
                    return node;
                }

                node = findMinimum(root.right);
                root.key = node.key;
                root.right = deleteNode(root.right, node.key);
            }

        return root;
    }

    public void inOrderPrinting(Node root)
    {
        if (root == null)
            return;

        inOrderPrinting(root.left);
        System.out.print(root.key + " ");
        inOrderPrinting(root.right);
    }

    public void preOrderPrinting(Node root)
    {
        if (root == null)
            return;

        System.out.print(root.key + " ");
        preOrderPrinting(root.left);
        preOrderPrinting(root.right);
    }

    public void postOrderPrinting(Node root)
    {
        if (root == null)
            return;

        postOrderPrinting(root.left);
        postOrderPrinting(root.right);
        System.out.print(root.key + " ");
    }

    public static void testsInsertion(BinarySearchTree myTree)
    {
        int nodesToInsert = 11;
        int[] keys = {15, 6, 18, 17, 20, 3, 7, 2, 4, 13, 9};

        myTree.root = myTree.insertNode(keys[0]);

        for (int i = 1; i < nodesToInsert; i++)
            myTree.insertNode(keys[i]);

        myTree.inOrderPrinting(myTree.root);

        System.out.println();
    }

    public static void testsSearch(BinarySearchTree myTree)
    {
        int key = 15;
        Node node = myTree.searchNode(myTree.root, key);

        if (node != null)
            System.out.println("The node has been found.");
        else
            System.out.println("The node has not been found.");
    }

    public static void testsSuccessor(BinarySearchTree myTree)
    {
        int key = 15;
        Node node = myTree.searchNode(myTree.root, key);

        Node successor = myTree.findSuccessor(myTree.root, node);

        if (successor != null)
            System.out.println("The node with key = " + node.key + " has " + successor.key + " as successor.");
        else
            System.out.println("The node doesn't have a successor.");
    }

    public static void testsPredecessor(BinarySearchTree myTree)
    {
        int key = 15;
        Node node = myTree.searchNode(myTree.root, key);

        Node predecessor = myTree.findPredecessor(myTree.root, node);

        if (predecessor != null)
            System.out.println("The node with key = " + node.key + " has " + predecessor.key + " as predecessor.");
        else
            System.out.println("The node doesn't have a predecessor.");
    }

    public static void testsDeletion(BinarySearchTree myTree)
    {
        int key = 15;

        System.out.println("Node to delete : " + key);

        myTree.root = myTree.deleteNode(myTree.root, key);

        myTree.inOrderPrinting(myTree.root);
        System.out.println();
    }

    public static void testsPrinting(BinarySearchTree myTree)
    {
        myTree.inOrderPrinting(myTree.root);
        System.out.println();

        myTree.preOrderPrinting(myTree.root);
        System.out.println();

        myTree.postOrderPrinting(myTree.root);
        System.out.println();
    }

    public static void main (String[] args)
    {
        BinarySearchTree myTree = new BinarySearchTree();

        testsInsertion(myTree);

        testsSearch(myTree);

        testsSuccessor(myTree);
        testsPredecessor(myTree);

        testsPrinting(myTree);
        
        testsDeletion(myTree);
    }
}
