import java.util.Scanner;
import java.util.Locale;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nOlá! Informe seu salário (R$): ");
        double salary = scan.nextDouble();

        System.out.printf(Locale.of("pt", "BR"), "Salário: R$ %.2f\n", salary);

        System.out.println();
        scan.close();
    }
}
