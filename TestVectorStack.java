/**
 *  @author José Manuel Sanchez Hernández - 24092, Josué Antonio Isaac García Barrera - 24918 y Jose Alberto Abril Suchite 24585
 *  @version 1.0
 *  Descripción: Clase de pruebas unitarias para la clase VectorStack
 *  Fecha de creación: 27/02/2025
 *  Fecha de última modificación: 27/02/2025
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVectorStack {
    
    private VectorStack<Integer> stack;

    /**
     * Inicializa la pila antes de cada prueba unitaria
     */
    @BeforeEach
    public void setUp() {
        stack = new VectorStack<>();
    }
    
    /**
     * Prueba unitaria para el método isEmpty
     */
    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty(), "La pila debe estar vacía al inicio");
        stack.push(10);
        assertFalse(stack.isEmpty(), "La pila no debe estar vacía después de un push");
    }

    /**
     * Prueba unitaria para el método pop
     */
    @Test
    public void testPop() {
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop(), "El pop debe devolver el último elemento ingresado");
        assertEquals(20, stack.pop(), "El pop debe devolver el último elemento ingresado");
        assertTrue(stack.isEmpty(), "La pila debe estar vacía después de hacer pop de todos los elementos");
    }

    /**
     * Prueba unitaria para el método push
     */
    @Test
    public void testPush() {
        stack.push(40);
        assertFalse(stack.isEmpty(), "La pila no debe estar vacía después de un push");
        assertEquals(40, stack.peek(), "El elemento hasta arriba de la pila debe ser el último ingresado");
        stack.push(50);
        assertEquals(50, stack.peek(), "El elemento hasta arriba de la pila debe ser el último ingresado");
    }

    /**
     * Prueba unitaria para el método peek
     */
    @Test
    public void testPeek() {
        stack.push(60);
        assertEquals(60, stack.peek(), "El peek debe devolver el elemento que está hasta arriba de la pila");
        stack.push(70);
        assertEquals(70, stack.peek(), "El peek debe devolver el elemento que está hasta arriba de la pila");
    }
}