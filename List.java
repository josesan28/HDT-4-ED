/**
 *  @author José Manuel Sanchez Hernández - 24092, Josué Antonio Isaac García Barrera - 24918 y Jose Alberto Abril Suchite 24585
 *  @version 1.0
 *  Descripción: clase abstracta que define los métodos que debe implementar una lista.
 *  Fecha de creación: 26/02/2025
 *  Fecha de última modificación: 27/02/2025
 */

public abstract class List<T>implements IStack<T> {
    
    protected int size;
    
    public abstract void add(T value);
    public abstract T remove(int index);
    public abstract T peek();
}