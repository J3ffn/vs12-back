import java.util.Scanner;

public class Q05 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String[] nomeDosProdutos = {
                "Arroz branco",
                "Feijão tropeiro",
                "Farofa",
                "Carne moída",
                "Requeijão",
                "Nutella",
                "Bolacha Maria",
                "Pão de forma",
                "Torrada",
                "Geléia"
        };
        int[][] matriz = new int[3][10];
        int[] mediaMercado = new int[2];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Valor do(a) " +  nomeDosProdutos[j] + " no comércio " + (i + 1) + ": ");
                matriz[i][j] = entrada.nextInt();
            }
            System.out.println();
        }

        // 0 = qualMercado & 1 = médio de preço
        int[] mercadoMaisBarato = {0, 1000000};
        for (int i = 0; i < matriz.length; i++) {
            int mediaAux = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                mediaAux += matriz[i][j];
            }
            if (mediaAux < mercadoMaisBarato[1]) {
                mercadoMaisBarato[0] = i;
                mercadoMaisBarato[1] = mediaAux;
            }
        }

        System.out.println("O mercado mais barato é o: " + (mercadoMaisBarato[0] + 1) + "º, sua média de preço é: "  + mercadoMaisBarato[1]);

    }
}
