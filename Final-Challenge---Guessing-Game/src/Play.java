import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Play {
    static Scanner scan = new Scanner(System.in);
    static Random randomize = new Random();
    
    static int mode;
    static int difficulty;
    static int score;
    final static int BOTTOM_LIM = 1;
    static int upperLim;
    static int remAttempts;
    static ArrayList<Integer> ans = new ArrayList<>();
    static boolean[] hit = new boolean[3]; // Maximun length for ans
    static int hitCount = 0;

    public static void cleanStates(){
        ans.clear();
        for(int i=0; i<hit.length; i++)
            hit[i] = false;
        hitCount = 0;
    }

    public static void newGame(){
        cleanStates();

        System.out.println("\n\n\n=== Escolha o modo ===\n");

        System.out.println("1. Simples (1 número sorteado)");
        System.out.println("2. Sequência (3 números sorteados)");

        System.out.print("\nSelecione uma opção .......: ");

        mode = scan.nextInt();
        while(mode < 1 || mode > 2){
            System.out.println("\nOpção inválida!");
            System.out.print("Selecione uma opção .......: ");
            mode = scan.nextInt();
        }
        mode--;

        System.out.println("\n\n--- Escolha a dificuldade ---\n");
        
        if(mode == 0){
            System.out.println("1. " + Stats.difficulties[0]);
            System.out.println("2. " + Stats.difficulties[1]);
            System.out.println("3. " + Stats.difficulties[2]);
        }else{
            System.out.println("1. " + Stats.difficulties[3]);
            System.out.println("2. " + Stats.difficulties[4]);
        }
        
        System.out.print("\nSelecione uma opção .......: ");
        
        difficulty = scan.nextInt();
        while((mode == 0 && (difficulty < 1 || difficulty > 3)) || (mode == 1 && (difficulty < 1 || difficulty > 2))){
            System.out.println("\nOpção inválida!");
            System.out.print("Selecione uma opção .......: ");
            difficulty = scan.nextInt();
        }

        difficulty--;

        if(mode == 1) difficulty += 3;

        // Default start settings
        score = Stats.DIF_SETTINGS[difficulty][0];
        upperLim = Stats.DIF_SETTINGS[difficulty][1];
        remAttempts = Stats.DIF_SETTINGS[difficulty][2];
    }

    public static void playGame(){
        // Draw answer
        for(int i=0; i<Stats.QTT_DRAWN_MODE[mode]; i++){
            ans.add(randomize.nextInt((upperLim - BOTTOM_LIM) + 1) + BOTTOM_LIM);
            for(int j=0; j<i; j++)
                if(ans.get(i) == ans.get(j)){
                    ans.remove(i);
                    i--;
                    break;
                }
        }
        String qttDrawnString = ans.size() == 3 ? "três números" : "um número"; 
        System.out.println("\n\n=== Advinhe " + qttDrawnString + " de " + BOTTOM_LIM + " a " + upperLim + " ===");
        System.out.println("--- Você pode pedir dicas (pagando penalidade em pontos) a qualquer momento, digitando -1, -2 ou -3 ---\n");

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
                case 0:{ // Got a number
                    int index = 0; // Which of the numbers has been gotten
                    for(int i=0; i<ans.size(); i++){
                        if(ans.get(i) == guess){
                            index = i;
                            break;
                        }
                    }

                    if(!hit[index] && hitCount != ans.size() - 1){
                        String ordinalIndex = (index+1) + "º ";
                        System.out.println("\n\n= Parabéns! Você acertou o " + (ans.size() >= 2 ? ordinalIndex : "") + "número sorteado! =\n");
                        remAttempts--;
                        hit[index] = true;
                        hitCount++;
                    }else if(hitCount != ans.size() - 1){
                        System.out.println("\nVocê já acertou essa tentativa antes...");
                        System.out.println("Lembre-se: os números sorteados são distintos entre si!");
                    }else{
                        System.out.println("\n\n\n=== Parabéns! Você acertou o(s) número(s) sorteado(s)! ===\n");
                        remAttempts--;
                        win = true;
                        hit[index] = true;
                        hitCount++;
                        handleEnd(true);
                    }

                    break;
                }
                case 1:{ // guess != ans
                    for(int i=0; i<ans.size(); i++){
                        String ineqSignal = (guess < ans.get(i)) ? "maior" : "menor";
                        String ordinalIndex = (i+1) + "º ";
                        String out = "O " + (ans.size() >= 2 ? ordinalIndex : "") + "número sorteado é " + ineqSignal + " que isso...";
                        System.out.println(out);
                    }
                    remAttempts--;
                    break;
                }
                case 2:{ // remAttempts == 0
                    System.out.println("\n\n\n= Game Over! Acabaram suas tentativas! =\n");
                    remAttempts--;
                    handleEnd(false);
                    break;
                }
                case 3:{
                    score += Tips.showTip(guess);
                    break;
                }
            }
        }
    }

    public static int handleGuess(int guess){
        if(guess >= -3 && guess <= -1) return 3; // Tip
        if(guess < BOTTOM_LIM || guess > upperLim || guess == 0) return -1; // Out of bounds
        for(int i=0; i<ans.size(); i++)
            if(guess == ans.get(i))
                return 0; // Got a number

        if(remAttempts <= 1) return 2; // No remaining attempts
        // This case (return 3) is after win and OoB, but before 
        // less / more cases because you can always win or try again 
        // in those past cases, but not in the following
        
        // No number matched to guess in the dedicated previous stage 
        return 1;
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
