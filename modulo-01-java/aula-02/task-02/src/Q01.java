import java.util.Scanner;

public class Q01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Nome Produto: ");
        String nomeProduto = entrada.nextLine();

        System.out.print("Valor produto: ");
        float valor = entrada.nextInt();

        for (int i = 1; i < 11; i++) {
            float valorComDesconto = valor - (valor * ((5 * i) / 100f));
            System.out.printf("%d x R$ %5.2f = %5.2f\n", i, valorComDesconto, (valorComDesconto * i));
        }

        entrada.close();
    }
}
