/**
 *  @author José Manuel Sanchez Hernández - 24092, Josué Antonio Isaac García Barrera - 24918 y Jose Alberto Abril Suchite 24585
 *  @version 1.0
 *  Descripción: Clase abstracta que define los métodos que debe implementar una pila.
 *  Fecha de creación: 26/02/2025
 *  Fecha de última modificación: 27/02/2025
 */

public abstract class Stack<T> implements IStack<T> {

    //Atributos
    protected int size;

    //Métodos
    public abstract void push(T item);
    public abstract T pop();
    public abstract boolean isEmpty();
    public abstract T peek();
}