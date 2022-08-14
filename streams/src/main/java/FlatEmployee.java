import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FlatEmployee {

    private int empId;
    private String name;
    private String email;
    private List<String> phoneList;
}
