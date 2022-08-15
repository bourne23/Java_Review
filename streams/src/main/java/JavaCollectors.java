import java.util.*;
import java.util.stream.Collectors;

public class JavaCollectors {
    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(3, 4, 5, 6, 6, 7);

//toCollection(Supplier) : is used to create a collection using collector

        System.out.println("********TOCOLLECTION()***********");
        List<Integer> numberList = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(numberList);

        Set<Integer> numberSet = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toCollection(HashSet::new));

        System.out.println(numberSet);

        //toList() : returns a Collector interface that gathers the input data into a new list
        System.out.println("********TOLIST()***********");
        List<Integer> numberList2 = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(numberList2);  //[4, 6, 6]

//toSet() : returns a Collector interface that gathers the input data into a new set

        System.out.println("********TOSET()***********");
        Set<Integer> numberSet2 = numbers.stream()
                .filter(x -> x%2==0)
                .collect(Collectors.toSet());

        System.out.println(numberSet2); //[4, 6]

        //toMap(Function,Function) : returns a Collector interface that gathers the input data into a new map
        System.out.println("********TOMAP()***********");
        Map<String,Integer> dishMap = DishData.getData().stream()
                .collect(Collectors.toMap(Dish::getName,Dish::getCalories));

        System.out.println(dishMap); //{season fruit=120, chicken=400, shrimp=300, salmon=450, beef=700, pork=800, rice=350, french fries=530}

        //counting() : returns a Collector that counts the number of the elements
        System.out.println("********COUNTING()***********");
        Long evenCount = numbers.stream()
                .filter(x -> x%2==0)
                .collect(Collectors.counting());    //collect(counting())' can be replaced with 'count()'

        System.out.println(evenCount); // 3

        //summingInt(ToIntFunction) : returns a Collector that produces the sum of a integer-valued func
        System.out.println("********SUMMINGINT()***********");
        Integer sum = DishData.getData().stream()
                .collect(Collectors.summingInt(Dish::getCalories));  //collect(summingInt())' can be replaced with 'mapToInt().sum()'

        System.out.println(sum);  //3650

        //averageingInt(ToIntFunction) : returns the average of the integers passed values
        System.out.println("********AveragingInt()***********");
        Double calorieAvg =  DishData.getData().stream()
                .collect(Collectors.averagingInt(Dish::getCalories));

        System.out.println(calorieAvg);   // 456.25

        //joining() : is used to join various elements of a character or string array into a single string object
        System.out.println("********JOINING()***********");
        List<String> courses = Arrays.asList("Java","JS","TS");
        String str =  courses.stream()
                .collect(Collectors.joining(","));

        System.out.println(str);  //    Java,JS,TS

        //partioningBy() : is used to partition a stream of objects(or set of elements) based on a given predicate
        System.out.println("********PARTIONINGBY()***********");
        Map<Boolean,List<Dish>> veggieDish =
                DishData.getData()
                        .stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));    // uses Predicate true or false

        System.out.println(veggieDish);
        // {false=
        // [Dish(name=pork, vegetarian=false, calories=800, type=MEAT),
        // Dish(name=beef, vegetarian=false, calories=700, type=MEAT),
        // Dish(name=chicken, vegetarian=false, calories=400, type=MEAT),
        // Dish(name=shrimp, vegetarian=false, calories=300, type=FISH),
        // Dish(name=salmon, vegetarian=false, calories=450, type=FISH)],

        // true=
        // [Dish(name=french fries, vegetarian=true, calories=530, type=OTHER),
        // Dish(name=rice, vegetarian=true, calories=350, type=OTHER),
        // Dish(name=season fruit, vegetarian=true, calories=120, type=OTHER)]}


        //groupingBy() : is used for grouping objects by some property and storing results in a map instance
        System.out.println("********GROUPINGBY()***********");
        Map<Type,List<Dish>> dishType = DishData.getData().stream()
                .collect(Collectors.groupingBy(Dish::getType));

        System.out.println(dishType);

        //{FISH=
        // [Dish(name=shrimp, vegetarian=false, calories=300, type=FISH),
        // Dish(name=salmon, vegetarian=false, calories=450, type=FISH)],
        // OTHER=[Dish(name=french fries, vegetarian=true, calories=530, type=OTHER),
        // Dish(name=rice, vegetarian=true, calories=350, type=OTHER),
        // Dish(name=season fruit, vegetarian=true, calories=120, type=OTHER)],
        // MEAT=
        // [Dish(name=pork, vegetarian=false, calories=800, type=MEAT),
        // Dish(name=beef, vegetarian=false, calories=700, type=MEAT),
        // Dish(name=chicken, vegetarian=false, calories=400, type=MEAT)]}



    }
}
