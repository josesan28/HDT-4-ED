public abstract class List<T> implements IList<T> {
    
    protected int size;
    
    public abstract void add(T value);
    public abstract T remove(int index);
    public abstract T peek();
}