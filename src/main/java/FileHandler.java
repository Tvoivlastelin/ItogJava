import java.io.*;
import java.util.List;

public class FileHandler {
    public static void saveToysToFile(List<Toy> toys, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Toy toy : toys) {
                writer.println(toy.getId() + "," + toy.getName() + "," + toy.getQuantity() + "," + toy.getWeight());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadToysFromFile(List<Toy> toys, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int weight = Integer.parseInt(parts[3]);
                toys.add(new Toy(id, name, quantity, weight));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
