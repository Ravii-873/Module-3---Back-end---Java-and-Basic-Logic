import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nInsira inteiro de 1 a 10: ");
        int n = scan.nextInt();
        while(n < 1 || n > 10){
            System.out.println("\nNúmero fora do intervalo [1,10].");
            System.out.print("Tente novamente: ");
            n = scan.nextInt();
        }

        System.out.println("\n--- Tabuada do " + n + " ---\n");
        for(int i=0; i<=10; i++){
            System.out.print(n + " * " + i);
            if(i < 10) System.out.print(" ");
            System.out.println(" = " + (n*i));
        }

        System.out.println();
        scan.close();
    }
}
