import ObjectExamples.Player;


import java.util.ArrayList;

public class ArrayListExample <T extends Player> {

    public static void main(String[] args) {


        ArrayList<Integer> items = new ArrayList<Integer>();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
//        items.add("cat");

        printDouble(items);

    }

public static void printDouble (ArrayList <Integer> items){

//        for(Object i : items){
//            System.out.println((Integer)i * 2);
//        }

    for(int i : items){
        System.out.println(i * 2);
    }
}
}
