import java.util.Scanner;

public class Casino {
    private double cash;
    private Scanner scan;

    public Casino() {
        cash = 1000;
        scan = new Scanner(System.in);
    }

    public void gamble(){
        System.out.println("Welcome To The CASINO!");
        System.out.println("Enter One For Slots, Two For Higher Or Lower");
        String game = scan.nextLine();
        if (game.equals("1")) {
            Slots slots = new Slots();
            while (!poor()) {
                slotRound(slots);
            }
        } else if (game.equals("2")) {

        }
        System.out.println("Your Cash Ran Out!\nNow Get Out!");
    }

    public void slotRound(Slots slots){
        double bet;
        System.out.println("Enter bet amount");
        bet = scan.nextInt();
        cash -= bet;
        int[][] grid = slots.getGrid();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        System.out.println("The Score Is " + slots.getScore());
        bet = slots.checkBet() * bet;
        cash += bet;
        System.out.println(slots.checkBet());
        System.out.println("You Won " + bet);
        System.out.println("Your Balance is " + cash);
        slots.reroll();
    }
    public boolean poor() {
        return cash < 1;
    }
}
