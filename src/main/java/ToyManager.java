import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyManager {
        private final List<Toy> toys;

        public ToyManager() {
            this.toys = new ArrayList<>();
        }

        public void addToy(Toy toy) {
            toys.add(toy);
        }

        public void updateToyWeight(int toyId, int weight) {
            for (Toy toy : toys) {
                if (toy.getId() == toyId) {
                    toy.setWeight(weight);
                    break;
                }
            }
        }

    public Toy drawToy() {
        Random random = new Random();
        List<Toy> availableToys = toys.stream().filter(toy -> toy.getQuantity() > 0).toList();
        int totalWeight = availableToys.stream().mapToInt(Toy::getWeight).sum();
        int randomNumber = random.nextInt(totalWeight);
        int currentWeight = 0;
        for (Toy toy : availableToys) {
            currentWeight += toy.getWeight();
            if (randomNumber < currentWeight) {
                return toy;
            }
        }
        return null;
    }
        public List<Toy> getToys() {
            return toys;
        }
    }
