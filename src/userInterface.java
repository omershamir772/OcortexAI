import java.util.Scanner;

class userInterface {
    public String userInput() {

        //create Scanner obj for human input
        Scanner scan = new Scanner(System.in);

        //ask for input
        System.out.println("enter your text : ");

        //get the input
        String text = scan.next();

        //return
        return text;
    }
}
