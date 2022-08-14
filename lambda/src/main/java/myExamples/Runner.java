package myExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Runner {

    /***  test method
     implement behavior parameterization method, pass interface (functional) as param and then call implementation class
     and call its own method
     */
    private void test(Process process) {
        process.start();
    }

    private static void printElectronic(List<Channel> list, Complete complete) {
        for (Channel each : list) {
            if (each.getType().equals(ChannelType.E)) {
                complete.finish(each);
                System.out.println("print electronic communication");
            }
        }
    }

    private static void printName(List<Channel> list, Predicate<Channel> predicate) {
        for (Channel channel : list) {
            if (predicate.test(channel)) {
                System.out.println(channel.toString());
            }
        }
    }

    public static void main(String[] args) {
// void return in example
        Runner runner = new Runner();   // create an object of this class to call our method from

        Process mail = new ProcessMail();     // create object of an interface_implementation class = function
        runner.test(mail);                      //pass this object as interface to the parameter of the method

        Process phone = new ProcessPhone();
        runner.test(phone);

        // with lambda expression

        // Interface functInterfImpl = (no method params)-> "returns nothing"
        Process process = () -> System.out.println("lambda process == Mail");
        runner.test(process);

        process = () -> System.out.println("lambda process == Phone");
        runner.test(process);

        // finally  pass lambda expr directly as interface
        runner.test(() -> System.out.println("process final = ANY"));

//STATIC
        // With a second interface, implement a STATIC  method accepting an interface as param
        // create OBJECT LIST
        List<Channel> channelList = new ArrayList<>(Arrays.asList(new Channel(1, "Global", ChannelType.M),
                new Channel(0, "Inter", ChannelType.E)));
        channelList.add(new Channel(2, "Fast", ChannelType.P));
        channelList.add(Channel.builder().id(3).type(ChannelType.E).name("Connect").build());
        channelList.add(Channel.builder().id(4).type(ChannelType.E).name("Ripple").build());

        printName(channelList, channel -> channel.getType().equals(ChannelType.E) && !channel.getName().equals("Ripple"));

        printName(channelList, channel -> channel.getId() > 3);


        Complete complete = (channel) -> "complete a chanel " + channel.getId() + " " + channel.getType();
        printElectronic(channelList, complete);

        System.out.println("complete.finish(channelList.get(0)) = " + complete.finish(channelList.get(0)));

// Ref to static method
        // doublecolon
        // ex: parse int of Integer looks like Integer::parseInt, or String::length

        Misc getSum = (x, y) -> ProcessMisc.getSum(x, y);
        getSum.miscData(5, 9);

        //double colon
        Misc misc = ProcessMisc::getSum;
        misc.miscData(10, 50);


        // reference to instance method
        Misc misc2 = (x, y) -> new ProcessMisc().getMulti(x, y);
        misc2.miscData(20, 1);

        Misc misc1 = new ProcessMisc()::getMulti;
        misc1.miscData(30, 10);

        ProcessMisc processMisc = new ProcessMisc();
        Misc m3 = processMisc::getMulti;
        m3.miscData(50, 50);


        //JAVA FUNCT INTERFACES

// 3 params. Accept integer and string, return type String
        BiFunction<String, Integer, String> function = (str, i) -> str.substring(i);
        System.out.println(function.apply("Olessya Foxborn", 7));

        //with doublecolon
        BiFunction<String, Integer, String> function1 = String::substring;

        //accept object, return void
//        i -> System.out.println(i);                            Consumer    -    accept()
        Consumer<Integer> consumer = i -> System.out.println(i);
        consumer.accept(10);

        Consumer<Integer> cons = System.out::println;
        cons.accept(33);

        // constructor
        //doesn't accept anything, but returns something ,  ()->new Model();   Supplier   -  get()
        Supplier<Model> supplier = () -> new Model();

        System.out.println("supplier.get().getSize() = " + supplier.get().getSize());
        Supplier<Model> s2 = Model::new;

        //                                                                Function  -  apply()
        Function<String, Model> f1 = name -> new Model(name);
        Model model = f1.apply("New Model name");
        System.out.println("model.getName()"+model.getName());

        Function<String, Model> f2 = Model::new;
       f2.apply("BMW");
        System.out.println("f2 = " +  f2.apply("BMW").getSize());


        //Bifunction takes 2 params, returns object

        BiFunction<String, Integer, Model> biFunction = (name, weight) -> new Model(name, weight);
        Model model1 = biFunction.apply("lexus", 100);
        System.out.println("model1 = " + model1.getWeight() + " "+ model1.getName());

        BiFunction<String, Integer, Model> biFunction2=Model::new;
        Model nissan = biFunction2.apply("nissan", 200);
        System.out.println("model2 = " + nissan.getName()+" "+nissan.getWeight());



    }


}
