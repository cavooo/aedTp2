package aed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import java.util.Comparator;

public class MasRedituableHeapTest {

    private MaxHeap<Traslado> heap;

    @BeforeEach
    void setUp() {
        heap = new MaxHeap<>(Comparator.comparingInt(Traslado::getGananciaNeta));
    }

    @Test
    void testEncolar() {
        Traslado traslado1 = new Traslado(100, 1, 2, 5000, 123456789);
        Traslado traslado2 = new Traslado(200, 2, 3, 10000, 987654321);
        
        heap.encolar(traslado1);
        heap.encolar(traslado2);

        assertEquals(traslado2, heap.primero(), "El traslado más redituable debería estar primero");
    }

    @Test
    void testDesencolar() {
        Traslado traslado1 = new Traslado(100, 1, 2, 0, 123456789);
        Traslado traslado2 = new Traslado(200, 2, 3, 10000, 987654321);
     
        heap.encolar(traslado1);
        heap.encolar(traslado2);
        heap.desencolar();

        assertEquals(traslado1, heap.primero(), "El traslado restante debería ser el que antes era el menos redituable");
    }

    @Test
    void testOrdenConVariosElementos() {
        Traslado traslado1 = new Traslado(100, 1, 2, 5000, 123456789);
        Traslado traslado2 = new Traslado(200, 2, 3, 10000, 987654321);
        Traslado traslado3 = new Traslado(150, 3, 4, 7000, 112233445);
        
        heap.encolar(traslado1);
        heap.encolar(traslado2);
        heap.encolar(traslado3);

        assertEquals(traslado2, heap.primero(), "El primer desencolado debería ser el traslado con mayor ganancia neta");

        heap.desencolar();
        assertEquals(traslado3, heap.primero(), "El segundo desencolado debería ser el traslado con el segundo mayor rédito");

        heap.desencolar();
        assertEquals(traslado1, heap.primero(), "El último desencolado debería ser el traslado con el menor rédito");
    }

    @Test
    void testHeapVacio() {
        assertTrue(heap.isEmpty(), "El heap debería estar vacío al inicio");
        
        assertThrows(NoSuchElementException.class, heap::desencolar, "Desencolar un heap vacío debería lanzar excepción");
    }

    @Test
    void testAltura() {
        Traslado traslado1 = new Traslado(100, 1, 2, 5000, 123456789);
        Traslado traslado2 = new Traslado(200, 2, 3, 10000, 987654321);
        Traslado traslado3 = new Traslado(150, 3, 4, 7000, 112233445);
        
        heap.encolar(traslado1);
        heap.encolar(traslado2);
        heap.encolar(traslado3);

        assertEquals(2, heap.alturaHeap(), "La altura debería ser 1 con tres elementos");
    }

    @Test
    void testCardinal() {
        assertEquals(0, heap.cardinalHeap(), "El cardinal debería ser 0 al inicio");

        Traslado traslado1 = new Traslado(100, 1, 2, 5000, 123456789);
        Traslado traslado2 = new Traslado(200, 2, 3, 10000, 987654321);

        heap.encolar(traslado1);
        heap.encolar(traslado2);

        assertEquals(2, heap.cardinalHeap(), "El cardinal debería ser 2 después de encolar dos elementos");
    }
}
