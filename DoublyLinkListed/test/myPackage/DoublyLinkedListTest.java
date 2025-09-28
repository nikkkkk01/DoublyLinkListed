package myPackage;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    public void testAddFirst() {
        list.addFirst(10);
        list.addFirst(20);
        assertEquals((Integer) 20, list.get(0));
        assertEquals((Integer) 10, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testAddLast() {
        list.addLast(10);
        list.addLast(20);
        assertEquals((Integer) 10, list.get(0));
        assertEquals((Integer) 20, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveFirst() {
        list.addFirst(10);
        list.addFirst(20);
        Integer removed = list.removeFirst();
        assertEquals((Integer) 20, removed);
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveLast() {
        list.addFirst(10);
        list.addLast(20);
        Integer removed = list.removeLast();
        assertEquals((Integer) 20, removed);
        assertEquals(1, list.size());
    }

    @Test
    public void testInsertAtIndex() {
        list.addFirst(10);
        list.addLast(30);
        list.insertAtIndex(1, 20);
        assertEquals((Integer) 10, list.get(0));
        assertEquals((Integer) 20, list.get(1));
        assertEquals((Integer) 30, list.get(2));
    }

    @Test
    public void testDeleteAtIndex() {
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        Integer deleted = list.deleteAtIndex(1);
        assertEquals((Integer) 20, deleted);
        assertEquals(2, list.size());
    }

    @Test
    public void testContains() {
        list.addFirst(10);
        list.addLast(20);
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertFalse(list.contains(30));
    }

    @Test
    public void testReverse() {
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.reverse();
        assertEquals((Integer) 30, list.get(0));
        assertEquals((Integer) 20, list.get(1));
        assertEquals((Integer) 10, list.get(2));
    }

    @Test
    public void testSwapNodesNonAdjacent() {
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.swapNodes(0, 2);
        assertEquals((Integer) 30, list.get(0));
        assertEquals((Integer) 20, list.get(1));
        assertEquals((Integer) 10, list.get(2));
    }

    @Test
    public void testSwapNodesAdjacent() {
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.swapNodes(1, 2);
        assertEquals((Integer) 10, list.get(0));
        assertEquals((Integer) 30, list.get(1));
        assertEquals((Integer) 20, list.get(2));
    }

    @Test
    public void testSwapNodesSameIndex() {
        list.addFirst(10);
        list.addLast(20);
        list.swapNodes(0, 0);
        assertEquals((Integer) 10, list.get(0));
        assertEquals((Integer) 20, list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAtIndexOutOfBounds() {
        list.insertAtIndex(1, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteAtIndexOutOfBounds() {
        list.deleteAtIndex(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        list.get(0);
    }
}