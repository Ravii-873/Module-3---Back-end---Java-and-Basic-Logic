import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nOlá! Por favor, insira seu nome:");
        String name = scan.nextLine();
        System.out.println("\nAgora, informe sua idade:");
        int age = scan.nextInt();

        System.out.println("\nNome: " + name);
        System.out.println("Idade: " + age);

        System.out.println();
        scan.close();
    }
}
