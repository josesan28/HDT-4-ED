public class SinglyLinkedList<T> extends List<T> implements IList<T> {

    public static class Nodo<T>{
        T data;
        Node<T> next;

        public Nodo(T data){
            this.data = data;
            this.next = null;
        }
    }

    protected Node<T> head;

    public SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(T value) {
        Node<T> nuevoNode = new Node<T>(value);
        if(head == null){
            head = nuevoNode;
        }
        else{
            Node<T> actual = head;
            while (actual.next != null){
                actual = actual.next;
            }
            actual.next = nuevoNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> actual = head;
        Node<T> previo = null;
        for (int i = 0; i < index; i++){
            previo = actual;
            actual = actual.next;
        }
        if(previo == null){
            head = actual.next;
        }
        else{
            previo.next = actual.next;
        }
        size--;
        return actual.data;
    }

    @Override
    public T peek(){
        if (head == null){
            throw new IllegalStateException("Pa, si esta vacia, que vas a sacar?");
        }
        Node<T> actual = head;
        while (actual.next != null) {
        actual = actual.next;
        }
        return actual.data;
    }

    @Override
    public void push(T data) {
        add(data);
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new IllegalStateException("Pa, si esta vacia, que vas a sacar?");
        }
        return remove(size - 1);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}