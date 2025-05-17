package service;

import exception.MenuItemNotFoundException;
import factory.MenuItemFactory;
import model.Category;
import model.MenuItem;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;


public class MenuService {
    private static final Set<MenuItem> menuItems = new LinkedHashSet<>(); //static?

    public void createTodayMenu() { //тут может быть большой ENUM
     /*   addItem(MAIN_DISH);
        addItem(MAIN_DISH);
        addItem(MAIN_DISH);
        addItem(SNACK);
        addItem(SNACK);
        addItem(SNACK);
        addItem(DRINK);
        addItem(DRINK);
        addItem(DRINK);
        addItem(DESSERT);
        addItem(DESSERT);
        addItem(DESSERT);*/
        Arrays.stream(Category.values()).forEach(category ->
                IntStream.range(0, 3).forEach(i ->
                        menuItems.add(MenuItemFactory.next(category))
                )
        );
    }

    public void printMenuItems() {
        int j = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.println("Блюдо № " + j + ": " + menuItem);
            j++;
        }
    }

    public void addItem(final Category category) {
        menuItems.add(MenuItemFactory.next(category));
    }

    public void removeItem(final MenuItem item) {
        menuItems.remove(item);
    }

    public MenuItem findItem(final String itemName) throws MenuItemNotFoundException { //Можно сократить немного
        return menuItems.stream()
                .filter(item -> item.getItemName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(() -> new MenuItemNotFoundException("Блюдо " + itemName + " не найдено в меню!"));
    }
}

