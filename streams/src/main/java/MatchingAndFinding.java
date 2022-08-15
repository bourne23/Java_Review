import java.util.Optional;

public class MatchingAndFinding {

    /*
         match and find methods using Predicate as param

     */
    public static void main(String[] args) {

        //ALL MATCH - if all elements match the Predicate - returns true

        System.out.println("all match*******************");
        boolean isHealthy = DishData.getData()
                .stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("match = " + isHealthy);


        //ANY MATCH   -- is there any vegetarian match?     -- returns boolean
        System.out.println("any match*******************");
        if (DishData.getData()
                .stream()
                .anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is vegetarian friendly");
        }

        //NONE MATCH  -- if none are matched returns true
        System.out.println("none match *******************");
        boolean isHealthy2 = DishData.getData()
                .stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println("non match = " + isHealthy2);


        //FIND ANY  -- returns Optional <>
        System.out.println("find any *******************");
        Optional<Dish> optionalDish = DishData.getData()
                .stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(optionalDish.get());  // returns dish object
        System.out.println(optionalDish);     // returns dish optional


        //FIND FIRST
        System.out.println("find first *******************");
        Optional<Dish> dish2 = DishData.getData()
                .stream()
                .filter(Dish::isVegetarian)
                .findFirst();
        System.out.println(dish2.get());



    }
}