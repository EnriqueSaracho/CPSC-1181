
public class Snake extends Animal {

    private String snakeType;
    private boolean poisonous;

    public Snake(double weight, AnimalMovement movement, AnimalType type, String snakeType, boolean poisonous) {
        super(weight, movement, type);
        this.snakeType = snakeType;
        this.poisonous = poisonous;
    }

    public String getSnakeType() {
        return snakeType;
    }

    public boolean isPoisonous() {
        return poisonous;
    }

    @Override
    public String toString() {
        return super.toString() + " [snakeType: " + snakeType + ", isPoisonous: " + poisonous + "]";
    }
}
