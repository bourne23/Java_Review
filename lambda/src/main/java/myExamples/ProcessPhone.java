package myExamples;

public class ProcessPhone implements Process, Complete{

    @Override
    public void start(){
        System.out.println("Start Processing Phone ");
        System.out.println("------------------------");
    }

    @Override
    public String finish(Channel channel) {
        return "Done" + channel.getName()
                ;
    }
}
