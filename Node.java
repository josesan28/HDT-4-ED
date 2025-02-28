/**
 *  @author José Manuel Sanchez Hernández - 24092, Josué Antonio Isaac García Barrera - 24918 y Jose Alberto Abril Suchite 24585
 *  @version 1.0
 *  Descripción: clase que representa un nodo.
 *  Fecha de creación: 26/02/2025
 *  Fecha de última modificación: 27/02/2025
 */

public class Node<T>{
    public T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }
}