import java.util.Scanner;

class UserInterface {
    public String RunOrTrain() {

        //create Scanner obj for human input
        Scanner scan = new Scanner(System.in);

        //ask for input
        System.out.print("Run / Train : ");

        //get the input
        String Answer = scan.nextLine();

        //return
        return Answer;
    }

    public String UserInput() {

        //create Scanner obj for human input
        Scanner scan = new Scanner(System.in);

        //ask for input
        System.out.print("\nEnter your text : ");

        //get the input
        String text = scan.nextLine();

        //return
        return text;
    }

    public static void UserOutput(double[] output) {
        System.out.println("\n...");

        if (output[0] > output[1]) System.out.println("\nyou're a Human");
        else if (output[0] < output[1]) System.out.println("you're an AI");
        else System.out.println("I am not sure");

        System.out.println("\n(you are " + Double.toString(output[0] * 100) + "% a Human and " + Double.toString(output[1] * 100) + "% an AI)"); //skip a line
        //check the value
    }

}
