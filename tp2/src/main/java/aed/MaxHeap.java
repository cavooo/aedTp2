package aed;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MaxHeap<T extends Comparable<T>> {

    public ArrayList<T> maxHeap;
    public int altura;
    public int cardinal;

    public MaxHeap() {
        maxHeap = new ArrayList<>();
        altura = 0;
        cardinal = 0;
    }

    public T primero() {
        if (isEmpty()) {
            throw new NoSuchElementException("maxHeap is empty");
        }
        return maxHeap.get(0);
    }

    public void encolar(T value) {
        maxHeap.add(value); // Añadir al final del array
        cardinal++; // Incrementar el número de elementos en el heap
        upHeap(cardinal - 1); // Reorganizar el heap (restaurar Max-Heap)
        calcularAltura(); // Recalcular la altura del heap
    }

    public void desencolar() {
        if (isEmpty()) {
            throw new NoSuchElementException("maxHeap is empty");
        }

        cambiar(0,cardinal - 1);
        maxHeap.remove(cardinal-1);
        cardinal--;
        calcularAltura();
        if (cardinal > 0) {
            heapifyDown(0);
        }
    }

    public void calcularAltura() {
        int alturaNueva = (int) Math.floor(Math.log(cardinal + 1) / Math.log(2));
        if (alturaNueva != altura) {
            altura = alturaNueva;
        }
    }

    public T get(int i) {
        if (0 <= i && i < cardinal) {
            return maxHeap.get(i);
        } else {
            throw new NoSuchElementException("Index fuera de rango");
        }
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public int alturaHeap() {
        return this.altura;
    }

    public int cardinalHeap() {
        return this.cardinal;
    }

    public void cambiar(int i, int j) {
        if (i < 0 || i >= cardinal || j < 0 || j >= cardinal) {
            throw new NoSuchElementException("i,j fuera de rango");
        }
        T primero = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, primero);
    }

    public int padre(int i) {
        return (i - 1) / 2;
    }

    public int hijoIzq(int i) {
        return (2 * i) + 1;
    }

    public int hijoDer(int i) {
        return (2 * i) + 2;
    }

    public void heapifyDown(int i) {

        T value = maxHeap.get(i);

        while (i < cardinal / 2) { // while nodo tenga almenos un hijo

            int hijoIzq = hijoIzq(i);
            int hijoDer = hijoDer(i);
            int largestIdx = hijoIzq;

            // ve cual de los dos es el mas chiquito para desp borrarlo con el padre
            if (hijoDer < cardinal && maxHeap.get(hijoDer).compareTo(maxHeap.get(hijoIzq)) > 0) {
                largestIdx = hijoDer;
            }

            // Si el valor actual es mayor o igual al hijo mayor, termina
            if (value.compareTo(maxHeap.get(largestIdx)) >= 0) {
                break;
            }

            // sino, hace el intercambio
            maxHeap.set(i, maxHeap.get(largestIdx));
            i = largestIdx;
        }
        maxHeap.set(i, value);
    }

    public void upHeap(int i) {
        while (i > 0 && maxHeap.get(i).compareTo(maxHeap.get(padre(i))) > 0) {
            cambiar(i, padre(i));
            i = padre(i);
        }
    }
}