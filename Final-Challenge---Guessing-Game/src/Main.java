import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        Stats.initializeScoreRecords();
        // While does not quit
        while(true){
            boolean startNewGame = false;
            // Handle menu
            switch(Stats.handleMenu()){
                case 1:
                    startNewGame = true;
                    break;
                case 2:
                    Stats.showRules();
                    break;
                case 3:
                    Stats.showScoreHistory();
                    break;
                case 4:
                    quit(scan, Stats.scan, Play.scan, 0);
                    break;
                default:
                    quit(scan, Stats.scan, Play.scan, 1);
            }
            if(!startNewGame) continue;

            Play.newGame();
            Play.play();
        }
    }

    public static void quit(Scanner mainScan, Scanner gameScan, Scanner playScan, int status){
        System.out.println("\n\nObrigado por jogar!\n");

        mainScan.close();
        gameScan.close();
        playScan.close();
        System.exit(status);
    }
}
