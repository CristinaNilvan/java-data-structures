public class Queue
{
    static class Node
    {
        int key;
        Node next;

        Node(int data) { key = data; next = null; }
    }

    Node first;
    Node last;

    public void enqueue(int key)
    {
        Node newNode = new Node(key);

        if (last == null)
            first = newNode;
        else
            last.next = newNode;

        last = newNode;
    }

    public void dequeue()
    {
        if (first == null)
            return;

        first = first.next;

        if (first == null)
            last = null;
    }

    public void printQueue()
    {
        System.out.println("My queue is :");

        Node currentNode = first;

        while (currentNode != null)
        {
            System.out.print(currentNode.key + " ");
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args)
    {
        Queue myQueue = new Queue();

        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        myQueue.enqueue(7);

        myQueue.dequeue();

        myQueue.printQueue();
    }
}
