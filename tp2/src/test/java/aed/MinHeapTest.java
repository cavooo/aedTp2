package aed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MinHeapTest {

    public MinHeap<Integer> heap;

    @BeforeEach
    public void setUp() {
        heap = new MinHeap<Integer>(Comparator.naturalOrder());
    }

    @Test
    public void testInsertarYPrimero() {
        heap.encolar(10);
        heap.encolar(20);
        heap.encolar(5);
        assertEquals(5, heap.primero(), "El elemento mínimo debería ser 5");
    }

    @Test
    public void testAltura() {
        assertEquals(0, heap.alturaHeap(), "La altura de un heap vacío debería ser 0");
        heap.encolar(10);
        heap.encolar(20);
        heap.encolar(5);
        
        assertEquals(2, heap.alturaHeap(), "La altura debería ser 2 después de insertar 3 elementos");
    }

    @Test
    public void testEncolarYCardinal() {
        heap.encolar(15);
        assertEquals(1, heap.cardinalHeap(), "El cardinal debería ser 1 después de encolar un elemento");
        heap.encolar(5);
        heap.encolar(30);
        assertEquals(3, heap.cardinalHeap(), "El cardinal debería ser 3 después de encolar tres elementos");
    }

    @Test
    public void testDesencolar() {
        heap.encolar(15);
        assertEquals(15, heap.get(0), "El elemento mínimo debería ser 15 al desencolar");
        heap.encolar(5);
        assertEquals(5, heap.get(0), "El elemento mínimo debería ser 5 al desencolar");
        heap.encolar(20);
        heap.desencolar();
        assertEquals(15, heap.get(0), "El elemento mínimo debería ser 15 después de desencolar");
        assertEquals(2, heap.cardinalHeap(), "El cardinal debería ser 2 después de desencolar un elemento");

        assertEquals(15, heap.get(0), "El elemento mínimo ahora debería ser 15");
    }

    @Test
    public void testDesencolarHastaVacio() {
        heap.encolar(10);
        heap.encolar(5);
        
        heap.desencolar();
        heap.desencolar();
        
        assertTrue(heap.isEmpty(), "El heap debería estar vacío después de desencolar todos los elementos");
    }

    @Test
    public void testPrimeroConHeapVacio() {
        assertThrows(NoSuchElementException.class, () -> {
            heap.primero();
        }, "Debería lanzar una excepción cuando se llama a primero en un heap vacío");
    }

    @Test
    public void testDesencolarConHeapVacio() {
        assertThrows(NoSuchElementException.class, () -> {
            heap.desencolar();
        }, "Debería lanzar una excepción cuando se intenta desencolar de un heap vacío");
    }

    @Test
    public void testSwap() {
        heap.encolar(10);
        heap.encolar(5);
        heap.cambiar(0, 1);
        assertEquals(10, heap.primero(), "Después de intercambiar, el primer elemento debería ser 10");
    }

    @Test
    public void testHeapifyDown() {
        heap.encolar(10);
        heap.encolar(20);
        heap.encolar(15);
        heap.encolar(30);
        
        heap.heapifyDown(0);
        
        assertEquals(10, heap.primero(), "El elemento mínimo debería ser 10 después de heapifyDown");
    }

    @Test
    public void testCalcularAltura() {
        heap.encolar(50);
        heap.encolar(30);
        heap.encolar(20);
        heap.encolar(10);
        assertEquals(2, heap.alturaHeap(), "La altura del heap debería ser 2 después de insertar 4 elementos");
    }
}
