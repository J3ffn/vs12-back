public class Q4 {

    public static void main(String[] args) {

        int vA = 10, vB = 20;

        int aux = vA;
        // A <-> B
        vA = vB;
        vB = aux;

        // A <-> B
        vB = vA;
        vA = aux;

        System.out.printf("Variável A: %d. Variável B: %d", vA, vB);

    }
}
