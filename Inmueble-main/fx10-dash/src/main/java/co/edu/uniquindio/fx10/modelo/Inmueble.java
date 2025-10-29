package co.edu.uniquindio.fx10.modelo;

public class Inmueble {
    private String tipo;
    private String ciudad;
    private int habitaciones;
    private int pisos;
    private double precio;

    public Inmueble(String tipo, String ciudad, int habitaciones, int pisos, double precio) {
        this.tipo = tipo;
        this.ciudad = ciudad;
        this.habitaciones = habitaciones;
        this.pisos = pisos;
        this.precio = precio;
    }

    public String getTipo() { return tipo; }
    public String getCiudad() { return ciudad; }
    public int getHabitaciones() { return habitaciones; }
    public int getPisos() { return pisos; }
    public double getPrecio() { return precio; }
}
