package aed;

public class CiudadRedituabilidad implements Comparable<CiudadRedituabilidad> {
    int ciudad;
    int redituabilidad;

    public CiudadRedituabilidad(int ciudad, int redituabilidad) {
        this.ciudad = ciudad;
        this.redituabilidad = redituabilidad;
    }

    @Override
    public int compareTo(CiudadRedituabilidad other) {
        // Primero comparar por redituabilidad en orden descendente
        if (this.redituabilidad != other.redituabilidad) {
            return Integer.compare(other.redituabilidad, this.redituabilidad);
        }
        // Si la redituabilidad es igual, ordenar por ciudad en orden ascendente
        return Integer.compare(this.ciudad, other.ciudad);
    }

    @Override
    public String toString() {
        return "(" + ciudad + ", " + redituabilidad + ")";
    }
}


