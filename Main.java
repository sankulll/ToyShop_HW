package TS;

public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop("1", "2", "3", "Мячик", "Кукла", "Машинка", 2, 3, 1);
        toyShop.saveToFile("Список.txt");
    }
}
