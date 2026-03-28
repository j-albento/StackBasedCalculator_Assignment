import java.util.EmptyStackException;

public class StackImplementation<T> implements StackInterface<T> {

    private T[] stack;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public StackImplementation() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        top = 0;
    }

    @Override
    public void push(T newEntry) {
        ensureCapacity();
        stack[top] = newEntry;
        top++;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top--;
        T removed = stack[top];
        stack[top] = null;
        return removed;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < top; i++) {
            stack[i] = null;
        }
        top = 0;
    }

    // -------- Helper Method --------
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (top == stack.length) {
            T[] newStack = (T[]) new Object[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
    }
}