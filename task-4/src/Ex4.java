import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nInsira inteiros a e b: ");
        int a = scan.nextInt();
        int b = scan.nextInt();

        int c = a + b;
        if(a != b)
            c = a * b;
        
        System.out.println("\nc = " + c);

        System.out.println();
        scan.close();
    }
}
