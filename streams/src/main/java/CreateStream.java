import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {

        //Creating Stream from Array
        String[] courses = {"JAVA", "KOT", "JS"};
        Arrays.stream(courses);
        Stream<String> courseStream = Arrays.stream(courses);    //Arrays.stream(string array)

        // from collection
        List<String> list = Arrays.asList("Aya", "YuM", "OM");
        Stream<String> stream = list.stream();



        List<Course> myCourses = Arrays.asList(
                new Course("iota", 77),
                new Course("java", 54),
                new Course("keto", 01)
        );


        Stream<Course> myStream = myCourses.stream();


        //stream of integers
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);


    }


}
