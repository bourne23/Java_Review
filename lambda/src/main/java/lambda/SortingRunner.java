package lambda;

public class SortingRunner {

    private void sort(Sorting sorting) {  // pass interface sort to method and implement differently based on req
        sorting.sort();
    }

    public static void main(String[] args) {

        SortingRunner sortingRunner = new SortingRunner();
//        sortingRunner.sort();

        QuickSort qs = new QuickSort();
        // or polymorphysm :  Sorting qs = new QuickSort();
        BubbleSort bs = new BubbleSort();
        sortingRunner.sort(qs);
        sortingRunner.sort(bs);


       Sorting quickSort = () -> System.out.println("Quick sorting +");
       sortingRunner.sort(quickSort);

       Sorting bubbleSorting = () -> System.out.println("Bubble sorting +");
       sortingRunner.sort(bubbleSorting);


       sortingRunner.sort(() -> System.out.println("Bubble sorting -"));



    }



}

interface MyLambda{

    void print();
}
