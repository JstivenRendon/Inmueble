package co.edu.uniquindio.fx10.repositorio;

import co.edu.uniquindio.fx10.modelo.Inmueble;
import java.util.ArrayList;
import java.util.List;

public class InmuebleRepository {

    private static InmuebleRepository instance;
    private final List<Inmueble> inmuebles = new ArrayList<>();

    private InmuebleRepository() {}

    public static InmuebleRepository getInstance() {
        if (instance == null) {
            instance = new InmuebleRepository();
        }
        return instance;
    }

    public void agregarInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
    }

    public void eliminarInmueble(Inmueble inmueble) {
        inmuebles.remove(inmueble);
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }
}
