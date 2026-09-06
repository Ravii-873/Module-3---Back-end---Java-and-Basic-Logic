import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n---Insira a idade de 5 pessoas ---\n");

        int[] ages = new int[5];
        int count18Plus = 0;
        for(int i=0; i<ages.length; i++){
            do {
                System.out.print("Idade da pessoa " + (i+1) + ": ");
                ages[i] = scan.nextInt();

                if(ages[i] < 0 || ages[i] > 130)
                    System.out.println("\nIdade inválida! Tente novamente.");
            } while (ages[i] < 0 || ages[i] > 130);

            System.out.println();

            // > 18, not >= 18
            if(ages[i] > 18)
                count18Plus++;
        }

        System.out.println("\nTotal de pessoas que têm idade maior que 18 anos: " + count18Plus);

        System.out.println();
        scan.close();
    }
}
