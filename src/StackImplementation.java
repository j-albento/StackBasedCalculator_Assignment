import java.util.EmptyStackException;

public class StackImplementation<T> implements StackInterface<T>{

    private T[] array;
    int size;


    public StackImplementation() {
        this.array = (T[]) new Object[10]; // default size is 10
        this.size = 0;
    }

    @Override
    public void push(T newEntry) {

        int newSize = 0;
        if (size == array.length) {
            if (array.length == 0) {
                newSize = 1;
            } else {
                newSize = array.length + 1;
            }

            T[] newArray = (T[]) new Object[newSize];

            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
        }

        // add the element
        array[size] = newEntry;
        size++;
    }

    @Override
    public T pop() throws EmptyStackException {

        // check if array is empty
        if (isEmpty()) throw new EmptyStackException();

        array[size] = null;
        size--;

        T removedElement = array[size];

        return removedElement;
    }

    @Override
    public T peek() throws EmptyStackException {

        if (isEmpty()) throw new EmptyStackException();

        return array[size-1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    // test implementation -- should be removed on submission
    public static void main(String[] args) {
        StackImplementation<String> stack = new StackImplementation<>();

        System.out.println("Initial isEmpty(): " + stack.isEmpty());

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Peek top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Peek after two pops: " + stack.peek());
        System.out.println("Final isEmpty(): " + stack.isEmpty());

        System.out.println("Final size: " + stack.size);
    }
}
