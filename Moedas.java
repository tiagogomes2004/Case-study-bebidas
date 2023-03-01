public class Moedas {
    public static final Moedas CINCO = new Moedas(5);
    public static final Moedas DEZ = new Moedas(10);
    public static final Moedas VINTE = new Moedas(20);
    public static final Moedas CINQUENTA = new Moedas(50);

    public static final Moedas[] moedas = {CINCO, DEZ, VINTE, CINQUENTA};

    private final int valor;

    private Moedas(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
