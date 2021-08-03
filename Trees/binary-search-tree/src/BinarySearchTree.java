public class BinarySearchTree {
    Node root;

    public Node insertNode(int key) {
        Node newNode = new Node(key);

        Node currentNode = root;
        Node toInsert = null;

        while (currentNode != null) {
            toInsert = currentNode;

            if (key < currentNode.key)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }

        if (toInsert == null)
            toInsert = newNode;
        else if (key < toInsert.key)
            toInsert.left = newNode;
        else
            toInsert.right = newNode;

        return toInsert;
    }

    public Node searchNode(Node node, int key) {
        if (node == null || node.key == key)
            return node;

        if (node.key < key)
            return searchNode(node.right, key);

        return searchNode(node.left, key);
    }

    public Node findMinimum(Node root) {
        if (root == null)
            return null;

        Node currentNode = root;

        while (currentNode.left != null)
            currentNode = currentNode.left;

        return currentNode;
    }

    public Node findMaximum(Node root) {
        if (root == null)
            return null;

        Node currentNode = root;

        while (currentNode.right != null)
            currentNode = currentNode.right;

        return currentNode;
    }

    public Node findSuccessor(Node root, Node node) {
        if (node == null || root == null)
            return null;

        if (node.right != null)
            return findMinimum(node.right);

        Node currentNode = root;
        Node successor = null;

        while (currentNode != null && currentNode.key != node.key) {
            if (node.key < currentNode.key) {
                successor = currentNode;
                currentNode = currentNode.left;
            } else
                currentNode = currentNode.right;
        }

        if (currentNode == null)
            return null;

        return successor;
    }

    public Node findPredecessor(Node root, Node node) {
        if (node == null || root == null)
            return null;

        if (node.left != null)
            return findMaximum(node.left);

        Node currentNode = root;
        Node predecessor = null;

        while (currentNode != null && currentNode.key != node.key) {
            if (node.key < currentNode.key)
                currentNode = currentNode.left;
            else {
                predecessor = currentNode;
                currentNode = currentNode.right;
            }
        }

        if (currentNode == null)
            return null;

        return predecessor;
    }

    public Node deleteNode(Node root, int key) {
        if (root == null)
            return null;

        Node node;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) {
                node = root.right;
                return node;
            }

            if (root.right == null) {
                node = root.left;
                return node;
            }

            node = findMinimum(root.right);
            root.key = node.key;
            root.right = deleteNode(root.right, node.key);
        }

        return root;
    }

    public void inOrderPrinting(Node root) {
        if (root == null)
            return;

        inOrderPrinting(root.left);
        System.out.print(root.key + " ");
        inOrderPrinting(root.right);
    }

    public void preOrderPrinting(Node root) {
        if (root == null)
            return;

        System.out.print(root.key + " ");
        preOrderPrinting(root.left);
        preOrderPrinting(root.right);
    }

    public void postOrderPrinting(Node root) {
        if (root == null)
            return;

        postOrderPrinting(root.left);
        postOrderPrinting(root.right);
        System.out.print(root.key + " ");
    }
}
