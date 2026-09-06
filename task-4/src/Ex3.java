import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nInsira valor inteiro: ");
        int value = scan.nextInt();

        System.out.print("\nO valor informado é ");
        if(value % 2 == 0)
            System.out.println("par.");
        else
            System.out.println("ímpar.");

        System.out.println();
        scan.close();
    }
}
