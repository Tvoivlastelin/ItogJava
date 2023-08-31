
import java.util.Scanner;

public class ToyRaffleApp {
    public static void main(String[] args) {
        ToyManager toyManager = new ToyManager();

        FileHandler.loadToysFromFile(toyManager.getToys(), "toys.txt");
        toyManager.addToy(new Toy(1, "Кукла", 2, 22));
        toyManager.addToy(new Toy(2, "Мяч", 1, 30));
        toyManager.addToy(new Toy(3, "Конструктор", 1, 25));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Розыгрыш игрушки");
            System.out.println("2. Изменение веса игрушки");
            System.out.println("3. Сохранить данные в файл");
            System.out.println("4. Загрузить данные из файла");
            System.out.println("5. Выйти");

            System.out.print("Выберите пункт меню: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                try {
                    Toy toy = toyManager.drawToy();
                    if (toy != null) {
                        System.out.println("Вы выиграли игрушку: " + toy.getName());
                        toy.setQuantity(toy.getQuantity() - 1);
                        System.out.println("Остаток игрушек \"" + toy.getName() + "\": " + toy.getQuantity());
                    } else {
                        System.out.println("Игрушки закончились!");
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Ты все выиграл, что тебе еще нужно?!");
                    ;
                }
            } else if (choice == 2) {
                System.out.print("Введите ID игрушки: ");
                int toyId = scanner.nextInt();
                System.out.print("Введите новый вес игрушки: ");
                int weight = scanner.nextInt();
                toyManager.updateToyWeight(toyId, weight);
            } else if (choice == 3) {
                FileHandler.saveToysToFile(toyManager.getToys(), "toys.txt");
                System.out.println("Данные успешно сохранены в файл!");
            } else if (choice == 4) {
                FileHandler.loadToysFromFile(toyManager.getToys(), "toys.txt");
                System.out.println("Данные успешно загружены из файла!");
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Некорректный ввод. Попробуйте ещё раз.");
            }
            System.out.println();
        }
        scanner.close();
    }
}