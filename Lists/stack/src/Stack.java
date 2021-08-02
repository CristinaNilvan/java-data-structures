public class Stack {
    Node stack;

    public void push(int key) {
        Node newNode = new Node(key);

        if (stack != null)
            newNode.next = stack;

        stack = newNode;
    }

    public void pop() {
        if (stack == null)
            return;

        stack = stack.next;
    }

    public void printStack() {
        System.out.println("My stack is :");

        Node currentNode = stack;

        while (currentNode != null) {
            System.out.print(currentNode.key + " ");
            currentNode = currentNode.next;
        }
    }
}
