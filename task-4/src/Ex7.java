import java.util.Scanner;
import java.util.Arrays;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nInsira três valores inteiros diferentes: ");
        int[] arr = new int[3];
        for(int i=0; i<arr.length; ++i)
            arr[i] = scan.nextInt();

        Arrays.sort(arr);

        System.out.println("\nValores em ordem decrescente: ");
        for(int i = arr.length-1; i >= 0; --i)
            System.out.print(arr[i] + " ");

        System.out.println("\n");
        scan.close();
    }
}
