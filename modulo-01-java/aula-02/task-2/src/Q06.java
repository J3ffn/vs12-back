import java.util.Scanner;

public class Q06 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int[] numeros = {17, 94, 100, 99, 58, 45, 94, 32, 6, 8};

        int numeroEscolhido = entrada.nextInt();

        // 0 = qts vezes existe, 1 = qts menores, 2 = qts maiores.
        int[] infoNumero = {0, 0, 0};

        for (int numero : numeros) {
            if (numero > numeroEscolhido) {
                ++infoNumero[2];
            } else if (numero < numeroEscolhido) {
                ++infoNumero[1];
            } else {
                ++infoNumero[0];
            }
        }

        System.out.println("O número existe " + infoNumero[0] + " vezes no banco, possui " + infoNumero[1] + " menores e " + infoNumero[2] + " maiores que " + numeroEscolhido);

        entrada.close();
    }
}
