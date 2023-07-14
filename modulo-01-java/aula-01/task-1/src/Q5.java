import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {

        // (b * h) / 2

        Scanner entrada = new Scanner(System.in);

        System.out.print("Altura: ");
        int h = 0;

        while(h <= 0) {
            h = entrada.nextInt();
        }

        System.out.print("base: ");
        int b = 0;
        while (b <= 0) {
            b = entrada.nextInt();
        }

        System.out.println((b * h) / 2);

        entrada.close();
    }
}
