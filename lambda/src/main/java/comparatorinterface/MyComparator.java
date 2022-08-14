package comparatorinterface;

import java.util.Comparator;

// behaviour parameterization, implement comparator to override and make custom method

public class MyComparator implements Comparator<Integer> {    //  int compare(T o1, T o2);
    @Override
    public int compare(Integer o1, Integer o2) {

        return (o1>o2) ? -1 : (o2<o1) ? 1 : 0;
    }
}
