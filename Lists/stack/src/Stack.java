public class Stack
{
    Node stack;

    static class Node
    {
        int key;
        Node next;

        Node(int data) { key = data; next = null; }
    }

    public void push(int key)
    {
        Node newNode = new Node(key);

        if (stack != null)
            newNode.next = stack;

        stack = newNode;
    }

    public void pop()
    {
        if (stack == null)
            return;

        stack = stack.next;
    }

    public void printStack()
    {
        System.out.println("My stack is :");

        Node currentNode = stack;

        while (currentNode != null)
        {
            System.out.print(currentNode.key + " ");
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args)
    {
        Stack myStack = new Stack();

        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);

        myStack.pop();

        myStack.printStack();
    }
}
