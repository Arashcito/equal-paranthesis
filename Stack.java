// COMP352 ASSIGMENT2
// AUTHOR: ARASH SHAFIEE (STUDENT ID: 40278142)
// PROGRAMMING ASSIGNMENT

public class Stack {
    private int top;
    private int capacity;
    private char[] stack;

    public Stack() {
        capacity = 2;
        stack = new char[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void expandStack(){
        int newCapacity = capacity * 2;
        char[] newStack = new char[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, top);
        stack = newStack;
        capacity = newCapacity;
        System.out.println("Stack is full and will expand to size : " + newCapacity);
    }

    public void push(char c) {
        if (isFull()) {
            expandStack();
        }
        stack[++top] = c;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return '\0';
        }
        return stack[top--];
    }

    public char top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return '\0';
        }
        return stack[top];
    }

    public int size() {
        return top + 1;
    }
}
