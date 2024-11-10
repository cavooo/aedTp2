package aed;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxHeap<T> {
    private ArrayList<T> maxHeap;
    private Comparator<T> comparator;
    private int altura;
    private int cardinal;

    public MaxHeap(Comparator<T> comparator) {
        this.maxHeap = new ArrayList<>();
        this.comparator = comparator;
        this.altura = 0;
        this.cardinal = 0;
    }

    public int alturaHeap() {
        return altura;
    }

    public T primero() {
        if (isEmpty()) {
            throw new NoSuchElementException("maxHeap is empty");
        }
        return maxHeap.get(0);
    }

    public void encolar(T value) {
        maxHeap.add(value);
        cardinal++;
        upHeap(cardinal - 1);
        calcularAltura();
    }

    public void desencolar() {
        if (isEmpty()) {
            throw new NoSuchElementException("maxHeap is empty");
        }
        cambiar(0, cardinal - 1);
        maxHeap.remove(cardinal - 1);
        cardinal--;
        calcularAltura();
        if (cardinal > 0) {
            heapifyDown(0);
        }
    }

    public void calcularAltura() {
        altura = (int) Math.floor(Math.log(cardinal + 1) / Math.log(2));
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public T get(int i) {
        if (i < 0 || i > cardinal - 1) {
            throw new NoSuchElementException("maxHeap is empty");
        } else {
            return maxHeap.get(i);
        }
    }

    public int cardinalHeap() {
        return cardinal;
    }

    public void cambiar(int i, int j) {
        T temp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, temp);
    }

    public void upHeap(int i) {
        while (i > 0 && comparator.compare(maxHeap.get(i), maxHeap.get(padre(i))) > 0) {
            cambiar(i, padre(i));
            i = padre(i);
        }
    }

    public void heapifyDown(int i) {
        T value = maxHeap.get(i);
        while (i < cardinal / 2) {
            int hijoIzq = hijoIzq(i);
            int hijoDer = hijoDer(i);
            int largestIdx = hijoIzq;

            if (hijoDer < cardinal && comparator.compare(maxHeap.get(hijoDer), maxHeap.get(hijoIzq)) > 0) {
                largestIdx = hijoDer;
            }

            if (comparator.compare(value, maxHeap.get(largestIdx)) >= 0) {
                break;
            }

            maxHeap.set(i, maxHeap.get(largestIdx));
            i = largestIdx;
        }
        maxHeap.set(i, value);
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
}
