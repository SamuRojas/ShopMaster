package co.edu.uniquindio.model;

import co.edu.uniquindio.composite.Producto;

public class Pedido implements Producto {

    private final Producto contenido;

    public Pedido(Producto contenido) {
        this.contenido = contenido;
    }

    @Override
    public String getNombre() {
        return contenido.getNombre();
    }

    @Override
    public double getPrecio() {
        return contenido.getPrecio();
    }

    @Override
    public void mostrar(String indentacion) {
        System.out.println(indentacion + "PEDIDO");
        contenido.mostrar(indentacion + "   ");
    }
}
