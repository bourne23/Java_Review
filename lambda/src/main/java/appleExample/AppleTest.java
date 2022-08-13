package appleExample;

import java.util.ArrayList;
import java.util.List;

public class AppleTest {
    public static void main(String[] args) {

        List<Apple> appleList = new ArrayList<Apple>();

        appleList.add(new Apple(380, Color.GREEN));
        appleList.add(new Apple(100, Color.RED));
        appleList.add(new Apple(80, Color.GREEN));
        appleList.add(new Apple(480, Color.RED));

        List <Apple> heavyAppleList = filterApples(appleList, new AppleHeavyPredicate() );
        System.out.println("heavyAppleList = " + heavyAppleList);
   
    }


    private static List<Apple> filterApples(List<Apple> appleList, ApplePredicate applePredicate){

        List<Apple> result = new ArrayList<>();

        for(Apple apple:appleList){
            if (applePredicate.test(apple)){
                result.add(apple);
            }
        }

        return result;
    }

//    private static void prettyPrint (List<Apple> inventory, ApplePredicate applePredicate) {
//        for(Apple apple:inventory){
//
//
//        }


//        }


}
