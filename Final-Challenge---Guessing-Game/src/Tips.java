import java.util.Scanner;

public class Tips {
    static Scanner scan = new Scanner(System.in);

    public static int showTip(int guess){
        System.out.print("\nDica: ");
        switch(guess){
            case -1:{ // Parity
                System.out.println("O valor sorteado é " + (Play.ans % 2 == 0 ? "par." : "ímpar."));
                return Stats.TIP_PARITY_PENALTY;
            }
            case -2:{ // Interval
                System.out.println("O valor sorteado está no intervalo " + 
                                    (Play.ans > (Play.upperLim - Play.BOTTOM_LIM + 1) / 2 ? "superior." : "inferior."));
                return Stats.TIP_INTERVAL_PENALTY;
            }
            case -3:{ // Promimity
                final int dist = Math.abs(guess - Play.ans); 
                final double relativeDist = dist / (Play.upperLim - Play.BOTTOM_LIM + 1);

                System.out.print("Sua tentativa está ");
                if (relativeDist <= 0.05)
                    System.out.println("quente.");
                else if (relativeDist <= 0.15)
                    System.out.println("morna.");
                else 
                    System.out.println("fria.");

                return Stats.TIP_PROXIMITY_PENALTY;
            }
            default:{
                System.out.println("Erro ao calcular dica!");
                return 0;
            }
        }
    }
}