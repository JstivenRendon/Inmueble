package co.edu.uniquindio.fx10.modelo;

public class InmuebleBuilder {
    private String tipo;
    private String ciudad;
    private int habitaciones;
    private int pisos;
    private double precio;

    public InmuebleBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public InmuebleBuilder setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public InmuebleBuilder setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
        return this;
    }

    public InmuebleBuilder setPisos(int pisos) {
        this.pisos = pisos;
        return this;
    }

    public InmuebleBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public Inmueble build() {
        return new Inmueble(tipo, ciudad, habitaciones, pisos, precio);
    }
}
