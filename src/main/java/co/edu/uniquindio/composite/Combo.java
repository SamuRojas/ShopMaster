package co.edu.uniquindio.composite;

import co.edu.uniquindio.util.Formato;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Producto {

    private final String nombre;
    private final List<Producto> componentes = new ArrayList<>();

    public Combo(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Producto producto) {
        componentes.add(producto);
    }

    public void quitar(Producto producto) {
        componentes.remove(producto);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        double total = 0;
        for (Producto componente : componentes) {
            total += componente.getPrecio();
        }
        return total;
    }

    @Override
    public void mostrar(String indentacion) {
        System.out.println(indentacion + "- " + nombre + " [" + Formato.cop(getPrecio()) + "]");
        for (Producto componente : componentes) {
            componente.mostrar(indentacion + "   ");
        }
    }
}
