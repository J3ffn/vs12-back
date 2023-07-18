import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

    /**
     * Fonte das populações e IDH:
     * link: cidades.ibge.gov.br/brasil/
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Estados disponíveis: PB, CE, RS");
        System.out.print("Escolha: ");
        String escolha = entrada.next().toUpperCase();
        entrada.nextLine();

        String infoCidade = "Não existe";

        boolean valido = true;

        System.out.print("\nCidades disponíveis para a escolha: ");
        switch (escolha) {
            case "PB":
                System.out.println("Conceição, João Pessoa");
                break;
            case "CE":
                System.out.println("Mauriti, Fortaleza");
                break;
            case "RS":
                System.out.println("Porto Alegre, Arroio do Sal");
                break;
            default:
                valido = false;
                System.out.println("Não há!");
        }

        if (valido) {
            System.out.print("Digite o nome para consultar as informações: ");
            escolha = entrada.nextLine().toLowerCase();

            switch (escolha) {
                case "conceição":
                    infoCidade = "População: 28.260, principal festa: Junina, IDH: 0,592";
                    break;
                case "joão pessoa":
                    infoCidade = "População: 833.932, principal festa: Nossa Senhora da Penha, IDH: 0,763";
                    break;
                case "mauriti":
                    infoCidade = "População: 46.335, principal festa: Senhora Sant'Ana, IDH: 0,605";
                    break;
                case "fortaleza":
                    infoCidade = "População: 2.428.678, principal festa: Dia do Maracatu, IDH: 0,754";
                    break;
                case "porto alegre":
                    infoCidade = "População: 1.332.570, principal festa: Pagode do Pirika: paixão antiga, IDH: 0,805";
                    break;
                case "arroio do sal":
                    infoCidade = "População: 11.057, principal festa: Festa do Pescador, IDH: 0,740";
                    break;
                default:
                    System.out.println("Essa cidade não existe no nosso banco de dados");
            }
            System.out.println(infoCidade);
        } else {
            System.out.println("Valor inválido!");
        }

        entrada.close();
    }
}
