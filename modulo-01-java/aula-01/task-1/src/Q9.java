import java.util.Scanner;

public class Q9 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int horaInicio, minutosInicio;

        horaInicio = entrada.nextInt();
        minutosInicio = entrada.nextInt();

        int horaTermino, minutosTermino;

        horaTermino = entrada.nextInt();
        minutosTermino = entrada.nextInt();

        if (horaTermino == horaInicio && minutosTermino == minutosInicio) {
            System.out.println("Tempo limite de jogatina atingido");
        }

        int calculoHoras = horaTermino - horaInicio;
        if (calculoHoras < 0) {
            calculoHoras = 24 - (calculoHoras * -1);
        }

        int calculoMinutos = minutosInicio - minutosTermino;
        if (calculoMinutos < 0) {
            calculoMinutos = calculoMinutos * -1;
        }

        System.out.println("Tempo de jogatina: " + calculoHoras + ":" + calculoMinutos + "h");
        entrada.close();
    }
}
