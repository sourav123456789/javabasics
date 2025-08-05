import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindItemPrice {
    public static void main(String[] args) {
        Menu mainCourse = new Menu(
                "Veg-meal",
                Arrays.asList(

                        new MenuGroup(
                                "dal",
                                Arrays.asList(),
                                Arrays.asList(
                                        new MenuItem("kali dal", 500.0),
                                        new MenuItem("pili dal", 600.0)
                                ),
                                800.0
                        ),
                        new MenuGroup(

                                "paneer",
                                Arrays.asList(
                                        new MenuGroup(
                                                "Kadahi paneer",
                                                null,
                                                Arrays.asList(
                                                        new MenuItem("Kadhai Lassoni paneer", 11500.0),
                                                        new MenuItem("Kadhai kashmiir paneer", 11600.0)
                                                ),
                                                800.0
                                        ),

                                        new MenuGroup(

                                                "Muglai paneer",
                                                null,
                                                Arrays.asList(
                                                        new MenuItem("Muglai Lassoni paneer", 11500.0),
                                                        new MenuItem("Muglai kashmiir paneer", 11600.0)
                                                ),
                                                800.0

                                        )
                                ),
                                Arrays.asList(
                                        new MenuItem("Lassoni Paneer", 1500.0),
                                        new MenuItem("Kashmiri Paneer", 1800.0)
                                ),
                                800.0

                        )


                ),
                0.0
        );
        List<Menu> menus = new ArrayList<>();
        menus.add(mainCourse);
        findPrice(menus , new MenuItem("Muglai Lassoni paneer"  , 11500.0) );
    }

    private static void findPrice(List<Menu> menus, MenuItem item) {



    }
}
