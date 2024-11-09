package aed;

import java.util.ArrayList;
import aed.MaxHeap;
import aed.MinHeap;

public class BestEffort {
    
    private int[] superavitCiudades;
    private int cantCiudades;  
    private MaxHeap<Traslado> masRedituables;    
    private MinHeap<Traslado> masAntiguo;

    public BestEffort(int cantCiudades, Traslado[] traslados) {
        this.cantCiudades = cantCiudades;
        this.superavitCiudades = new int[cantCiudades];
        registrarTraslados(traslados);
        this.masRedituables = new MaxHeap<>();  
    }

    public void registrarTraslados(Traslado[] traslados){
            for (Traslado traslado : traslados) {
            superavitCiudades[traslado.origen] -= traslado.gananciaNeta;
            superavitCiudades[traslado.destino] += traslado.gananciaNeta;
        }
    }


    
    public int[] despacharMasRedituables(int n){                            // O(n (log(|T|) + log(|C|)))
        int[] trasladosDespachados = new ArrayList<>();
            

        for (int i = 0 ; i < n && !masRedituables.isEmpty() ; i++){
            Traslado trasladoMasRedituable = masRedituables.primero();
            trasladosDespachados.add(trasladoMasRedituable.id);
            masRedituables.desencolar();
        }

        return trasladosDespachados;
    }







        public int[] despacharMasAntiguos(int n){
            // Implementar
            return null;
        }






        public int ciudadConMayorSuperavit() {  // O(1)
            MaxHeap<int[]> maxHeap = new MaxHeap<>(); // Instancia del MaxHeap

            // Llena el MaxHeap con los valores de superávit
            for (int ciudad = 0; ciudad < cantCiudades; ciudad++) {
                int[] entry = {ciudad, superavitCiudades[ciudad]};
                maxHeap.encolar(entry);
            }

            // Obtener el primer elemento del MaxHeap, que es la ciudad con mayor superávit
            int[] mayorSuperavit = maxHeap.primero();
            if (mayorSuperavit != null) {
                return mayorSuperavit[0];
            }
            return -1;  // o algún valor que indique que no se encontró ninguna ciudad
        }




        public ArrayList<Integer> ciudadesConMayorGanancia(){  // O(1)
            // Implementar
            return null;
        }

        public ArrayList<Integer> ciudadesConMayorPerdida(){  // O(1)
            // Implementar
            return null;
        }

        public int gananciaPromedioPorTraslado(){  // O(1)
            // Implementar
            return 0;
        }
        
    }