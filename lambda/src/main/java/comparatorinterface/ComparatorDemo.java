package comparatorinterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class ComparatorDemo {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 0, 15, 5, 20);
        System.out.println(list);

        //Ascending sort
        Collections.sort(list);
        System.out.println("asc = " + list);

       //1. using behavior parameterization, list and behaviour
        //Descending order  - behav param.
        Collections.sort(list, new MyComparator());
        System.out.println("desc = "+ list);


        //2. passing lambda directly: return (o1>o2) ? -1 : (o2<o1) ? 1 : 0;
        Collections.sort(list, ((o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0));
        System.out.println("lamda directly list = " + list);


        //3. ready static method 'compareTo', takes list and every element compares to each other > / <
        //Ascending
        list.sort((x, y) -> x.compareTo(y));
        System.out.println("static asc = "+ list);

        //Descending
        list.sort((o2, o1) -> o1.compareTo(o2));
        System.out.println("static desc = "+ list);


        // ****** Comparator comparing() ***********
        List<Apple> myInventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.RED),
                new Apple(120, Color.GREEN)
        );

        Comparator<Apple> sortApple = Comparator.comparing((apple) -> apple.getWeight());
        myInventory.sort(sortApple);
        System.out.println("sort by weight applss: "+ myInventory);

        myInventory.sort(comparing((apple) -> apple.getWeight()));


        myInventory.sort(comparing(Apple::getWeight));

        //Reversed
        myInventory.sort(comparing(Apple::getWeight).reversed());

        //Chaining
        myInventory
                .sort(comparing(Apple::getWeight)
                        .reversed()
                        .thenComparing(Apple::getColor));
        System.out.println(myInventory);


    }
}
