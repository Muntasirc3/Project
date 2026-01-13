public class Enemy {
    private String name;
    private int health;

    public Enemy(String name) {
        this.name = name;
        health = 50;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    // public methods
    public boolean isDead() {
        return health == 0;
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        if (health < 0) {
            health = 0;
        }
    }

    public int dropGold() {
        return (int) (Math.random() * 50) + 1;
    }
}