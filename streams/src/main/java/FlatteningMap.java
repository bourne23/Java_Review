import java.util.stream.Stream;

public class FlatteningMap {

    /*
   ***  map() takes Stream<T> and returns Stream <T>
        It is mapper function produces single value for each input value
        Its' called One-to-One mapping.

   ***  flatMap() takes Stream<Stream<T>> as input and returns Stream
        It is mapper function produces multiple values for each input value
        It's called One-To-Many mapping.

     */
    public static void main(String[] args) {

        //  Stream.of(1,2,3,4); >> [1,2,3,4]

        // [[1,2,3], [4,5,6], [7,8,9]]  >>  [1,2,3,4,5,6,7,8,9]   - map flattening




    }



}
