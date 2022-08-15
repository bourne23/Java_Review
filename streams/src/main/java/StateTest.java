import java.util.Arrays;
import java.util.List;

public class StateTest {

    public static void main(String[] args) {

        // create 2 states with cities
        State va = new State();
        va.addCity("McLean");
        va.addCity("Arlington");
        va.addCity("Fairfax");
        va.addCity("FallsChurch");

        State tx = new State();
        tx.addCity("Dallas");
        tx.addCity("Plano");
        tx.addCity("Austin");
        tx.addCity("Houston");

        // create list of States
        List<State> list = Arrays.asList(va, tx);

        list.stream()
                .map(state -> state.getCity())
                .forEach(System.out::println);

        /// flat map
        list.stream()
                .map((state -> state.getCity()))
                .flatMap(List::stream)
                .forEach(System.out::println);

        /// flat map - object State has a variable List<Cities>
        list.stream()
                .map((State::getCity))
                .flatMap(List::stream)
                .forEach(System.out::println);
        System.out.println("****");

        //another way to write
        list.stream()
                .flatMap((state -> state.getCity()
                        .stream()))
                .forEach(System.out::println);



    }
}
