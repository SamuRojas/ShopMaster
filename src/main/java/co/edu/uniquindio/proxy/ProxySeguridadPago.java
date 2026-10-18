package co.edu.uniquindio.proxy;

import co.edu.uniquindio.adapter.StripeUSAAdapter;
import co.edu.uniquindio.facade.ProcesadorPago;
import co.edu.uniquindio.util.Formato;

public class ProxySeguridadPago implements ProcesadorPago {

    private StripeUSAAdapter procesadorReal;

    @Override

    public void cobrarEnPesos ( String usuario, double montoCop){

        //Control usuario Reportado

        if("BLOQUEADO".equalsIgnoreCase(usuario)){
            System.out.println("[ACCESO DENEGADO] El usuario '" + usuario + "' se encuentra reportado. Transacción rechazada.");

            return;
        }

        //Control tope de dinero

        if(montoCop > 5000000){
            System.out.println("[ACCESO DENEGADO] El monto " + Formato.cop(montoCOP) + " COP supera el tope de $5.000.000 COP. Transacción rechazada.");
            return;
        }

        //Virtual Proxy

        if(procesadorReal == null){
            System.out.println("[PROXY] Datos válidos. Conectando con el procesador de pagos por primera vez...");
            procesadorReal = new StripeUSAAdapter(new StripeUSAAdapter());
        }

        // delegacion al procesador Real

        procesadorReal.cobrarEnPesos(usuario, montoCop);

        System.out.println("[AUDITORÍA: Transacción aprobada para " + usuario + " por " + Formato.cop(montoCOP) + " COP]");
        }

    }


