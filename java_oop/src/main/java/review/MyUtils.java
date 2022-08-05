package review;

import java.util.List;

public class MyUtils<T> {
//public class MyUtils<T extends Student> { to limit objects

    //generic method to print info
    public void printGeneric(List<T> list) {

        for (T each : list) {
            System.out.println(each);
        }
        System.out.println("Total =" + list.size());
    }

    // generic method that takes list , returns last item of the list

    public T returnLastItem(List<T> list) {

        return list.get(list.size() - 1);
    }


    public String getLastItemName(List<T> list) throws Exception {

        T lastItem = list.get(list.size() - 1);
        if(lastItem instanceof Student){
            return ((Student) lastItem).getName();
        }else if(lastItem instanceof Teacher){
            return  ((Teacher) lastItem).getName();
        }else {
            throw new Exception("Some Error");
        }


    }




}

