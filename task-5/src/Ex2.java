import java.util.Random;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        final int ans = random.nextInt(100);

        System.out.print("\nAdvinhe um número inteiro de 0 a 100: ");
        int guess = scan.nextInt();

        while(guess != ans){
            if(ans < guess)
                System.out.print("MAIOR. ");
            else
                System.out.print("MENOR. ");

            System.out.print("Tente novemente: ");
            guess = scan.nextInt();
        }

        System.out.println("\nVocê acertou! O valor era igual a " + ans + ".\n");

        scan.close();
    }
}
