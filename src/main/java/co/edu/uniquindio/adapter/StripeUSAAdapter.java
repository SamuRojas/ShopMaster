package co.edu.uniquindio.adapter;


import co.edu.uniquindio.facade.ProcesadorPago;
import co.edu.uniquindio.util.Formato;

// Adapter: permite usar StripeUSA como si fuera un ProcesadorPago más de la tienda
public class StripeUSAAdapter implements ProcesadorPago {

    private StripeUSA stripe; //Referencia interna al sistema externo

    public StripeUSAAdapter(StripeUSA stripe){
        this.stripe = stripe;
    }

    @Override
    public void cobrarEnPesos(String usuario, double montoCOP){

        //Conversion 1usd = 4000COP
        double montoUSD = montoCOP/ 4000;
        System.out.println("[ADAPTADOR] Convirtiendo " + Formato.cop(montoCOP) + " COP a " + Formato.usd(montoUSD));

        //Datos que exigen
        String correoCliente = usuario + "@cliente.shopmaster.com";
        String claveComercio ="SM,ShopMaster2026";

        //delegacion
        stripe.chargeInDollars(montoUSD, correoCliente, claveComercio);
    }
}
