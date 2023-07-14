import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Primeiro nome: ");
        String nome = entrada.next();

        // Coletar o enter.
        entrada.nextLine();

        System.out.print("Cidade: ");
        String cidade = entrada.nextLine();
        System.out.print("Idade: ");
        int idade = entrada.nextInt();

        System.out.print("Estado: ");
        String estado = entrada.next();

        System.out.printf("Olá seu nome é %s, " +
            "você tem %d anos, é da cidade de %s, situada no estado de %s.", nome, idade, cidade, estado);

        entrada.close();
    }
}
