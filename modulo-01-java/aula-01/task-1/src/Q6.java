import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        float totalEleitores, brancos, nulos, validos;

        System.out.print("Total de eleitores: ");
        totalEleitores = entrada.nextFloat();

        System.out.print("Votos em branco: ");
        brancos = entrada.nextFloat();

        System.out.print("Votos nulos: ");
        nulos = entrada.nextFloat();

        System.out.print("Votos válidos: ");
        validos = entrada.nextFloat();

        brancos = (brancos / totalEleitores) * 100;
        nulos = (nulos / totalEleitores) * 100;
        validos = (validos / totalEleitores) * 100;

        System.out.printf("Total de eleitores: %5.0f, " +
                "porcentágem branco: %5.2f%%, " +
                "votos nulos: %5.2f%%, " +
                "votos válidos: %5.2f%%", totalEleitores, brancos, nulos, validos);

    }

}
