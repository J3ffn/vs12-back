import java.util.Scanner;

public class Q7 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Código: ");
        String codigo = entrada.next();

        float valorProduto = 0;

        boolean valido = true;

        switch (codigo) {
            case "ABCD":
                valorProduto = 5.30f;
                break;
            case "XYPK":
                valorProduto = 6;
                break;
            case "KLMP":
                valorProduto = 3.20f;
                break;
            case "QRST":
                valorProduto = 2.50f;
                break;
            default:
                valido = false;
                System.out.println("Código inválido");
        }

        if (valido) {
            System.out.print("Quantidade: ");
            int quantidade = entrada.nextInt();

            float valor = valorProduto * quantidade;

            System.out.printf("%5.2f", valor);
        } else {
            System.out.println("inválido");
        }

        entrada.close();
    }
}
