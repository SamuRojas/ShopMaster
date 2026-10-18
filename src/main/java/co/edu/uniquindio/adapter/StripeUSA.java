package co.edu.uniquindio.adapter;

import co.edu.uniquindio.util.Formato;

public class StripeUSA {

    public StripeUSA() {
        System.out.println("[StripeUSA] Conectando con la pasarela de Estados Unidos...");
    }

    public void chargeInDollars(double amountUSD, String customerEmail, String merchantKey) {
        System.out.println("[StripeUSA] Cobrando " + Formato.usd(amountUSD) + " a " + customerEmail + " (merchantKey: " + merchantKey + ")");
    }

}
