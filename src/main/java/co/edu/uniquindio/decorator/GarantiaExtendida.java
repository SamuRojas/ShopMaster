package co.edu.uniquindio.decorator;

import co.edu.uniquindio.composite.Producto;

public class GarantiaExtendida extends ServicioDecorator {

    public GarantiaExtendida(Producto contenido) {
        super(contenido);
    }

    @Override
    public double getPrecio() {
        return contenido.getPrecio() * 1.10;
    }

    @Override
    protected String etiqueta() {
        return "Póliza de Garantía Extendida (+10%)";
    }
}
