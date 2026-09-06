import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nInsira número real: ");
        double n = scan.nextDouble();

        System.out.print("\nO número é ");
        if(n > 0)
            System.out.println("positivo -> " + (2 * n));
        else if(n < 0)
            System.out.println("negativo -> " + (3 * n));
        else
            System.out.println("igual a 0");


        System.out.println();
        scan.close();
    }
}
