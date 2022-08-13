package functionalinterfaces;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private int age;

}
