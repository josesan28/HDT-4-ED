/**
 *  @author José Manuel Sanchez Hernández - 24092, Josué Antonio Isaac García Barrera - 24918 y Jose Alberto Abril Suchite 24585
 *  @version 1.0
 *  Descripción: Clase de pruebas unitarias para la clase Calculator
 *  Fecha de creación: 27/02/2025
 *  Fecha de última modificación: 27/02/2025
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCalculator {
    
    private Calculator calculator;

    /**
     * Inicializa la calculadora antes de cada prueba unitaria
     */
    @BeforeEach
    public void setUp() {
        calculator = Calculator.getInstance();
    }
    
    /**
     * Prueba unitaria para el método operation
     */

    @Test
    public void testOperation() {
        assertEquals(5, calculator.operation('+', 2, 3), "La suma de 2 y 3 es 5");
        assertEquals(6, calculator.operation('-', 3, 9), "La resta de 9 y 3 es 6");
        assertEquals(15, calculator.operation('*', 3, 5), "La multiplicación de 3 y 5 es 15");
        assertEquals(2, calculator.operation('/', 5, 10), "La división de 10 y 5 es 2");
        assertEquals(0, calculator.operation('%', 5,10), "El módulo de 10 y 5 es 0");
    }

    /**
     * Prueba unitaria para el método infixToPostfix
     */
    @Test
    public void testInfixToPostfix() {
        assertEquals("A B +", calculator.infixToPostfix("A+B", new VectorStack<Character>()), "La conversión de A + B a postfix es A B +");
        assertEquals("A B C + *", calculator.infixToPostfix("A*(B+C)", new ArrayListStack<Character>()), "La conversión de A * (B + C) a postfix es A B C + *"); 
        assertEquals("A B C * D / +", calculator.infixToPostfix("A+B*C/D", new SinglyLinkedList<Character>()), "La conversión de A + B * C / D a postfix es A B C * D / +"); 
        assertEquals("A B C * D / + E F * G / - H +", calculator.infixToPostfix("A+B*C/D-E*F/G+H", new DoublyLinkedList<Character>()), "La conversión de A + B * C / D - E * F / G + H a postfix es A B C * D / + E F * G / - H +");
    }

    /**
     * Prueba unitaria para el método precedence
     */
    @Test
    public void testPrecedence() {
        assertEquals(2, calculator.precedence('*'), "La precedencia de * es 2");
        assertEquals(2, calculator.precedence('/'), "La precedencia de / es 2");
        assertEquals(2, calculator.precedence('%'), "La precedencia de % es 2");
        assertEquals(1, calculator.precedence('+'), "La precedencia de + es 1");
        assertEquals(1, calculator.precedence('-'), "La precedencia de - es 1");
        assertEquals(0, calculator.precedence('#'), "La precedencia de # es 0");
    }
}