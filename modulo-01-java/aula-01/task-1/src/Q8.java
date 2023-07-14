import java.util.Scanner;

public class Q8 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Cargo: ");
        String cargo = entrada.next().toLowerCase();
        System.out.print("Salário: ");
        float salario = entrada.nextFloat();

        float porcentagem = 0;

        switch (cargo) {
            case "gerente":
                porcentagem = 10;
                break;
            case "engenheiro":
                porcentagem = 20;
                break;
            case "tecnico":
                porcentagem = 30;
                break;
            default:
                porcentagem = 40;
        }

        float salarioNovo = (salario + ((porcentagem / 100) * salario));

        System.out.println("salario antigo: " + salario + ", novo salário: " + salarioNovo);

        entrada.close();
    }
}
