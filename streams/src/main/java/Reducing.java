import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {

    public static void main(String[] args) {
   /*      stream().reduce(0,(a,b) -> a+b);         uses BiFUNCTION.apply(T, U)

           Reducing the stream to one value is for calculating single average, highest, total, some single value...

   int result = numbers.stream().reduce(0,(a,b) -> a+b);

              0 - initial value; 
              (a,b) is two params, 
              -> a+b is action on them(binary operation)
*/

        //1. Initial value = 0  --  returns int
        List<Integer> list = Arrays.asList(22, 33, 44, 55, 66);
        int result = list.stream().reduce(0, (a, b) -> (a + b));
        System.out.println("result = " + result);


        //2. No initial value  --   returns Optional<>
        List<Integer> list2 = Arrays.asList(2, 3, 4, 5, 6);
        Optional<Integer> optional = list2.stream().reduce((a, b) -> (a + b));  //lambda , can shorten with method reference
        System.out.println("optional = " + optional);

        //3. Max and Min     --   returns Optional<>
        Optional<Integer> max = list2.stream().reduce(Integer::max);
        Optional<Integer> min = list2.stream().reduce(Integer::min);
        Optional<Integer> sum = list2.stream().reduce(Integer::sum);

        System.out.println("Min:" + min.get());
        System.out.println("Max:" + max.get());
        System.out.println("Sum:" + sum.get());


        // 4. print number of dihes total using map and reduce!

        //        map(dish -> 1) - every dish will return 1

        int count = DishData.getData().stream().map(dish -> 1).reduce(0, (a, b) -> (a + b));
        System.out.println("count = " + count);

        Optional<Integer> optional2 = DishData.getData().stream().map(dish -> 1).reduce(Integer::sum);
        System.out.println("optional2 = " + optional2);

        // 5.     stream().count();
        long dishes = DishData.getData().stream().count();
        System.out.println("dishes total = " + dishes);




    }

}
