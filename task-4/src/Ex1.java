import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nInsira valores inteiros a, b e c:");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        System.out.println();

        if(a+b<c)
            System.out.printf("%d + %d é menor que %d.\n", a, b, c);
        else
            System.out.printf("%d + %d não é menor que %d.\n", a, b, c);

        System.out.println();
        scan.close();
    }
}
