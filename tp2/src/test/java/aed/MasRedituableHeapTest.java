package aed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

class MasRedituableHeapTest {

    private MasRedituableHeap heap;

    @BeforeEach
    void setUp() {
        heap = new MasRedituableHeap();
    }

    @Test
    void testEncolar() {
        // Crear traslados con diferentes valores de ganancia
        Traslado traslado1 = new Traslado(100, 1, 2, 5000, 123456789);
        Traslado traslado2 = new Traslado(200, 2, 3, 10000, 987654321);
        
        // Encolar los traslados
        heap.encolar(traslado1);
        heap.encolar(traslado2);

        // Verificar que el traslado con mayor ganancia neta esté primero
        assertEquals(traslado2, heap.primero(), "El traslado más redituable debería estar primero");
    }

    @Test
    void testDesencolar() {
        // Crear traslados con diferentes valores de ganancia
        Traslado traslado1 = new Traslado(100, 1, 2, 5000, 123456789);
        Traslado traslado2 = new Traslado(200, 2, 3, 10000, 987654321);
        
        // Encolar los traslados
        heap.encolar(traslado1);
        heap.encolar(traslado2);
        
        // Verificar que el traslado con mayor ganancia neta sea el primero en ser desencolado
        assertEquals(traslado2, heap.desencolar(), "El primer desencolado debería ser el traslado más redituable");
        assertEquals(traslado1, heap.primero(), "El siguiente en el heap debería ser el segundo más redituable");
    }

    @Test
    void testOrdenConVariosElementos() {
        // Crear traslados con diferentes valores de ganancia
        Traslado traslado1 = new Traslado(100, 1, 2, 5000, 123456789);
        Traslado traslado2 = new Traslado(200, 2, 3, 10000, 987654321);
        Traslado traslado3 = new Traslado(150, 3, 4, 7000, 112233445);
        
        // Encolar los traslados
        heap.encolar(traslado1);
        heap.encolar(traslado2);
        heap.encolar(traslado3);
5
        // Verificar que los traslados se desencolan en orden de mayor ganancia neta
        assertEquals(traslado2, heap.desencolar(), "El primer desencolado debería ser el traslado con más rédito (200)");
        assertEquals(traslado3, heap.desencolar(), "El segundo desencolado debería ser el traslado con el segundo mayor rédito (150)");
        assertEquals(traslado1, heap.desencolar(), "El último desencolado debería ser el traslado con el menor rédito (100)");
    }

    @Test
    void testHeapVacio() {
        // Verificar que el heap esté vacío al inicio
        assertTrue(heap.isEmpty(), "El heap debería estar vacío al inicio");
        
        // Verificar que se lance una excepción al desencolar de un heap vacío
        assertThrows(NoSuchElementException.class, heap::desencolar, "Desencolar un heap vacío debería lanzar excepción");
    }

    @Test
    void testAltura() {
        // Crear traslados con diferentes valores de ganancia
        Traslado traslado1 = new Traslado(100, 1, 2, 5000, 123456789);
        Traslado traslado2 = new Traslado(200, 2, 3, 10000, 987654321);
        Traslado traslado3 = new Traslado(150, 3, 4, 7000, 112233445);
        
        // Encolar los traslados
        heap.encolar(traslado1);
        heap.encolar(traslado2);
        heap.encolar(traslado3);

        // Verificar que la altura del heap sea correcta (dependiendo de la implementación de tu heap)
        assertEquals(1, heap.alturaHeap(), "La altura debería ser 1 con tres elementos");
    }

    @Test
    void testCardinal() {
        // Verificar que el cardinal del heap sea 0 al inicio
        assertEquals(0, heap.cardinalHeap(), "El cardinal debería ser 0 al inicio");

        // Crear traslados con diferentes valores de ganancia
        Traslado traslado1 = new Traslado(100, 1, 2, 5000, 123456789);
        Traslado traslado2 = new Traslado(200, 2, 3, 10000, 987654321);

        // Encolar los traslados
        heap.encolar(traslado1);
        heap.encolar(traslado2);

        // Verificar que el cardinal del heap sea 2 después de encolar dos elementos
        assertEquals(2, heap.cardinalHeap(), "El cardinal debería ser 2 después de encolar dos elementos");
    }
}
