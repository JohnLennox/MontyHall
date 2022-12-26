public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        int numberOfGames = 100000000;
        int stickWinCount = 0;
        int swapWinCount = 0;

        for (int i = 0; i < numberOfGames; i++) {
            if (game.playGame(true)) {
                stickWinCount++;
            }
            if (game.playGame(false)) {
                swapWinCount++;
            }
        }

        System.out.println("Swap win %: " + (((double)swapWinCount / numberOfGames) * 100));
        System.out.println("Stick win %: " + (((double)stickWinCount / numberOfGames) * 100));
    }
}
