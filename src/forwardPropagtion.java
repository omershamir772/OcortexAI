import java.util.Arrays;

class forwardPropagation extends WeightsAndBiases {

    //create the function that is responsible for getting and managing the input
    public String forwardPropagationInput() {
        //create a private string that store text
        String text;

        //get userInterface object
        userInterface user = new userInterface();

        //get text
        text = user.userInput();

        //return text
        return text;

        }

    //create the function that is responsible for creating the oneHot
    public int[] oneHotFiller(int wordIndex) {
        int[] oneHot = new int[10000];
        oneHot[wordIndex] = 1;

        //return
        return oneHot;

    }


    //create the function that is responsible for the calculation of the forward propagation
    public void forwardPropagationCalculation(String text) {

        //create an object for the encoder class
        encoder encoderObj = new encoder();

        //read the weights
        double[] weights = readWeights();

        //read the oneHot
        String[] oneHotStr = encoderObj.getOneHot();


        //get embedding
        int[] oneHotWords = encoderObj.SearchOneHot(text, oneHotStr);


        //create a for loop that is responsible for the RNN neural network
        for (int i = 0; i < oneHotWords.length; i++) {

            int[] oneHot = oneHotFiller(oneHotWords[i]);

            //calculate the embedding
            double[] embedding = embeddingCalculation(oneHot, weights);



        }
    }

    //create the function that is responsible for the calculation of the embedding
    public double[] embeddingCalculation(int[] oneHot, double[] weights) {
        //create the embedding variable
        double[] embedding = new double[128];


        for (int i = 0; i <= embedding.length - 1; i++) {
            for (int k = 0; k <= 10000 - 1; k++) {
                embedding[i] = embedding[i] + oneHot[k] * weights[i * 10000 + k];
            }
            //add bias
            embedding[i] = embedding[i] + 0;
        }
    System.out.println(Arrays.toString(embedding));
    //return embedding
    return embedding;

    }

    //create another function that is responsible for the calculation of the hidden layer
    //void hiddenLayerCalculation(double[embedding], ) {

    //}


}





