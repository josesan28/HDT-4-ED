import java.util.ArrayList;

public class ArrayListStack<T> extends Stack<T> {
    public ArrayList<T> Array;
    
        /**
         * Constructor
         */
        public ArrayListStack() {
            this.size = Array.size();
            Array= new ArrayList<T>(size);
        }
    
    /**
     * Método para agregar un elemento a la stack
     */
    @Override
    public void push(T item) {
        Array.add(item);
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
        return Array.get(size -1);
    }

    /**
     * Método que verifica si el Stack esta vacio
     * @return true si la stack está vacía, false si no está vacía
     */
    @Override
    public boolean isEmpty() {
        return Array.isEmpty();
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
        return Array.get(size -1);
    }
}
