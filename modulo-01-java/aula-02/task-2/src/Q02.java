import java.util.Arrays;
import java.util.Scanner;

public class Q02 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int numeroSorteado = 31;

        int escolhaCliente = 0;
        while (escolhaCliente != numeroSorteado && escolhaCliente != -1) {
            System.out.print("Escolha um número [-1 para sair]: ");
            escolhaCliente = entrada.nextInt();

            if (escolhaCliente == numeroSorteado) {
                System.out.println("\n-- Você acertou!!! --");
            } else if (escolhaCliente < numeroSorteado){
                System.out.println("\n-- Errado.. é menor que " + escolhaCliente + "--");
            } else {
                System.out.println("\n-- Errado.. é maior que " + escolhaCliente + "--");
            }
            System.out.println("Agora outra rodada... \n");
        }

        if (escolhaCliente == -1) {
            System.out.println("Você desistiu.. o número era: " + numeroSorteado);
        }

        entrada.close();
    }
}
