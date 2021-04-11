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
            return searchNode(node.left, key);

        return searchNode(node.right, key);
    }

    public void inOrderPrinting(Node node)
    {
        if(node != null)
        {
            inOrderPrinting(node.left);
            System.out.print(node.key + " ");
            inOrderPrinting(node.right);
        }
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

    public static void main (String[] args)
    {
        BinarySearchTree myTree = new BinarySearchTree();

        testsInsertion(myTree);

        testsSearch(myTree);
    }
}
