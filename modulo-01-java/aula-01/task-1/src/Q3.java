import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Java 17

        System.out.print("Digite uma palavra em inglês ou em português: ");
        switch (entrada.nextLine().toLowerCase()) {
            case "dog" -> System.out.println("Cachorro");
            case "time" -> System.out.println("Tempo");
            case "love" -> System.out.println("Amor");
            case "city" -> System.out.println("Cidade");
            case "happy" -> System.out.println("Feliz");
            case "sad" -> System.out.println("Triste");
            case "should" -> System.out.println("Deveria");
            case "could" -> System.out.println("Poderia");

            case "cachorro" -> System.out.println("Dog");
            case "tempo" -> System.out.println("Time");
            case "amor" -> System.out.println("Love");
            case "cidade" -> System.out.println("City");
            case "feliz" -> System.out.println("Happy");
            case "triste" -> System.out.println("Sad");
            case "deveria" -> System.out.println("Should");
            case "poderia" -> System.out.println("Could");
            default -> System.out.println("Essa palavra não é válida.");
        }

        // Demais JDKs

        switch (entrada.nextLine().toLowerCase()) {
            case "dog":
                System.out.println("Cachorro");
                break;
            case "time":
                System.out.println("Tempo");
                break;
            case "love":
                System.out.println("Amor");
                break;
            case "city":
                System.out.println("Cidade");
                break;
            case "happy":
                System.out.println("Feliz");
                break;
            case "sad":
                System.out.println("Triste");
                break;
            case "should":
                System.out.println("Deveria");
                break;
            case "could":
                System.out.println("Poderia");
                break;

            case "cachorro":
                System.out.println("Dog");
                break;
            case "tempo":
                System.out.println("Time");
                break;
            case "amor":
                System.out.println("Love");
                break;
            case "cidade":
                System.out.println("City");
                break;
            case "feliz":
                System.out.println("Happy");
                break;
            case "triste":
                System.out.println("Sad");
                break;
            case "deveria":
                System.out.println("Should");
                break;
            case "poderia":
                System.out.println("Could");
                break;
            default:
                System.out.println("Essa palavra não é válida.");
        }

        entrada.close();
    }
}
