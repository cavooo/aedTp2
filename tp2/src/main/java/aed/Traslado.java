package aed;

public class Traslado implements Comparable<Traslado> {

    int id;
    int origen;
    int destino;
    int gananciaNeta;
    int timestamp;

    public Traslado(int id, int origen, int destino, int gananciaNeta, int timestamp) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.gananciaNeta = gananciaNeta;
        this.timestamp = timestamp;
    }

    public int getGananciaNeta() {
        return this.gananciaNeta;
    }

    @Override
    public int compareTo(Traslado otro) {
        return Integer.compare(this.gananciaNeta, otro.gananciaNeta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Traslado traslado = (Traslado) obj;
        return id == traslado.id &&
                origen == traslado.origen &&
                destino == traslado.destino &&
                gananciaNeta == traslado.gananciaNeta &&
                timestamp == traslado.timestamp;
    }
}
