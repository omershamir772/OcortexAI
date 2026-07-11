import java.util.Scanner;

class userInterface {
    public String userInput() {

        //create Scanner obj for human input
        Scanner scan = new Scanner(System.in);

        //ask for input
        System.out.println("enter your text : ");

        //get the input
        String text = scan.nextLine();

        //return
        return text;
    }

    public static void userOutput(double[] output) {
        System.out.print("\n...\nyou are " + Double.toString(output[0] * 100) + "% a Human and " + Double.toString(output[1] * 100) + "% an AI");
        System.out.println(); //skip a line
        //check the value
        if (output[0] > output[1]) System.out.println("you're a Human");
        else if (output[0] < output[1]) System.out.println("you're an AI");
        else System.out.println("I am not sure");
    }

}
