import java.util.Scanner;

public class Q03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String[] nomeJogadores = new String[10];
        int[][] infoJogadores = new int[nomeJogadores.length][3];
        int qtddCadastrados = 0;
        int maiorAltura = 0;

        boolean adicionandoJogadores = true;
        int aux = 0;
        while (adicionandoJogadores && qtddCadastrados < nomeJogadores.length) {

            System.out.println("Digite [SAIR] no lugar do nome do jogador para parar de adicionar.");
            System.out.print("Nome do jogador: ");
            String nome = entrada.nextLine();

            if (!nome.equalsIgnoreCase("sair")) {
                System.out.print("Altura: ");
                int altura = entrada.nextInt();

                if (altura > maiorAltura) {
                    maiorAltura = altura;
                }

                System.out.print("Idade: ");
                int idade = entrada.nextInt();

                System.out.print("Peso dos jogador: ");
                int peso = entrada.nextInt();

                entrada.nextLine();

                nomeJogadores[aux] = nome;
                infoJogadores[aux][0] = altura;
                infoJogadores[aux][1] = idade;
                infoJogadores[aux++][2] = peso;

                ++qtddCadastrados;
            } else {
                adicionandoJogadores = false;
            }
            System.out.println();
        }
        if (qtddCadastrados > 0) {
            // 0 = maisVelho, 1 = maisPesado
            String[] jogadorMaisVelhoEJogadorMaisPesado = {nomeJogadores[0], nomeJogadores[0]};

            for (int i = 0; i < qtddCadastrados; i++) {
                if (infoJogadores[i][1] < infoJogadores[i + 1][1]) {
                    jogadorMaisVelhoEJogadorMaisPesado[0] = nomeJogadores[i + 1];
                }

                if (infoJogadores[i][2] < infoJogadores[i + 1][2]) {
                    jogadorMaisVelhoEJogadorMaisPesado[1] = nomeJogadores[i + 1];
                }
            }

            System.out.println(qtddCadastrados + " cadastrados.");
            System.out.println("O jogador mais alto tem " + maiorAltura + " de altura.");
            System.out.println(jogadorMaisVelhoEJogadorMaisPesado[0] + " é o jogador mais velho.");
            System.out.println(jogadorMaisVelhoEJogadorMaisPesado[1] + " é o jogador mais pesado.");

        } else {
            System.out.println("Não existe jogadores cadastrados para comparação.");
        }
    }
}
