/**
 * Clase que implementa una SinglyLinkedList, que extiende la clase "List" 
 * e llega a implementar la interfaz "IList"
 */

public class SinglyLinkedList<T> extends List<T> implements IList<T> {

    public static class Nodo<T>{
        T data;
        Node<T> next;

        /**
        * Metodo constructor de los nodos
        */
        public Nodo(T data){
            this.data = data;
            this.next = null;
        }
    }

    protected Node<T> head;

    /**
     * Metodo constructor de la SinglyLinkedlist
     */
    public SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Metodo que agrega un elemento al final de la lista
     * @param value, es el valor que se va a agregar a la lista
     */
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

    /**
     * Metodo que elimina un elemento en la posicion indicada
     * @param index, es la posicion del elemento a eliminar
     * @return el dato del nodo eliminado
     */
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

    /**
     * Metodo que obtiene el ultimo elemento de la lista
     * @return el ultimo elemnto de la lista
     */
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

     /**
     * Metodo que agrega un elemento al final de la lista
     */
    @Override
    public void push(T data) {
        add(data);
    }

    /**
     * Metodo que elimina y devuelve el ultumo elemnto de la lista
     * @return el ultimo elemento de la lisra
     */
    @Override
    public T pop() {
        if (isEmpty()){
            throw new IllegalStateException("Pa, si esta vacia, que vas a sacar?");
        }
        return remove(size - 1);
    }

    /**
     * Metodo que verifica si la lista esta vacia
     * @return true si la lista esta vacio o false si no esta vacia
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
}