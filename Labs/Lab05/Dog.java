
public class Dog extends Animal {

    private String breed;

    public Dog(double weight, AnimalMovement movement, AnimalType type, String breed) {
        super(weight, movement, type);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return super.toString() + " [breed: " + breed + "]";
    }
}
