package co.edu.uniquindio;

import co.edu.uniquindio.composite.Combo;
import co.edu.uniquindio.composite.Producto;
import co.edu.uniquindio.composite.ProductoIndividual;
import co.edu.uniquindio.facade.ShopMasterFacade;
import co.edu.uniquindio.facade.TipoServicio;

import java.util.List;

public class Main {
    public static void main(String[] args){

        ShopMasterFacade tienda = new ShopMasterFacade();

        System.out.println("=== CASO 1: COMPRA EXITOSA COMPLETA ===");
        Combo KitLimpieza = new Combo("kit de limpieza");
        KitLimpieza.agregar(new ProductoIndividual("Paño de MicroFibra", 25000));
        KitLimpieza.agregar(new ProductoIndividual("Spray Limpiador", 15000));

        Combo comboGamer = new Combo("Combo Gamer");
        comboGamer.agregar(new ProductoIndividual("Monitor", 800000));
        comboGamer.agregar(new ProductoIndividual("Teclado", 200000));
        comboGamer.agregar(KitLimpieza);

        tienda.ejecutarCompraRapida("cliente_vip", comboGamer,
                List.of(TipoServicio.GARANTIA_EXTENDIDA, TipoServicio.EMPAQUE_REGALO));

        System.out.println("\n === Caso 2: RECHAZO POR TOPE DINERO === ");
        Producto servidor = new ProductoIndividual("Servidor empresarial", 6000000);

        tienda.ejecutarCompraRapida("UsuarioNormal", servidor,
                List.of(TipoServicio.MANEJO_PRIORITARIO));

        System.out.println("\n === CASO 3: RECHAZO POR USUSARIO REPORTADO ===" );
        Producto mouse= new ProductoIndividual("Mouse ", 150000);

        tienda.ejecutarCompraRapida("BLOQUEADO", mouse, List.of());


    }
}
