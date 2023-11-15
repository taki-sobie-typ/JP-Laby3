package threeFour;

public class ApplicationMain {
    public static void main(String[] args){

        HelloMessage helloMessage = new HelloMessage();
        helloMessage.message("WITAJ! Wprowadź swoje imię");
        helloMessage.enterName("Wprowadź swoje imię tutaj!");

        CalculatorFrame calculatorFrame = new CalculatorFrame(helloMessage.getNameEntered());
        calculatorFrame.setFrameVisible(true);

    }
}
