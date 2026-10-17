package co.edu.uniquindio.facade;

import co.edu.uniquindio.adapter.AdaptadorStripeUSA;
import co.edu.uniquindio.adapter.StripeUSAGateway;
import co.edu.uniquindio.composite.Producto;
import co.edu.uniquindio.decorator.EmpaqueRegalo;
import co.edu.uniquindio.decorator.GarantiaExtendida;
import co.edu.uniquindio.decorator.ManejoPrioritario;
import co.edu.uniquindio.model.Pedido;
import co.edu.uniquindio.proxy.ProxySeguridadPago;
import co.edu.uniquindio.util.Formato;

import java.util.List;

public class ShopMasterFacade {

    private final ProcesadorPago procesador =
            new ProxySeguridadPago(new AdaptadorStripeUSA(new StripeUSAGateway()));

    public void ejecutarCompraRapida(String usuario, Producto producto, List<TipoServicio> extras) {
        Producto pedido = construirPedido(producto, extras);

        System.out.println("Pedido de " + usuario);
        pedido.mostrar("");
        System.out.println("Total: " + Formato.cop(pedido.getPrecio()) + " COP");

        procesador.cobrarEnPesos(usuario, pedido.getPrecio());
    }

    private Producto construirPedido(Producto producto, List<TipoServicio> extras) {
        Producto pedido = new Pedido(producto);
        for (TipoServicio extra : extras) {
            pedido = aplicarExtra(pedido, extra);
        }
        return pedido;
    }

    private Producto aplicarExtra(Producto pedido, TipoServicio extra) {
        return switch (extra) {
            case GARANTIA_EXTENDIDA -> new GarantiaExtendida(pedido);
            case EMPAQUE_REGALO -> new EmpaqueRegalo(pedido);
            case MANEJO_PRIORITARIO -> new ManejoPrioritario(pedido);
        };
    }
}
