import java.util.Arrays;
import java.util.List;

public class TransactionData {

    public static List<TraderTransaction> getAll(){
        Trader raoul = new Trader ("Raoul","Cambridge");
        Trader mario = new Trader ("Mario","Milan");
        Trader  alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        return Arrays.asList(
                new TraderTransaction(brian,2011,300),
                new TraderTransaction(raoul,2012,1000),
                new TraderTransaction(raoul,2011,400),
                new TraderTransaction(mario,2012,710),
                new TraderTransaction(mario,2012,700),
                new TraderTransaction(alan,2012,950)
        );
    }
}
