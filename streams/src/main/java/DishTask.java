import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class DishTask {

    public static void main(String[] args) {
        // 1.
        List<String> words = Arrays.asList("Java","Apple","Honda","Developer");

        String x = "Java";
        System.out.println(x.length());

        words.stream()
                .map(String::length)
                .forEach(System.out::println);


        //2. print dishes names under 400 cal -- call static method directly through class
        System.out.println("***********************");
        DishData.getData().stream()
                .filter(dish -> (dish.getCalories()<400))
  /*Dish(name=rice, vegetarian=true, calories=350, type=OTHER)
Dish(name=season fruit, vegetarian=true, calories=120, type=OTHER)
Dish(name=shrimp, vegetarian=false, calories=300, type=FISH)  */
                .map(Dish :: getName)
 /*rice
season fruit
shrimp*/
                .forEach(System.out::println);

        System.out.println("***********************");
        //3. print length of name of each dish
               DishData.getData()
                       .stream()
                       .map(Dish::getName)
                       .map(String::length)
                       .forEach(System.out::println);

        System.out.println("***********************");
        //4. print Three high caloric dishes
        DishData.getData().stream()
                .filter(dish -> (dish.getCalories()>300))
                .map(Dish::getName)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("***********************");
        // 5. sorted Asc order and below 400 cal

        DishData.getData().stream()
                .filter(dish -> (dish.getCalories()<400))
                .sorted(comparing(dish -> (dish.getCalories())))
                .map(Dish::getName)
                .forEach(System.out::println);

        System.out.println("***********************");
        DishData.getData().stream()
                .filter(dish -> (dish.getCalories()<400))
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .forEach(System.out::println);

        System.out.println("***********************");
  // Sort Desc order
        DishData.getData().stream()
                .filter(dish -> (dish.getCalories()<400))
                .sorted(comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .forEach(System.out::println);

    }






}
