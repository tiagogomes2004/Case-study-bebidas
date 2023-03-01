import java.util.LinkedList;
import java.util.Scanner;

public class Maquina {
    private final LinkedList<Bebida> bebidas = new LinkedList<>();
    private final LinkedList<Moedas> moedas = new LinkedList<>();

    private int valorInserido = 0;
    public Maquina() {
        for (int i = 0; i < 5; i++) {
            this.bebidas.add(Bebida.COCA_COLA);
            this.bebidas.add(Bebida.PEPSI);
            this.bebidas.add(Bebida.ICE_TEA);
        }

        for (Moedas m : Moedas.moedas) {
            for (int i = 0; i < 5; i++) {
                this.moedas.add(m);
            }
        }
    }

    public void inserirValor() {
        Scanner teclado = new Scanner(System.in);
        int valor;
        char insereMais;

        do {
            System.out.println("Insira uma moeda (5, 10, 20, 50): ");
            valor = teclado.nextInt();
            teclado.nextLine();

            for (Moedas m : Moedas.moedas) {
                if (valor == m.getValor()) {
                    valorInserido += valor;
                }
            }
            System.out.println("Saldo atual: " + valorInserido);

            do {
                System.out.println("Pretende inserir mais moedas? (S/N)");
                insereMais = Character.toUpperCase(teclado.next().charAt(0));
            } while (insereMais != 'N' && insereMais != 'S');
        } while (insereMais != 'N');
    }

    public void pedirBebida(int n) {
        Bebida bebidaPedida = bebidas.get(n + 1);

    }

    public void resetMaquina(Tecnico tecnico) {
        bebidas.clear();
        moedas.clear();
    }
}
