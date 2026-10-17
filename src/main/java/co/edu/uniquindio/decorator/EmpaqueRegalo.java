package co.edu.uniquindio.decorator;

import co.edu.uniquindio.composite.Producto;

public class EmpaqueRegalo extends ServicioDecorator {

    public EmpaqueRegalo(Producto contenido) {
        super(contenido);
    }

    @Override
    public double getPrecio() {
        return contenido.getPrecio() + 15_000;
    }

    @Override
    protected String etiqueta() {
        return "Empaque de Regalo Premium (+$15.000)";
    }
}
