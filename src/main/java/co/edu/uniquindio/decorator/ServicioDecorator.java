package co.edu.uniquindio.decorator;

import co.edu.uniquindio.composite.Producto;

public abstract class ServicioDecorator implements Producto {

    protected final Producto contenido;

    protected ServicioDecorator(Producto contenido) {
        this.contenido = contenido;
    }

    protected abstract String etiqueta();

    @Override
    public String getNombre() {
        return contenido.getNombre() + " + " + etiqueta();
    }

    @Override
    public void mostrar(String indentacion) {
        contenido.mostrar(indentacion);
        System.out.println(indentacion + "   - " + etiqueta());
    }
}
