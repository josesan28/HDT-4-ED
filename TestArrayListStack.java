import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestArrayListStack {
    
    @Test
    public void testPush() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    public void testPop() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPeek() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        stack.pop();
        assertEquals(1, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("La stack esta vacía", exception.getMessage());
    }

    @Test
    public void testPeekEmptyStack() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        Exception exception = assertThrows(IllegalStateException.class, stack::peek);
        assertEquals("La stack esta vacía", exception.getMessage());
    }
}

