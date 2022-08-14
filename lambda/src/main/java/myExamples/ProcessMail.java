package myExamples;

public class ProcessMail implements Process, Complete{

    @Override
   public void start(){
        System.out.println("Start Processing Mail");
        System.out.println("+++++++++++++++++++++++");
    }

    @Override
    public String finish(Channel channel) {
        return null;
    }
}
