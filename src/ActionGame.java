import java.util.Scanner;

public class ActionGame {
    private final int WINNING_GOLD;
    private Scanner scan;
    private Player p1;
    private Player p2;
    private Player currentPlayer;

    public ActionGame() {
        WINNING_GOLD = 100;
        scan = new Scanner(System.in);

        // to be initialized in play()
        p1 = null;
        p2 = null;
        currentPlayer = null;
    }

    public void play() {
        System.out.print("Enter player 1 name: ");
        String p1Name = scan.nextLine();
        System.out.print("Enter player 2 name: ");
        String p2Name = scan.nextLine();
        p1 = new Player(p1Name);
        p2 = new Player(p2Name);
        currentPlayer = p1;
        while (!isGameOver()) {
            playRound();
            swapPlayer();
        }
        endGame();
    }

    private void playRound() {
        System.out.println("---------------------");
        System.out.println(currentPlayer.getName() + "'s turn! Current gold: " + currentPlayer.getGold() + "  Current sword strength: " + currentPlayer.getSword().getStrength());
        System.out.println("---------------------");
        Enemy enemy = new Enemy(getEnemyName());
        System.out.println("A " + enemy.getName() + " appears!");
        while (!enemy.isDead()) {
            System.out.println(enemy.getName() + "'s health: " + enemy.getHealth());
            System.out.print("--> press enter to attack");
            scan.nextLine();
            int playerAttack = currentPlayer.attack(enemy);
            System.out.println(currentPlayer.getName() + " attacks for " + playerAttack);
        }
        System.out.println(currentPlayer.getName() + " has slain the " + enemy.getName());
        int gold = enemy.dropGold();
        System.out.println("It left behind " + gold + " gold");
        currentPlayer.addGold(gold);
        System.out.println(currentPlayer.getName() + " collects it and now has " + currentPlayer.getGold() + " gold");
    }

    private boolean isGameOver() {
        if (p1.getGold() >= WINNING_GOLD || p2.getGold() >= WINNING_GOLD) {
            return true;
        } else {
            return false;
        }
    }

    private void swapPlayer() {
        if (currentPlayer == p1) {
            currentPlayer = p2;
        } else {
            currentPlayer = p1;
        }
    }

    private String getEnemyName() {
        String[] enemies = {"Goblin", "Monster", "Dragon", "Vampire", "Giraffe"};
        int randomIdx = (int) (Math.random() * enemies.length);
        return enemies[randomIdx];
    }

    private void endGame() {
        System.out.println("---------------------");
        System.out.println("Final gold:");
        System.out.println(p1.getName() + ": " + p1.getGold());
        System.out.println(p2.getName() + ": " + p2.getGold());
        if (p1.getGold() >= WINNING_GOLD) {
            System.out.println(p1.getName() + " wins!");
        }
        if (p2.getGold() >= WINNING_GOLD) {
            System.out.println(p2.getName() + " wins!");
        }
    }
}
