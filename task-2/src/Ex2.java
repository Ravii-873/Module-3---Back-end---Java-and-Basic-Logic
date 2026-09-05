import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nInsira números reais x e y:");
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        System.out.println("\nInsira número inteiro a:");
        int a = scan.nextInt();

        System.out.printf("(%.2f + %.2f) * %d = %.2f\n", x, y, a, ((x+y)*a));

        double pow = Math.pow(x, y); 
        System.out.printf("%.2f ^ %.2f / %d = %.2f / %d = %.2f\n", x, y, a, pow, a, (pow/a));

        System.out.println();
        scan.close();
    }
}
