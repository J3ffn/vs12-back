package ex2;

public class Main {
    public static void main(String[] args) {

        int[][] valores = new int[2][2];
        
        int soma = 0;
        int somaLinha1 = 0;
        int somaLinha2 = valores[1][0] + valores[1][1];
        int subtracao = 0;
        
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores[i].length; j++) {
                valores[i][j] = i * j;
                soma += valores[i][j];
            }
        }

        for (int i = 0; i < valores[0].length; i++) {
            somaLinha1 += valores[0][i];
        }

        for (int i = 0; i < valores[1].length; i++) {
            somaLinha2 += valores[1][i];
        }

        subtracao = somaLinha1 - somaLinha2;

        System.out.println(subtracao);
    }

}
