public class Bebida {
    public static final Bebida COCA_COLA = new Bebida(1, "Coca-Cola", 70);
    public static final Bebida PEPSI = new Bebida(2, "Pepsi", 65);
    public static final Bebida ICE_TEA = new Bebida(3, "Ice Tea", 60);
    public static final Bebida[] bebidas = {COCA_COLA, PEPSI, ICE_TEA};
    private final int id;
    private final String nome;
    private final int preco;

    public Bebida(int id, String nome, int preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }
}
