package co.edu.uniquindio.fx10.modelo;

import co.edu.uniquindio.fx10.repositorio.InmuebleRepository;

public class InmuebleFacade {

    private static InmuebleFacade instance;
    private final InmuebleRepository repository;

    private InmuebleFacade() {
        repository = InmuebleRepository.getInstance();
    }

    public static InmuebleFacade getInstance() {
        if (instance == null) {
            instance = new InmuebleFacade();
        }
        return instance;
    }

    public Inmueble agregarInmueble(String tipo, String ciudad, int habitaciones, int pisos, double precio) {

        Inmueble inmueble = InmuebleFactory.crearInmueble(tipo, ciudad, habitaciones, pisos, precio);
        repository.agregarInmueble(inmueble);
        return inmueble;
    }

    public void eliminarInmueble(Inmueble inmueble) {
        repository.eliminarInmueble(inmueble);
    }

}
