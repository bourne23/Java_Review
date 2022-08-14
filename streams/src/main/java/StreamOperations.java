import java.util.Arrays;
import java.util.List;

public class StreamOperations {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 7, 8, 9);
        list.forEach(x -> System.out.println("x = " + x));
        list.forEach(System.out::println);


        System.out.println("-- filter");
        list.stream().filter(i -> (i % 2 == 0))
                .forEach(System.out::println);

        list.stream()
                .filter(i -> (i > 5))
                .forEach(System.out::println);

        System.out.println("-- limit");
        list.stream()
                .filter(i -> (i > 5))
                .limit(6)
                .forEach(System.out::println);

        // skip element of that value
        System.out.println("-- skip");
        list.stream()
                .filter(i -> (i > 5))
                .skip(1)
                .forEach(System.out::println);

        //map makes operation on each element and returns it
        System.out.println("-- map");
        list.stream()
                .map(num -> num * 2)
                .filter(i -> (i > 5))
                .forEach(System.out::println);


// DISH

        List<Dish> dishList = Arrays.asList(new Dish("pork",false,800,Type.MEAT),
                new Dish("beef",false,700,Type.MEAT),
                new Dish("chicken",false,400,Type.MEAT),
                new Dish("french fries",true,530,Type.OTHER),
                new Dish("rice",true,350,Type.OTHER),
                new Dish("season fruit",true,120,Type.OTHER),
                new Dish("shrimp",false,300,Type.FISH),
                new Dish("salmon",false,450,Type.FISH)
        );


        dishList.stream().filter(dish -> (dish.getCalories()<400)).forEach(System.out::println);

    }
}
