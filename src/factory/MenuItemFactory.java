package factory;

import model.Category;
import model.MenuItem;

import java.util.List;
import java.util.Random;

public class MenuItemFactory {
    private static final Random random = new Random();
    private static final List<String> drinkNames = List.of("Сок", "Кока-кола", "Пиво", "Боржоми", "Квас");
    private static final List<String> mainDishNames = List.of("Пюре", "Плов", "Лазанья", "Рис", "Пицца");
    private static final List<String> dessertNames = List.of("Круассан", "Запеканка", "Вафли", "Пирог", "Пирожное");
    private static final List<String> snackNames = List.of("Чипсы", "Наггетсы", "Крылышки", "Гренки", "Начос");


    private MenuItemFactory() { // private
    }

    public static MenuItem next(Category category) {  //static
        if (category == Category.DRINK) {
            int itemID = random.nextInt(1000, 1999);
            String drinkName = drinkNames.get(random.nextInt(drinkNames.size()));
            double itemPrice = random.nextDouble(5, 10);
            return new MenuItem(itemID, drinkName, itemPrice, Category.DRINK, true);

        } else if (category == Category.MAIN_DISH) {
            int itemID = random.nextInt(2000, 2999);
            String dishName = mainDishNames.get(random.nextInt(mainDishNames.size()));
            double itemPrice = random.nextDouble(15, 20);
            return new MenuItem(itemID, dishName, itemPrice, Category.MAIN_DISH, true);

        } else if (category == Category.DESSERT) {
            int itemID = random.nextInt(3000, 3999);
            String dessertName = dessertNames.get(random.nextInt(dessertNames.size()));
            double itemPrice = random.nextDouble(8, 15);
            return new MenuItem(itemID, dessertName, itemPrice, Category.DESSERT, true);

        } else {
            int itemID = random.nextInt(4000, 4999);
            String snackName = snackNames.get(random.nextInt(snackNames.size()));
            double itemPrice = random.nextDouble(10, 20);
            return new MenuItem(itemID, snackName, itemPrice, Category.SNACK, true);
        }
    }


    /*private static MenuItem nextDrink() {
        int itemID = random.nextInt(1000, 1999);
        String drinkName = drinkNames.get(random.nextInt(drinkNames.size()));
        double itemPrice = random.nextDouble(5, 10);
        return new MenuItem(itemID, drinkName, itemPrice, Category.DRINK, true);
    }

    private static MenuItem nextMainDish() {
        int itemID = random.nextInt(2000, 2999);
        String dishName = mainDishNames.get(random.nextInt(mainDishNames.size()));
        double itemPrice = random.nextDouble(15, 20);
        return new MenuItem(itemID, dishName, itemPrice, Category.MAIN_DISH, true);
    }

    private static MenuItem nextDessert() {
        int itemID = random.nextInt(3000, 3999);
        String dessertName = dessertNames.get(random.nextInt(dessertNames.size()));
        double itemPrice = random.nextDouble(8, 15);
        return new MenuItem(itemID, dessertName, itemPrice, Category.DESSERT, true);
    }

    private static MenuItem nextSnack() {
        int itemID = random.nextInt(4000, 4999);
        String snackName = snackNames.get(random.nextInt(snackNames.size()));
        double itemPrice = random.nextDouble(10, 20);
        return new MenuItem(itemID, snackName, itemPrice, Category.SNACK, true);
    }*/

}


