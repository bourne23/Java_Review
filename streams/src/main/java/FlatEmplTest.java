import java.util.List;

public class FlatEmplTest {

    public static void main(String[] args) {

        // 1 . print all emails - one to one
        FlatEmployeeData.readAll()  // -- returns Stream<FlatEmployee>
                .map(FlatEmployee::getEmail).forEach(System.out::println);

        // 2 .  print all phone numbers               // returns Stream of Stream
        FlatEmployeeData.readAll()
                .map(FlatEmployee::getPhoneList)
                .forEach(System.out::println);
/*
[2029124536, 2023464768]
[7039124536, 7033464768]
[5169124536, 5163464768]
 */

        // 3 . print all phone numbers                                    // returns flattened Stream
        FlatEmployeeData.readAll()
                .flatMap(flatEmployee -> flatEmployee.getPhoneList().stream())
                .forEach(System.out::println);
/*
2029124536
2023464768
7039124536
7033464768
5169124536
5163464768
 */
        // 4. alternative to last
        FlatEmployeeData.readAll()
                .map(FlatEmployee::getPhoneList) // returns Stream because we mapped a list, not element
                .flatMap(List::stream)       //same as flatEmployee -> flatEmployee.getPhoneList().stream())
                .forEach(System.out::println);


    }
}
