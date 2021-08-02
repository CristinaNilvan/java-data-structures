public class Test {
    public static void main(String[] args) {
        Stack myStack = new Stack();

        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);

        myStack.pop();

        myStack.printStack();
    }
}
