package ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Tamanho do vetor: ");
        int[] vetor = new int[entrada.nextInt()];
        int media = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Entrada [" + i + "]: ");
            vetor[i] = entrada.nextInt();
            media += vetor[i];
        }

        media /= vetor.length;

        System.out.println(media);
    }
}
