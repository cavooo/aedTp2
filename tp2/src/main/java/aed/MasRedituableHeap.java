package aed;

public class MasRedituableHeap extends MaxHeap<Traslado> {

    // Sobrescribir el método encolar para ajustar el criterio de comparación
    @Override
    public void encolar(Traslado traslado) {
        super.encolar(traslado); // Asegura que el encolado se haga en el MaxHeap
        heapifyUpByRedituable(cardinal - 1); // Realiza un heapify personalizado
    }

    // Método auxiliar para mantener el heap ordenado por rédito
    public void heapifyUpByRedituable(int i) {
        while (i > 0 && compareByRedituable(i, padre(i)) > 0) {
            cambiar(i, padre(i)); // Intercambia con el padre
            i = padre(i); // Sube al padre
        }
    }

    // Comparador de rédito
    public int compareByRedituable(int index1, int index2) {
        Traslado traslado1 = this.get(index1);
        Traslado traslado2 = this.get(index2);
        return Integer.compare(traslado1.gananciaNeta, traslado2.gananciaNeta);
    }

    // Método para obtener la altura del heap
    public int alturaHeap() {
        if (cardinal == 0) return -1;  // No hay elementos
        return (int) (Math.log(cardinal) / Math.log(2));
    }
}
