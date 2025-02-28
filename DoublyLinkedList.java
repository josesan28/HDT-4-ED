/**
 * Clase que implementa una DoublyLinkedList, que extiende la clase "List" 
 * e llega a implementar la interfaz "IList"
 */

public class DoublyLinkedList<T> extends List<T> implements IList<T>{

    
    public static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        /**
         * Metodo constructor de los nodos
        */
        public Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    protected Node<T> head;
    protected Node<T> tail;

    /**
     * Metodo constructor de la DoublyLinkedlist
     */
    public DoublyLinkedList (){
        this.head = null;
        this.tail = null;
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
            tail = nuevoNode;
        }
        else{
            tail.next = nuevoNode;
            nuevoNode.prev = tail;
            tail = nuevoNode;
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

    /**
     * Metodo que obtiene el ultimo elemento de la lista
     * @return el ultimo elemnto de la lista
     */
    @Override
    public T peek(){
        if (head == null){
            throw new IllegalStateException("La pila está vacía");
        }
        return tail.data;
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
        if(isEmpty()){
        throw new IllegalStateException("La pila está vacía");
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