import java.util.*;

public class Maquina {
    private final LinkedHashMap<Bebida, Integer> bebidas = new LinkedHashMap<>();
    private final LinkedHashMap<Moeda, Integer> maquinaMoedas = new LinkedHashMap<>();

    private int valorInserido = 0;
    public Maquina() {
        resetMaquina();
    }

    public int getValorInserido() {
        return valorInserido;
    }

    public void inserirValor() {
        Scanner teclado = new Scanner(System.in);
        int valor;
        char insereMais;

        do {
            System.out.println("Insira uma moeda (5, 10, 20, 50): ");
            valor = teclado.nextInt();
            teclado.nextLine();

            for (Moeda m : Moeda.moedasSet) {
                if (valor == m.getValor()) {
                    valorInserido += valor;

                    maquinaMoedas.put(m, maquinaMoedas.get(m) + 1);
                }
            }
            System.out.println("Saldo atual: " + valorInserido);

            do {
                System.out.println("Pretende inserir mais moedas? (S/N)");
                insereMais = Character.toUpperCase(teclado.next().charAt(0));
            } while (insereMais != 'N' && insereMais != 'S');
        } while (insereMais != 'N');
    }

    public void pedirBebida() {
        System.out.println("Lista de bebidas: ");
        for (var b : bebidas.entrySet()) {
            System.out.println(b.getKey().getId() + ". " + b.getKey().getNome() + "(" + b.getValue() + "): 0." + b.getKey().getPreco() + "€");
        }

        Scanner teclado = new Scanner(System.in);
        int escolha = teclado.nextInt();
        Bebida bebidaEscolhida = Bebida.COCA_COLA;

        for (var b : bebidas.entrySet()) {
            if (b.getKey().getId() == escolha) {
                bebidaEscolhida = b.getKey();
            }
        }

        if (valorInserido >= bebidaEscolhida.getPreco()) {
            valorInserido -= bebidaEscolhida.getPreco();
            bebidas.put(bebidaEscolhida, bebidas.get(bebidaEscolhida) - 1);
        } else {
            System.out.println("Valor insuficiente, insira mais moedas.");
            return;
        }
        darTroco();
    }

    private void darTroco() {
        int troco = 0;
        for (var moedas : maquinaMoedas.entrySet()) {
            while (valorInserido - moedas.getKey().getValor() >= 0 && moedas.getValue() > 0) {
                moedas.setValue(moedas.getValue() - 1);
                valorInserido -= moedas.getKey().getValor();
                troco += moedas.getKey().getValor();
            }
        }

        System.out.println("Troco: " + troco);

        if (valorInserido > 0) {
            System.out.println("Ficou na maquina: " + valorInserido);
            System.out.println("Pedimos desculpa, mas a maquina nao tem mais moedas. :(");
        }
    }

    public void cancelar() {
        darTroco();
    }

    public void resetMaquina() {
        valorInserido = 0;
        bebidas.clear();
        maquinaMoedas.clear();

        for (Bebida b : Bebida.bebidas) {
            this.bebidas.put(b, 5);
        }

        for (Moeda m : Moeda.moedasSet) {
            this.maquinaMoedas.put(m, 5);
        }
    }
}
