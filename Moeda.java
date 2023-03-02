public class Moeda {
    private static final Moeda CINCO = new Moeda(5);
    private static final Moeda DEZ = new Moeda(10);
    private static final Moeda VINTE = new Moeda(20);
    private static final Moeda CINQUENTA = new Moeda(50);
    public static final Moeda[] moedasSet = {CINQUENTA, VINTE, DEZ, CINCO};

    private final int valor;

    private Moeda(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
