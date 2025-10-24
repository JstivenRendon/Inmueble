package co.edu.uniquindio.fx10.modelo;

public class InmuebleFactory {
    public static Inmueble crearInmueble(String tipo, String ciudad, int habitaciones, int pisos, double precio) {
        return new InmuebleBuilder()
                .setTipo(tipo)
                .setCiudad(ciudad)
                .setHabitaciones(habitaciones)
                .setPisos(pisos)
                .setPrecio(precio)
                .build();
    }
}
