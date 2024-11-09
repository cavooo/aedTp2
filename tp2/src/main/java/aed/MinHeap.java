package aed;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<T>> {

    public ArrayList<T> minHeap;
    public int altura;
    public int cardinal;

    public MinHeap() {
        minHeap = new ArrayList<>();
        altura = 0;
        cardinal = 0;
    }

    public T primero() {
        if (isEmpty()) {
            throw new NoSuchElementException("minHeap is empty");
        }
        return minHeap.get(0);
    }

    public void encolar(T value) {
        minHeap.add(value);
        cardinal++;
        upHeap(cardinal - 1);
        calcularAltura();
    }

    public void desencolar() {
        if (isEmpty()) {
            throw new NoSuchElementException("minHeap is empty");
        }
        cambiar(0, cardinal - 1);
        minHeap.remove(cardinal - 1);
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
            return minHeap.get(i);
        } else {
            throw new NoSuchElementException("Índice fuera de rango");
        }
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
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
        T primero = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, primero);
    }

    private int padre(int i) {
        return (i - 1) / 2;
    }

    private int hijoIzq(int i) {
        return (2 * i) + 1;
    }

    private int hijoDer(int i) {
        return (2 * i) + 2;
    }

    public void heapifyDown(int i) {
        T value = minHeap.get(i);

        while (i < cardinal / 2) { // Mientras el nodo tenga al menos un hijo
            int hijoIzq = hijoIzq(i);
            int hijoDer = hijoDer(i);
            int smallestIdx = i;

            // Verificamos cuál de los dos hijos es el menor
            if (hijoIzq < cardinal && minHeap.get(hijoIzq).compareTo(minHeap.get(smallestIdx)) < 0) {
                smallestIdx = hijoIzq;
            }

            if (hijoDer < cardinal && minHeap.get(hijoDer).compareTo(minHeap.get(smallestIdx)) < 0) {
                smallestIdx = hijoDer;
            }

            // Si el valor actual es menor que ambos hijos, terminamos
            if (smallestIdx == i) {
                break;
            }

            // Sino, realizamos el intercambio
            minHeap.set(i, minHeap.get(smallestIdx));
            i = smallestIdx; // Movemos el índice hacia abajo
        }

        // Colocamos el valor original en la posición correcta
        minHeap.set(i, value);
    }

    public void upHeap(int i) {
        while (i > 0 && minHeap.get(i).compareTo(minHeap.get(padre(i))) < 0) {
            cambiar(i, padre(i)); // Realizar el intercambio
            i = padre(i); // Subir al padre
        }
    }
}