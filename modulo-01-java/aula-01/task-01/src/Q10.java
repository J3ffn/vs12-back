import java.util.Scanner;

public class Q10 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("ID: ");
        int id = entrada.nextInt();

        System.out.print("Nota1: ");
        float nota1 = entrada.nextFloat();

        System.out.print("Nota2: ");
        float nota2 = entrada.nextFloat();

        System.out.print("Nota3: ");
        float nota3 = entrada.nextFloat();

        System.out.print("Média exercícios: ");
        float media = entrada.nextFloat();

        float MA = (nota1 + nota2 * 2 + nota3 * 3 + media) / 7f;

        String situacao = "";

        char conceito = '-';
        if (MA >= 9) {
            conceito = 'A';
        } else if (MA >= 7.5) {
            conceito = 'B';
        } else if (MA >= 6) {
            conceito = 'C';
        } else if (MA >= 4) {
            conceito = 'D';
        } else  {
            conceito = 'F';
        }

        if (MA >= 6) {
            situacao = "APROVADO";
        } else {
            situacao = "REPROVADO";
        }

        System.out.printf(
                "ID: %d, " +
                "1º nota: %5.2f, " +
                "2º nota: %5.2f, " +
                "3º nota: %5.2f, " +
                "média exercícios: %5.2f, " +
                "MA: %5.2f, " +
                "conceito: %s, " +
                "Situação: %s",
                id, nota1, nota2, nota3, media, MA, conceito, situacao
        );

        entrada.close();
    }
}
