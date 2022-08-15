import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TraderTransaction {

private Trader trader;
private int year;
private int value;
}
