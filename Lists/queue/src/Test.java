public class Test {
    public static void main(String[] args) {
        Queue myQueue = new Queue();

        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        myQueue.enqueue(7);

        myQueue.dequeue();

        myQueue.printQueue();
    }
}
