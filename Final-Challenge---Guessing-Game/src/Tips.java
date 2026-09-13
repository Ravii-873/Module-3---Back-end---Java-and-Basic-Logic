import java.util.Scanner;

public class Tips {
    static Scanner scan = new Scanner(System.in);

    public static int showTip(int guess){
        System.out.print("\nDica:\n");
        switch(guess){
            case -1:{ // Parity
                for(int i=0; i<Play.ans.size(); i++){
                    String ordinalIndex = (i+1) + "º ";
                    System.out.println("O " + (Play.ans.size() >= 2 ? ordinalIndex : "") + 
                                        "valor sorteado é " + (Play.ans.get(i) % 2 == 0 ? "par." : "ímpar."));
                }
                return Stats.TIP_PARITY_PENALTY * Play.ans.size();
            }
            case -2:{ // Interval
                for(int i=0; i<Play.ans.size(); i++){
                    String ordinalIndex = (i+1) + "º ";
                    System.out.println("O " + (Play.ans.size() >= 2 ? ordinalIndex : "") + "valor sorteado está no intervalo " + 
                                    (Play.ans.get(i) > (Play.upperLim - Play.BOTTOM_LIM + 1) / 2 ? "superior." : "inferior."));
                }
                return Stats.TIP_INTERVAL_PENALTY * Play.ans.size();
            }
            case -3:{ // Promimity
                if(guess < 1){
                    System.out.println("A tentativa anterior não é válida para comparação!");
                    return 0;
                }

                int[] dist = new int[Play.ans.size()];
                double[] relativeDist = new double[Play.ans.size()];

                for(int i=0; i<Play.ans.size(); i++){
                    dist[i] = Math.abs(guess - Play.ans.get(i));
                    relativeDist[i] = dist[i] / (Play.upperLim - Play.BOTTOM_LIM + 1);
                }

                System.out.println("Sua tentativa está, em relação ao");
                for(int i=0; i<Play.ans.size(); i++){
                    String ordinalIndex = (i+1) + "º ";
                    System.out.print((Play.ans.size() >= 2 ? ordinalIndex : "") + "valor sorteado: ");
                    if (relativeDist[i] <= 0.05)
                        System.out.println("quente.");
                    else if (relativeDist[i] <= 0.15)
                        System.out.println("morna.");
                    else 
                        System.out.println("fria.");
                }

                return Stats.TIP_PROXIMITY_PENALTY * Play.ans.size();
            }
            default:{
                System.out.println("Erro ao calcular dica!");
                return 0;
            }
        }
    }
}