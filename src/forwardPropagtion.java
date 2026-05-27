import java.util.Arrays;

class forwardPropagation extends WeightsAndBiases {

    //create a public static string that store text
    public static String text;
    
    //create the function that is responsible for getting and managing the input
    public void forwardPropagationInput(boolean is_training) {

        //checking if is_training is false
        if (!is_training) {
            //get userInterface object
            userInterface user = new userInterface();

            //get text
            text = user.userInput();

        }



    }
    //create the function that is responsible for the calculation of the matrix
    public void forwardPropagationCalculation() {
        double[] weights = readWeights();

    }
}
