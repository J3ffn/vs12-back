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
        
        int calculoHoras = horaTermino - horaInicio;
        if (calculoHoras <= 0) {
            calculoHoras = 24 - (calculoHoras * -1);
        }

        int calculoMinutos = minutosInicio - minutosTermino;
        if (calculoMinutos < 0) {
            calculoMinutos *= -1;
        } else {
            --calculoHoras;
            calculoMinutos = 60 - calculoMinutos;
        }

        if (calculoHoras >= 24 && calculoMinutos >= 0) {
            System.out.println("Tempo limite de jogatina atingido");
        }

        System.out.println("Tempo de jogatina: " + calculoHoras + ":" + calculoMinutos + "h");
        entrada.close();
    }
}
