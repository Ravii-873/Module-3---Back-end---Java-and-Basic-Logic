import java.util.Scanner;

public class Stats {
    static Scanner scan = new Scanner(System.in);

    // "Fácil", "Médio" and "Difícil" are for simple mode, while 
    // "Avançado" and "Especialista" are for sequence mode
    static final String[] difficulties = {"Fácil", "Médio", "Difícil", "Avançado", "Especialista"};
    // [][0] - base score
    // [][1] - number max limit
    // [][2] - max attempts
    static final int[][] DIF_SETTINGS = {   {100, 50, 10},      // Easy
                                            {200, 100, 7},      // Medium
                                            {300, 200, 5},      // Hard
                                            {500, 200, 13},     // Advanced
                                            {700, 400, 18}   }; // Specialist

    // Quantity of drawn numbers
    static final int[] QTT_DRAWN_MODE = {1, 3};

    static final int PER_TRY_PENALTY = -10;
    static final int FAST_CONC_BONUS = 50;
    static final int TIP_PARITY_PENALTY = -10;
    static final int TIP_INTERVAL_PENALTY = -20;
    static final int TIP_PROXIMITY_PENALTY = -15;

    // [][0] - score
    // [][1] - difficulty
    // [][2] - status (W/L)
    static int[][] scoreHistory = new int[10][3];
    static int scoreHistorySize = 0;
    //   [] - difficulty
    // [][] - score, status
    static int[][] scoreRecords = new int[5][2];
    public static void initializeScoreRecords(){
        for(int i=0; i<scoreRecords.length; i++){
            scoreRecords[i][0] = Integer.MIN_VALUE;
            scoreRecords[i][1] = -1;
        }
    }

    public static void saveStats(int difficulty, int score, boolean status){
        rightShiftScHist();
        scoreHistory[0][0] = score;
        scoreHistory[0][1] = difficulty;
        scoreHistory[0][2] = status ? 1 : 0;

        if(scoreRecords[difficulty][0] < score){ // Beat record
            scoreRecords[difficulty][0] = score;
            scoreRecords[difficulty][1] = status ? 1 : 0;
        } else if(scoreRecords[difficulty][0] == score && status){ // Same score, but winning
            scoreRecords[difficulty][1] = 1;
        }

    }

    public static void rightShiftScHist(){
        if(scoreHistorySize < 10) scoreHistorySize++;
        for(int i = scoreHistorySize-1; i >= 1; i--){
            scoreHistory[i][0] = scoreHistory[i-1][0];
            scoreHistory[i][1] = scoreHistory[i-1][1];
            scoreHistory[i][2] = scoreHistory[i-1][2];
        }
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
        System.out.println("\n\n===== Regras =====\n");

        System.out.println("- Objetivo:\n" +
                            "    Advinhar um número aleatório num intervalo,\n" + 
                            "    sem exceder o limite de tentativas\n");

        System.out.println("\n-- Sistema de Dificuldade --\n");

        System.out.println("= Modo Simples =\n");

        System.out.println("    Fácil:\n" + 
                            "        Adivinhar um número entre: 1 e 50;\n" +
                            "        Tentativas: 10;\n" +
                            "        Pontuação base: 100.\n");

        System.out.println("    Médio:\n" + 
                            "        Advinhar um número entre: 1 e 100;\n" +
                            "        Tentativas: 7;\n" + 
                            "        Pontuação base: 200.\n");

        System.out.println("    Difícil:\n" + 
                            "        Advinhar um número entre: 1 e 200;\n" +
                            "        Tentativas: 5;\n" + 
                            "        Pontuação base: 300.\n");

        System.out.println("= Modo Sequência =\n");

        System.out.println("    Avançado:\n" + 
                            "        Advinhar três números entre: 1 e 200;\n" +
                            "        Tentativas: 13;\n" + 
                            "        Pontuação base: 500.\n");
        
        System.out.println("    Especialista:\n" + 
                            "        Advinhar três números entre: 1 e 400;\n" +
                            "        Tentativas: 18;\n" + 
                            "        Pontuação base: 700.\n");

        System.out.println("\n-- Pontuações --\n");

        System.out.println("    A cada tentativa usada, são\n" + 
                            "    descontados 10 pontos;\n");
                        
        System.out.println("    Bônus por conclusão rápida: +50 pontos\n" +
                            "    para cada tentativa não utilizada;\n");
            
        System.out.println("    Penalidade por uso de dicas (detalhado a seguir).\n");

        System.out.println("\n-- Sistema de Dicas --\n");

        System.out.println("    Você pode pedir uma dica a qualquer momento do jogo.");
        System.out.println("    Para isto, ao invés de tentar advinhar o valor sorteado, \n" +
                            "    digite um dos seguintes valores NEGATIVOS, \n" +
                            "    conforme o tipo desejado de dica: \n");

        System.out.println("    -1. Dica sobre a paridade do(s) valor(es) sorteado(s) (par/ímpar)");
        System.out.println("    -2. Dica sobre o(s) intervalo(s) do(s) valor(es) sorteado(s) (inferior/superior)");
        System.out.println("    -3. Dica sobre a proximidade do chute anterior ao(s) valor(es) sorteado(s) (quente/morno/frio)\n");

        System.out.println("\nDetalhamento:\n");

        System.out.println("    -2. Cita \"inferior\" caso o valor sorteado seja menor ou igual à mediana \n" + 
                            "    do intervalo disponível no nível. \"Superior\", caso contrário. \n" +
                            "    Exemplo: No modo difícil, onde o intervalo é [1, 200], \"inferior\" \n" +
                            "    indica que o valor é menor ou igual a 100.\n");
        System.out.println("    -3. Indica, de acordo com o tamanho relativo da distância entre chute e valor sorteado: \n" + 
                            "        \"Quente\", para distância equivalente a até 5% do intervalo disponível; \n" +
                            "        \"Morno\", para distância equivalente a até 15% do intervalo disponível; \n" +
                            "        \"Frio\", para distância equivalente a mais de 15% do intervalo disponível;\n");

        System.out.println("\n- Penalidade por dica -\n");
        System.out.println("    Cada dica usada desconta determinada quantidade de pontos " +
                            "de sua partida, de acordo com seu tipo:\n\n" +
                            "    -1. -10 pontos\n" +
                            "    -2. -20 pontos\n" +
                            "    -3. -15 pontos\n\n" +
                            "    Obs.: os descontos são relativos à quantidade de números sorteados.\n" +
                            "    Uma dica de tipo -1, quando aplicada no modo sequência (3 valores sorteados), \n" +
                            "    será penalizada em 30 pontos, o triplo de 10.");

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
            System.out.println("    -- Partida " + ((char)(i+65)) + " --");
            System.out.print("    Dificuldade: " + difficulties[scoreHistory[i][1]] + "\n");
            System.out.println("    Pontuação obtida: " + scoreHistory[i][0]);
            System.out.println("    Status: " + (scoreHistory[i][2] == 1 ? "Vitória" : "Derrota"));
            System.out.println();
        }

        System.out.println("\n=== Recordes de pontuação por nível de dificuldade ===\n");
        
        for(int i = 0; i < difficulties.length; i++){
            System.out.println((i > 0 ? "\n" : "") + difficulties[i] + ":");
            
            if(scoreRecords[i][0] != Integer.MIN_VALUE) {
                System.out.println("    Pontuação obtida: " + scoreRecords[i][0]);
                System.out.println("    Status: " + (scoreRecords[i][1] == 1 ? "Vitória" : "Derrota"));
            } else {
                System.out.println("    Não há partidas registradas nessa dificuldade.");
            }
        }
        System.out.println("\n\n");
    }
}
