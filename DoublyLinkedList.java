public class DoublyLinkedList<T> extends List<T> implements IList<T>{

    public static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    protected Node<T> head;
    protected Node<T> tail;

    public DoublyLinkedList (){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T value) {
        Node<T> nuevoNode = new Node<T>(value);
        if(head == null){
            head = nuevoNode;
            tail = nuevoNode;
        }
        else{
            tail.next = nuevoNode;
            nuevoNode.prev = tail;
            tail = nuevoNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> actual = head;
        for (int i = 0; i < index; i++){
            actual = actual.next;
        }
        if(actual.prev != null){
            actual.prev.next = actual.next;
        }
        else{
            head = actual.next;
        }
        if(actual.next != null) {
            actual.next.prev = actual.prev;
        } 
        else{ 
            tail = actual.prev;
        }
        size--;
        return actual.data;
    }

    @Override
    public T peek(){
        if (head == null){
            throw new IllegalStateException("La pila está vacía");
        }
        return tail.data;
    }

    @Override
    public void push(T data) {
        add(data);
    }

    @Override
    public T pop() {
        if(isEmpty()){
        throw new IllegalStateException("La pila está vacía");
        }
        return remove(size - 1);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}