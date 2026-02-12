import java.util.Random;

public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();

        // Initial random population
        for (int i = 0; i < river.length; i++) {
            int rand = random.nextInt(3); // 0,1,2
            if (rand == 0) {
                river[i] = new Bear();
            } else if (rand == 1) {
                river[i] = new Fish();
            } else {
                river[i] = null;
            }
        }
    }

    public void runStep() {

        Animal[] nextRiver = new Animal[river.length];

        for (int i = 0; i < river.length; i++) {

            if (river[i] == null) continue;

            Animal current = river[i];

            // Random move: -1, 0, +1
            int move = random.nextInt(3) - 1;
            int newPos = i + move;

            // Stay inside bounds
            if (newPos < 0) newPos = 0;
            if (newPos >= river.length) newPos = river.length - 1;

            if (nextRiver[newPos] == null) {
                // Empty → move there
                nextRiver[newPos] = current;
            } else {
                Animal other = nextRiver[newPos];

                if (current instanceof Bear && other instanceof Fish) {
                    // Bear eats Fish
                    nextRiver[newPos] = current;

                } else if (current instanceof Fish && other instanceof Bear) {
                    // Fish gets eaten → do nothing

                } else {
                    // Same species collision → do nothing extra
                    // First one that arrived stays
                }
            }
        }

        river = nextRiver;
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Ecosystem eco = new Ecosystem(20);

        for (int i = 0; i < 10; i++) {
            eco.visualize();
            eco.runStep();
            System.out.println();
        }
    }
}