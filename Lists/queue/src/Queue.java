public class Queue {
    Node first;
    Node last;

    public void enqueue(int key) {
        Node newNode = new Node(key);

        if (last == null)
            first = newNode;
        else
            last.next = newNode;

        last = newNode;
    }

    public void dequeue() {
        if (first == null)
            return;

        first = first.next;

        if (first == null)
            last = null;
    }

    public void printQueue() {
        System.out.println("My queue is :");

        Node currentNode = first;

        while (currentNode != null) {
            System.out.print(currentNode.key + " ");
            currentNode = currentNode.next;
        }
    }
}
