import java.util.*;

public class ArrayListReview {

    public static void main(String[] args) {
        // Create ArrayList and a class

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Tina"));
        students.add(new Student(2, "Rock"));
        students.add(new Student(3, "Barby"));
        students.add(new Student(4, "Kenny"));
        System.out.println(students);


        // Iteration on ArrayLists
        // 1. For Loop with get(index)
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        // 2. Iterator
        // Forward Iteration
        System.out.println("Printing with Iterator Forward........");

        Iterator iter = students.listIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        // Backwards Iteration
        System.out.println("Printing with Iterator Backwards........");
        while (((ListIterator<?>) iter).hasPrevious()) {
            System.out.println(((ListIterator<?>) iter).previous());
        }

        // 3. for each loop
        System.out.println("Printing For each loop..........");
        for (Student student : students) {
            System.out.println(student);
        }

        // 4. Lambda
        System.out.println("Printing with Lambda..........");
        students.forEach(student -> System.out.println(student));

        // Sorting Elements in List
        System.out.println("Printing sorted List by id asc with comparator..........");
        Collections.sort(students, new sortByIdDesc());
        System.out.println(students);
        System.out.println("Printing sorted List by name Desc..........");
        Collections.sort(students, new sortByNameDesc());
        System.out.println(students);

    }

    // 5. Using comparator
    // create an inner class implementing Comparator interface to override compare method
    static class sortByIdDesc implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    // Descending order
    static class sortByNameDesc implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.name.compareToIgnoreCase(o1.name);
        }
    }


}