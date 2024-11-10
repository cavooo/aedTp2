package aed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxHeapTest {

    public MaxHeap<Integer> heap;

    @BeforeEach
    public void setUp() {
        // Proporcionamos un Comparator para que MaxHeap funcione con enteros
        heap = new MaxHeap<Integer>(Comparator.naturalOrder());
    }

    @Test
    public void testInsertarYPrimero() {
        heap.encolar(10);
        heap.encolar(20);
        heap.encolar(5);
        assertEquals(20, heap.primero(), "El elemento máximo debería ser 20");
    }

    @Test
    public void testAltura() {
        assertEquals(0, heap.alturaHeap(), "La altura de un heap vacío debería ser 0");
        heap.encolar(10);
        heap.encolar(20);
        heap.encolar(5);
        
        assertEquals(2, heap.alturaHeap(), "La altura debería ser 1 después de insertar 3 elementos");
    }

    @Test
    public void testEncolarYCardinal() {
        heap.encolar(15);
        assertEquals(1, heap.cardinalHeap(), "El cardinal debería ser 1 después de encolar un elemento");
        heap.encolar(25);
        heap.encolar(30);
        assertEquals(3, heap.cardinalHeap(), "El cardinal debería ser 3 después de encolar tres elementos");
    }

    @Test
    public void testDesencolar() {
        heap.encolar(15);
        assertEquals(15, heap.get(0), "El elemento máximo debería ser 15 al desencolar");
        heap.encolar(30);
        assertEquals(30, heap.get(0), "El elemento máximo debería ser 30 al desencolar");
        heap.encolar(20);
        heap.desencolar();
        assertEquals(20, heap.get(0), "El elemento máximo debería ser 20 al desencolar");
        assertEquals(2, heap.cardinalHeap(), "El cardinal debería ser 2 después de desencolar un elemento");

        assertEquals(20, heap.get(0), "El elemento máximo ahora debería ser 20");
    }

    @Test
    public void testDesencolarHastaVacio() {
        heap.encolar(10);
        heap.encolar(20);
        
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
        heap.encolar(20);
        heap.cambiar(0, 1);
        assertEquals(10, heap.primero(), "Después de intercambiar, el primer elemento debería ser 10");
    }

    @Test
    public void testHeapifyDown() {
        heap.encolar(30);
        heap.encolar(20);
        heap.encolar(25);
        heap.encolar(10);
        
        heap.heapifyDown(0);
        
        assertEquals(30, heap.primero(), "El elemento máximo debería ser 30 después de heapifyDown");
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
