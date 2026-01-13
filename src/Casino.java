import java.util.Scanner;

public class Casino {
    private int cash;
    private boolean first;
    private Scanner scan;

    public Casino() {
        cash = 1000;
        first = true;
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
    }

    public void slotRound(Slots slots){
        int[][] grid = slots.getGrid();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        int bet;
        System.out.println("Enter bet amount");
        bet = scan.nextInt();

    }
    public boolean poor() {
        return cash <= 0;
    }
}
