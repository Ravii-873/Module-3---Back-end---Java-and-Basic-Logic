import java.util.Scanner;

public class Stats {
    static Scanner scan = new Scanner(System.in);

    // [][0] - base score
    // [][1] - number max limit
    // [][2] - max attempts
    static final int[][] DIF_SETTINGS = { {100, 50, 10},
                                        {200, 100, 7},
                                        {300, 200, 5} };

    // [][0] - score
    // [][1] - difficulty
    // [][2] - status (W/L)
    static int[][] scoreHistory = new int[10][3];
    static int scoreHistorySize = 0;
    static final int PER_TRY_PENALTY = -10;
    static final int FAST_CONC_BONUS = 50;

    public static void saveStats(int difficulty, int score, boolean status){
        rightShiftScHist();
        scoreHistory[0][0] = score;
        scoreHistory[0][1] = difficulty;
        scoreHistory[0][2] = status ? 1 : 0;
    }

    public static void rightShiftScHist(){
        for(int i = scoreHistorySize-1; i >= 1; i--){
            scoreHistory[i][0] = scoreHistory[i-1][0];
            scoreHistory[i][1] = scoreHistory[i-1][1];
        }
        if(scoreHistorySize < 10) scoreHistorySize++;
    }

    public static int handleMenu(){
        System.out.println("\n==== Menu ====\n");

        System.out.println("1. Iniciar novo jogo");
        System.out.println("2. Ver regras");
        System.out.println("3. Ver histórico de pontuações");
        System.out.println("4. Sair");

        System.out.print("\nSelecione uma opção .......: ");
        int input = scan.nextInt();

        return input;
    }


    public static void showRules(){
        System.out.println("\n\n--- Regras ---\n");

        System.out.println("- Objetivo:\n" +
                            "Advinhar um número aleatório num intervalo,\n" + 
                            "sem exceder o limite de tentativas");

        System.out.println("\n-- Sistema de Dificuldade --\n");

        System.out.println("Fácil:\n" + 
                            "Adivinhar um número entre: 1 e 50;\n" +
                            "Tentativas: 10;\n" +
                            "Pontuação base: 100.\n");

        System.out.println("Médio:\n" + 
                            "Advinhar um número entre: 1 e 100;\n" +
                            "Tentativas: 7;\n" + 
                            "Pontuação base: 200.\n");

        System.out.println("Difícil:\n" + 
                            "Advinhar um número entre: 1 e 200;\n" +
                            "Tentativas: 5;\n" + 
                            "Pontuação base: 300.\n");

        System.out.println("\n-- Pontuações --\n");

        System.out.println("A cada tentativa usada, são\n" + 
                            "descontados 10 pontos;\n");
                        
        System.out.println("Bônus por conclusão rápida: +50 pontos\n" +
                            "para cada tentativa não utilizada.");

        System.out.println("\n");
    }


    public static void showScoreHistory(){
        System.out.println("\n");

        if(scoreHistorySize <= 0){
            System.out.println("Ainda não há partidas registradas!");
            System.out.println("Que tal jogar uma?\n");
            return;
        }

        System.out.println("\n=== Histórico de Partidas (" + scoreHistorySize + 
                            " última" + (scoreHistorySize >= 2 ? "s" : "")  + ") ===\n");

        for(int i=0; i<scoreHistorySize; i++){
            System.out.println("-- Partida " + ((char)(i+65)) + " --");
            System.out.print("Dificuldade: ");
            showDifficulty(scoreHistory[i][1]);
            System.out.println("Pontuação obtida: " + scoreHistory[i][0]);
            System.out.println("Status: " + (scoreHistory[i][2]==1 ? "Vitória" : "Derrota"));
            System.out.println();
        }
    }

    public static void showDifficulty(int difficulty){
        switch(difficulty){
            case 0:
                System.out.println("Fácil");
                break;
            case 1:
                System.out.println("Médio");
                break;
            case 2:
                System.out.println("Difícil");
                break;
            default:
                System.out.println("Inválida - erro no armazenamento da dificuldade");
                break;
        }
    }
}
