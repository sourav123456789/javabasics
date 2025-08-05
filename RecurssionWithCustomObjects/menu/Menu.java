import java.util.List;

public class Menu {
    String name;
    List<MenuGroup> groups;
    Double price;

    public Menu(String name, List<MenuGroup> groups, Double price) {
        this.name = name;
        this.groups = groups;
        this.price = price;
    }
}

class MenuGroup {
    String name;
    List<MenuGroup> groups;
    List<MenuItem> items;
    Double price;

    public MenuGroup(String name, List<MenuGroup> groups, List<MenuItem> items, Double price) {
        this.name = name;
        this.groups = groups;
        this.items = items;
        this.price = price;
    }
}

class MenuItem {
    String name;
    Double price;

    public MenuItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
