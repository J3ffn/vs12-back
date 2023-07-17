package ex1;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 6, 3, 2};
        int calculoSoma = 0;

        for (int numero: numeros) {
            calculoSoma += numero;
        }

        int calculoMedia = calculoSoma / numeros.length;

        System.out.println("Soma: " + calculoSoma + ", média: " + calculoMedia);
    }
}