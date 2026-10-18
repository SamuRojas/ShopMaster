package co.edu.uniquindio.composite;

import co.edu.uniquindio.util.Formato;

public class    ProductoIndividual implements Producto {

    private final String nombre;
    private final double precio;

    public ProductoIndividual(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void mostrar(String indentacion) {
        System.out.println(indentacion + "- " + nombre + " [" + Formato.cop(precio) + "]");
    }
}
