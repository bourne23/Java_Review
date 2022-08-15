import java.util.stream.Stream;

public class CreateInfiniteStream {

//iterate(0, n->n+3)
    public static void main(String[] args) {

        Stream.iterate(0, n->n+2)
                .limit(5)
                .forEach(System.out::println);


        Stream.iterate(0, n->n+3)
                        .limit(4)
                                .forEach(System.out::println);


        System.out.println("*********");
        //How does it work? iterate needs a lambda to specify the successor element.
        //In the case of the tuple (3,5) the successor (5, 3+5) = (5,8)
        //The next one (8, 5+8)


        //        iterate(0, n->n+3)
//where    0= {3,5}, n=tuple -> operation: new int array with {[first elem, second index of array]}
// operation creates a sum  new int[]{t[1],t[0]+t[1]})

        Stream.iterate(new int[]{0,1}, tuple -> new int[]{tuple[1],tuple[0]+tuple[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));


//        Stream.iterate()

        System.out.println("*********");

        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1],t[1]+t[0]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);


    }
}
