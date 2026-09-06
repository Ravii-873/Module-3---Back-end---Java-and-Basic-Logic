import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nInsira número inteiro: ");
        int n = scan.nextInt();
        System.out.println();
        
        if(n%2 == 0)
            n += 5;
        else
            n += 8;
            
            
        System.out.println("n = " + n);
        System.out.println();
        scan.close();
    }
}
