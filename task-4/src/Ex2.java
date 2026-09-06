import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println();

        String name;
        char sex;
        String maritalStatus;
        int mariageTime = -1;

        System.out.print("Insira seu nome: ");
        name = scan.nextLine();
        System.out.print("Insira seu sexo (M/F): ");
        sex = scan.nextLine().charAt(0);
        System.out.println("Insira seu estado civil: ");
        maritalStatus = scan.nextLine();

        if(sex == 'F' && maritalStatus.toUpperCase().equals("CASADA")){
            System.out.print("Insira seu tempo de casada (anos): ");
            mariageTime = scan.nextInt();
        }

        System.out.println();
        System.out.println("--- Dados coletados ---\n");
        System.out.println("Nome: " + name);
        System.out.println("Sexo: " + sex);
        System.out.println("Estado civil: " + maritalStatus.toUpperCase());
        if(mariageTime != -1)
            System.out.println("Tempo de casada: " + mariageTime);
        else
            System.out.println("Sem tempo de casada");

        System.out.println();
        scan.close();
    }
}
