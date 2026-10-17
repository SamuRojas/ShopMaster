package co.edu.uniquindio.util;

import java.util.Locale;

public final class Formato {

    private Formato() {
    }

    public static String cop(double valor) {
        return "$" + String.format(Locale.US, "%,.0f", valor).replace(",", ".");
    }

    public static String usd(double valor) {
        return String.format(Locale.US, "%.2f", valor) + " USD";
    }
}
