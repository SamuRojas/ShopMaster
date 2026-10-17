package co.edu.uniquindio.decorator;

import co.edu.uniquindio.composite.Producto;

public class ManejoPrioritario extends ServicioDecorator {

    public ManejoPrioritario(Producto contenido) {
        super(contenido);
    }

    @Override
    public double getPrecio() {
        return contenido.getPrecio() + 25_000;
    }

    @Override
    protected String etiqueta() {
        return "Manejo Prioritario Frágil (+$25.000)";
    }
}
