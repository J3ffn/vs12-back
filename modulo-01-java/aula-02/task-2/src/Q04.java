import java.util.Scanner;

public class Q04 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[][] matriz = new int[5][4];

        int matriculaComMaiorNota = 0;

        for (int i = 0; i < matriz[i].length; i++) {

            System.out.print("Matrícula: ");
            int matricula = entrada.nextInt();

            System.out.print("Média provas: ");
            int mediaProvas = entrada.nextInt();

            System.out.print("Média trabalhos: ");
            int mediaTrabalhos = entrada.nextInt();

            int notaFinal = (int) ((mediaProvas * 0.6) + (mediaTrabalhos * 0.4));
            matriz[0][i] = matricula;
            matriz[1][i] = mediaProvas;
            matriz[2][i] = mediaTrabalhos;
            matriz[3][i] = notaFinal;

            System.out.println();
        }

        matriculaComMaiorNota = matriz[3][0];
        for (int i = 1; i < matriz[i].length; i++) {
            if (matriculaComMaiorNota < matriz[3][i]) {
                matriculaComMaiorNota = matriz[0][i];
            }
        }

        System.out.print("Notas: ");
        for (int i = 0; i < matriz[i].length; i++) {
            System.out.print("[ " + matriz[3][i] + " ]");
        }

        System.out.println("\nMatrícula do aluno com maior nota final: " + matriculaComMaiorNota);

        entrada.close();
    }
}
