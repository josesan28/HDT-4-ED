import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit donde se probaran los metodos de la clase SinglyLinkedList
 */

public class JUnitSLL {
    private SinglyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    void testAdd() {
        list.add(10);
        list.add(20);
        assertEquals(2, list.size);  
    }

    @Test
    void testRemove() {
        list.add(10);
        list.add(20);
        int removed = list.remove(0);
        assertEquals(10, removed);
        assertEquals(1, list.size);  
    }

    @Test
    void testPeek() {
        list.add(10);
        list.add(20);
        assertEquals(20, list.peek());
    }

    @Test
    void testPush() {
        list.push(10);
        list.push(20);
        assertEquals(2, list.size);  
    }

    @Test
    void testPop() {
        list.push(10);
        list.push(20);
        assertEquals(20, list.pop());
        assertEquals(1, list.size);  
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(10);
        assertFalse(list.isEmpty());
    }
}
