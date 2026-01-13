public class Sword {
    private int strength;

    public Sword() {
        strength = (int) (Math.random() * 11) + 10;
    }

    public int getStrength() {
        return strength;
    }

    public void swing() {
        strength -= 1;
        if (strength < 0) {
            strength = 0;
        }
    }
}
