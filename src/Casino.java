import java.util.Scanner;

public class Casino {
    private double cash;
    private Scanner scan;

    public Casino() {
        cash = 10000;
        scan = new Scanner(System.in);
    }

    public void gamble(){
        System.out.println("Welcome To The CASINO!");
        System.out.println("You Have $" + cash );
        System.out.println("Enter 1 For Slots, 2 For Higher Or Lower");
        String game = scan.nextLine();
        if (game.equals("1")) {
            Slots slots = new Slots();
            System.out.println("Going To Slot Machine");
            while (Rich()) {
                slotRound(slots);
            }
        } else if (game.equals("2")) {
            HighLow HighLow = new HighLow();
            System.out.println("Getting Dice");
            while (Rich()){
                HighlowRound(HighLow);
            }

        }
        System.out.println("Your Cash Ran Out!\nNow Get Out!");
    }

    public void slotRound(Slots slots){
        double bet;
        System.out.println("Enter bet amount");
        bet = scan.nextDouble();
        cash -= bet;
        int[][] grid = slots.getGrid();
        System.out.print("/---------\\\n|");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j] + "|");
            }
            if (i == 2){
                System.out.println("\n\\---------/");
            } else {
                System.out.print("\n|");
            }

        }

        System.out.println("The Score Is " + slots.getScore());
        bet = slots.checkBet() * bet;
        cash += bet;
        if (cash < 0) {
            cash = 0;
        }
        System.out.println("You Won " + bet);
        System.out.println("Your Balance is " + cash);
        slots.reroll();
    }

    public void HighlowRound(HighLow HighLow) {
        double bet;
        String side;
        System.out.println("Enter High Or Low (in lowercase)");
        side = scan.nextLine();
        System.out.println("Enter bet amount");
        bet = scan.nextDouble();
        cash -= bet;
        System.out.println("Rolling Dice!");
        System.out.println("Dice 1: " + HighLow.getDice1());
        System.out.println("Dice 2: " + HighLow.getDice2());
        System.out.println("Score: " + HighLow.getScore());
        if (HighLow.getScore() < 7) {
            if (side.equals("low")) {
                bet *= 2;
                System.out.println("You Won!");
            } else {
                System.out.println("You Lost!");
                bet = 0;
            }
        } else if (HighLow.getScore() > 7) {
            if (side.equals("high")) {
                bet *= 2;
                System.out.println("You Won!");
            } else {
                System.out.println("You Lost!");
                bet = 0;
            }
        }
        cash += bet;
        HighLow.reroll();
    }
    public boolean Rich() {
        return !(cash < 1);
    }
}
