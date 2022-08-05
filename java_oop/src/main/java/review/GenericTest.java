package review;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) throws Exception {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Olessya", 101));
        studentList.add(new Student("Kate", 102));
        studentList.add(new Student("Mike", 103));

        List<Teacher> teacherList = new ArrayList<>();

        teacherList.add(new Teacher("Albus", 201));
        teacherList.add(new Teacher("Severus", 202));


        //print all students and number of students
        printInfo(studentList);
        printGeneric(studentList);
        printGeneric(teacherList);

        System.out.println("returnLastItem(studentList).getName() = " + returnLastItem(studentList).getName());
        System.out.println("returnLastItem(teacherList).getName() = " + returnLastItem(teacherList).getName());

        MyUtils<Student> obj1 = new MyUtils<>();
        obj1.printGeneric(studentList);
        System.out.println("obj1 = " + obj1);
        System.out.println("obj1.returnLastItem(studentList).getName() = " + obj1.returnLastItem(studentList).getName());

        MyUtils<Teacher> obj2 = new MyUtils<>();
        obj2.printGeneric(teacherList);

        System.out.println("obj2.getLastItemName(teacherList) = " + obj2.getLastItemName(teacherList));

    }

    public static void printInfo(List<Student> students) {

        for (Student student : students) {
            System.out.println(student);
            System.out.println(students.size());

        }
    }

    //generic method to work for both classess
    public static <T> void printGeneric(List<T> list) {

        for (T each : list) {
            System.out.println(each);
        }
        System.out.println("Total =" + list.size());
    }

    // takes list , returns last item of the list

    public static <T> T returnLastItem(List<T> list){

        return list.get(list.size()-1);
    }



}
