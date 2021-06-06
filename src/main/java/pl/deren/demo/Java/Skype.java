package pl.deren.demo.Java;

public class Skype implements Reply{
    @Override
    public void getCall() {
        System.out.println("Answer or decline the call");
    }

    @Override
    public void getMessage() {
        System.out.println("You have message");
    }
}
