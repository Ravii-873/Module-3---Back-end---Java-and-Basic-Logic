import java.util.Random;
import java.util.Scanner;

public class Play {
    static Scanner scan = new Scanner(System.in);
    static Random randomize = new Random();
    
    static int difficulty;
    static int score;
    final static int BOTTOM_LIM = 1;
    static int upperLim;
    static int remAttempts;

    public static void newGame(){
        System.out.println("\n\n\n--- Escolha a dificuldade ---\n");
        
        System.out.println("1. Fácil");
        System.out.println("2. Médio");
        System.out.println("3. Difícil");

        System.out.print("\nSelecione uma opção .......: ");

        difficulty = scan.nextInt();
        difficulty--;

        // Default start settings
        score = Stats.DIF_SETTINGS[difficulty][0];
        upperLim = Stats.DIF_SETTINGS[difficulty][1];
        remAttempts = Stats.DIF_SETTINGS[difficulty][2];
    }

    static int ans;

    public static void play(){
        ans = randomize.nextInt((upperLim - BOTTOM_LIM) + 1) + BOTTOM_LIM;
        System.out.println("\n\n=== Advinhe um número de " + BOTTOM_LIM + " a " + upperLim + " ===");
        System.out.println("--- Você pode pedir dicas (penalidade em pontos) a qualquer momento, digitando -1, -2 ou -3 ---\n");

        boolean win = false;
        while(remAttempts > 0 && !win){
            System.out.println("\nTentativas restantes: " + remAttempts);
            System.out.print("Seu chute .............: ");

            int guess = scan.nextInt();
            System.out.println();

            switch (handleGuess(guess)) {
                case -1:{ // Out of bounds
                    System.out.println("\nTentativa inválida! O chute está fora do intervalo.");
                    System.out.println("Tente novamente.");
                    break;
                }
                case 0:{ // Win
                    System.out.println("\n\n\n=== Parabéns! Você acertou o número sorteado! ===\n");
                    remAttempts--;
                    win = true;
                    handleEnd(true);
                    break;
                }
                case 1:{ // guess < ans
                    System.out.println("A resposta é maior que isso...");
                    remAttempts--;
                    break;
                }
                case 2:{ // guess > ans
                    System.out.println("A resposta é menor que isso...");
                    remAttempts--;
                    break;
                }
                case 3:{ // remAttempts == 0
                    System.out.println("\n\n\n= Game Over! Acabaram suas tentativas! =\n");
                    remAttempts--;
                    handleEnd(false);
                    break;
                }
                case 4:{
                    score += Tips.showTip(guess);
                    break;
                }
                default:{ // Error
                    System.out.println("\nErro ao processar seu chute :(\n");
                    Main.quit(Main.scan, Stats.scan, scan, 2);
                    break;
                }
            }
        }
    }

    public static int handleGuess(int guess){
        if(guess >= -3 && guess <= -1) return 4; // Tip
        if(guess < BOTTOM_LIM || guess > upperLim || guess == 0) return -1; // Out of bounds
        if(guess == ans) return 0; // Win
        if(remAttempts <= 1) return 3; // No remaining attempts
        // This case is after win and OoB, but before less / more cases
        // because you can always win or try again in those past cases,
        // but not in the following
        if(guess < ans) return 1;
        if(guess > ans) return 2;

        return -2; // Error
    }

    public static void handleEnd(boolean didWin){
        final int MAX_ATT = Stats.DIF_SETTINGS[difficulty][2];

        score += remAttempts * Stats.FAST_CONC_BONUS;
        score += (MAX_ATT-remAttempts) * Stats.PER_TRY_PENALTY;

        System.out.println("- Estatísticas da partida -\n");
        System.out.print("Dificuldade: " + Stats.difficulties[difficulty] + "\n");
        System.out.println("Pontuação final: " + score);
        System.out.println("Tentativas usadas: " + (MAX_ATT-remAttempts) + "/" + MAX_ATT);
        System.out.print("Status: " + (didWin ? "Vitória" : "Derrota"));
        System.out.println("\n\n");

        Stats.saveStats(difficulty, score, didWin);
    }
}
