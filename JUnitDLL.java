import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Junit donde se probaran los metodos de la clase DoublyLinkedList
 */
public class JUnitDLL {
    private DoublyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    void testAdd() {
        list.add(10);
        assertFalse(list.isEmpty());
        assertEquals(10, list.peek());
    }

    @Test
    void testRemove() {
        list.add(20);
        list.add(30);
        int removed = list.remove(0);
        assertEquals(20, removed);
        assertEquals(30, list.peek());
    }

    @Test
    void testPeek() {
        list.add(40);
        assertEquals(40, list.peek());
    }

    @Test
    void testPush() {
        list.push(50);
        assertEquals(50, list.peek());
    }

    @Test
    void testPop() {
        list.push(60);
        int popped = list.pop();
        assertEquals(60, popped);
        assertTrue(list.isEmpty());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(10);
        assertFalse(list.isEmpty());
    }
}
