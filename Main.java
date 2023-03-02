import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Maquina maquina = new Maquina();
        int escolhaMenu;

        do {
            escolhaMenu = menu(maquina);

            switch (escolhaMenu) {
                case 1 -> maquina.inserirValor();
                case 2 -> maquina.pedirBebida();
                case 3 -> maquina.cancelar();
                case 999 -> menuTecnico(maquina);
                case 0 -> System.out.println("Adeus!!!");
                default -> System.out.println("Escolha invalida, tente novamente.");
            }
        } while (escolhaMenu != 0);
    }

    public static int menu(Maquina maquina) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("---------------Maquina de vendas---------------");
        System.out.println("Saldo: " + maquina.getValorInserido());
        System.out.println("***********************************************");
        System.out.println("1. Inserir moedas");
        System.out.println("2. Escolher bebida");
        System.out.println("3. Cancelar");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opcao: ");
        return teclado.nextInt();
    }

    public static void menuTecnico(Maquina maquina) {
        Scanner teclado = new Scanner(System.in);
        int escolha;

        System.out.println("***************Menu de tecnico***************");
        System.out.println("1. Reiniciar maquina");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opcao: ");
        escolha = teclado.nextInt();

        if (escolha == 1) {
            maquina.resetMaquina();
        }
    }
}
