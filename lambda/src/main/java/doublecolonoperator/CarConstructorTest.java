package doublecolonoperator;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CarConstructorTest {

    public static void main(String[] args) {


        //Zero-argument
         //  return , accept nothin, return
        Supplier<Car> c1 = () -> new Car();   // constructor invocation instead of method
        System.out.println(c1.get().getYear());

        Supplier<Car> c2 = Car::new;      //new constructor
        System.out.println(c2.get().getYear());


        //One Argument :
             // accept , return
        Function<Integer, Car> f1 = year -> new Car(year);
        Car bmw = f1.apply(2009);
        System.out.println(bmw.getYear());


        Function<Integer, Car> f2 = Car::new;
        Car bmw2 = f2.apply(2015);
        System.out.println(bmw2.getYear());


        //Two Argument
        BiFunction<String, Integer, Car> b1 = (make, model) -> new Car(make, model);
        Car honda = b1.apply("Honda", 2007);
        System.out.println(honda.getMake() + " " + honda.getYear());

        BiFunction<String, Integer, Car> b2 = Car::new;
        Car nissan = b2.apply("Nissan", 2001);
        System.out.println(nissan.getMake() + " " + nissan.getYear());


    }
}
