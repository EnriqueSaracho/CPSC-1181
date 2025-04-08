
public abstract class Animal {

    private double weight;
    private AnimalMovement movement;
    private AnimalType animalType;

    public enum AnimalMovement {
        WALK, SWIM, CRAWL, FLY
    }

    public enum AnimalType {
        MAMMAL, REPTILE, BIRD, INSECT
    }

    public Animal(double weight, AnimalMovement movement, AnimalType animal_type) {
        this.weight = weight;
        this.movement = movement;
        this.animalType = animal_type;
    }

    public double getWeight() {
        return weight;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public String toString() {
        return "\n" + getClass().getName() + "[ weight: " + weight + ", movement: " + movement + ", Animal Type: "
                + animalType + "]";
    }
}
