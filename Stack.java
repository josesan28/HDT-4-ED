public abstract class Stack<T> implements IStack<T> {

    //Atributos
    private int size;

    //Métodos
    public abstract void push(T item);
    public abstract T pop();
    public abstract boolean isEmpty();
}