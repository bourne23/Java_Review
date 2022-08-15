import java.util.Optional;

import static java.util.Comparator.comparing;

public class TransactionTest {


    public static void main(String[] args) {


        //1- Find all transactions in 2011 and sort by value
        System.out.println("******Task-1************");

        TransactionData.getAll()
                .stream()
                .filter(traderTransaction -> traderTransaction.getYear()==2011)
                .sorted(comparing(TraderTransaction::getValue))
                .forEach(System.out::println);

        //2- What are all the unique cities where the traders work?
        System.out.println("******Task-2************");

        TransactionData.getAll().stream().map(traderTransaction -> traderTransaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        //3- Find all traders from Cambridge and sort them by name
        System.out.println("******Task-3************");
        TransactionData.getAll().stream()
//                .map(traderTransaction -> traderTransaction.getTrader().getCity().equals("Cambridge")) no
                .map(traderTransaction -> traderTransaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName)).forEach(System.out::println);

        //4- Return a string of all trader's names sorted alphabetically
        System.out.println("******Task-3************");
       String result =  TransactionData.getAll()
                .stream()
                .map(traderTransaction -> traderTransaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (name1, name2) -> name1+name2);
        System.out.println("result = " + result);

        //5- Are any traders based in Milan?
        System.out.println("******Task-5************");
        boolean milanBased = TransactionData.getAll()
                .stream()
                .anyMatch(traderTransaction -> traderTransaction.getTrader().getCity().equals("Milan"));
        System.out.println("milanBased = " + milanBased);


        //6- Print the values of all transactions from the traders living in Cambridge
        System.out.println("******Task-6************");
        TransactionData.getAll()
                .stream()
                .filter(traderTransaction -> traderTransaction.getTrader().getCity().equals("Cambridge"))
                .map(TraderTransaction::getValue)
                .forEach(System.out::println);

        //7 - What is the highest value of all the transactions
        System.out.println("******Task-7************");
        Optional<Integer> high = TransactionData.getAll().stream()
                .map(traderTransaction -> traderTransaction.getValue())
                .reduce(Integer::max);
        System.out.println(high.get());

        //8-Find the transaction with the smallest value
        System.out.println("******Task-8************");
        Optional<TraderTransaction> smvalue = TransactionData.getAll().stream()
                .reduce((t1,t2) -> t1.getValue()<t2.getValue() ? t1 : t2);

        System.out.println(smvalue.get());

        Optional<TraderTransaction> smallestValue = TransactionData.getAll().stream()
                .min(comparing(TraderTransaction::getValue));

        System.out.println(smallestValue.get());



    }
}
