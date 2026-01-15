public class HighLow {
    private int dice1;
    private int dice2;

    public HighLow() {
        dice1 = (int) (Math.random() * 5) + 1;
        dice2 = (int) (Math.random() * 5) + 1;
    }
    public int getScore(){
        return dice1+ dice2;
    }

    public void reroll() {
        dice1 = (int) (Math.random() * 5) + 1;
        dice2 = (int) (Math.random() * 5) + 1;
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }


}


