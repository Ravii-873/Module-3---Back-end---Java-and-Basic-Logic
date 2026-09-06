import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nInsira inteiro: ");
        int n = scan.nextInt();

        System.out.println("\nPares de 0 a " + n + ": ");
        for(int i=0; i<=n; i++){
            if(i % 2 == 0)
                System.out.println(i);
        }

        System.out.println();
        scan.close();
    }
}
