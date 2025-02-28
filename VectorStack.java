/**
 *  @author José Manuel Sanchez Hernández - 24092, Josué Antonio Isaac García Barrera - 24918 y Jose Alberto Abril Suchite 24585
 *  @version 1.0
 *  Descripción: Clase que implementa una pila con un vector
 *  Fecha de creación: 26/02/2025
 *  Fecha de última modificación: 27/02/2025
 */

public class VectorStack<T> extends Stack<T>{
    private Node<T> top;
    private int size;
    

    public VectorStack(){
        this.top = null;
        this.size = 0;
    }

    /**
     * Este método verifica si la stack esta vacía
     *
     * @return retorna true si la stack esta vacía, false si no esta vacía
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Este método elimina y devuelve el último elemento ingresado a la stack
     *
     * @return el elemento eliminado de la pila
     * @throws IllegalStateException si la pila esta vacía
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La stack está vacía");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }
    
    /**
     * Este método agrega un nuevo valor en la parte superior de la stack
     * @param value el valor a agregar en la stack
     */
    @Override
    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Este método devuelve el valor que se encuentra en la parte superior de la stack
     * @return el valor que se encuentra en la parte superior de la stack
     * @throws IllegalStateException si la pila esta vacía
     */

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La stack está vacía");
        }
        return top.data;
    }
}