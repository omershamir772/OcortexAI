import java.util.HashMap;

//create a class that its object is used to return all of the layers parameters to use as input for the backPropagation's errorCalculation function
class ForwardPropagationCache {
    public double[] embedding;
    public double[][] hiddenLayer;
    public double[] output;
    public int[] oneHotWords;

    public ForwardPropagationCache(double[] embedding, double[][] hiddenLayer, double[] output, int[] oneHotWords) {
        this.embedding = embedding;
        this.hiddenLayer = hiddenLayer;
        this.output = output;
        this.oneHotWords = oneHotWords;
    }

}

public class ForwardPropagation extends Data {
    //read the weights
    private double[] weights = ReadWeights();

    //read the biases
    private double[] biases = ReadBiases();

    //create the function that is responsible for getting and managing the input
    public String forwardPropagationInput() {
        //create a private string that store text
        String text;

        //get userInterface object
        UserInterface user = new UserInterface();

        //get text
        text = user.UserInput();

        //return text
        return text;

    }

    //create the function that is responsible for creating the oneHot
    public int[] OneHotFiller(int wordIndex) {
        int[] oneHot = new int[oneHotLength];
        oneHot[wordIndex] = 1;

        //return
        return oneHot;

    }


    //create the function that is responsible for the calculation of the forward propagation
    public ForwardPropagationCache ForwardPropagationCalculation(String text) {

        //create an object for the encoder class
        Encoder encoderObj = new Encoder();

        //read the oneHot
        HashMap<String, Integer> oneHotStr = encoderObj.getOneHot();


        //get embedding
        int[] oneHotWords = encoderObj.SearchOneHot(text, oneHotStr);

        //the arrays are 2d because they store all previous versions of the layers

        //create the embedding array
        double[] embedding = new double[embeddingLength];

        //create the hidden layer double 2d array
        double[][] hiddenLayer = new double[oneHotWords.length][hiddenLayerLength];

        //create the output layer double array
        double[] output = new double[outputLayerLength];

        //create a for loop that is responsible for the RNN neural network
        for (int i = 0; i < oneHotWords.length; i++) {

            int[] oneHot = OneHotFiller(oneHotWords[i]);

            //calculate the embedding
            embedding = EmbeddingCalculation(oneHot[i], weights, biases);

            //calculate the raw hiddenLayer
            hiddenLayer[i] = HiddenLayersCalculation(embedding, weights, biases);

            double[] hiddenLayerPast = new double[hiddenLayerLength];

            if (i > 0) {
                hiddenLayerPast = hiddenLayer[i - 1];
            }

            //run the hiddenState function
            hiddenLayer[i] = HiddenState(hiddenLayerPast, hiddenLayer[i], weights, biases);

            if (i == oneHotWords.length - 1) {
                //calculate the output layer
                double[] outputLayer = OutputLayersCalculation(embedding, hiddenLayer[i], weights, biases);

                //normalize the output layer
                output = Softmax(outputLayer);
            }

        }

        return new ForwardPropagationCache(embedding, hiddenLayer, output, oneHotWords);
    }


    //create the function that is responsible for the calculation of the embedding
    public double[] EmbeddingCalculation(int oneHot, double[] weights, double[] biases) {
        //create the embedding variable
        double[] embedding = new double[embeddingLength];


        for (int i = 0; i <= embeddingLength - 1; i++) {
            embedding[i] = weights[i * oneHotLength + oneHot] + biases[i];
        }

        //return embedding
        return embedding;

    }

    //create another function that is responsible for the calculation of the hidden layers


    public double[] HiddenLayersCalculation(double[] embedding, double[] weights, double[] biases) {
        double[] hiddenLayer = new double[hiddenLayerLength];

        int embeddingMatrixSize = embeddingLength * oneHotLength;

        for (int i = 0; i <= hiddenLayerLength - 1; i++) {
            for (int k = 0; k <= embeddingLength - 1; k++) {
                hiddenLayer[i] = hiddenLayer[i] + embedding[k] * weights[embeddingMatrixSize + i * embeddingLength + k];
            }


        }


        //return the hiddenLayer
        return hiddenLayer;
    }

    //create the function that calculate the output layer
    public double[] OutputLayersCalculation(double[] embedding, double[] hiddenLayer ,double[] weights, double[] biases) {

        double[] outputLayer = new double[outputLayerLength];

        int hiddenLayerMatrixSize = embeddingLength * oneHotLength + hiddenLayerLength * embeddingLength;

        for (int i = 0; i <= outputLayerLength - 1; i++) {
            for (int k = 0; k <= hiddenLayerLength - 1; k++) {
                outputLayer[i] = outputLayer[i] + hiddenLayer[k] * weights[hiddenLayerMatrixSize + i * hiddenLayerLength + k];
            }

            //add biases
            outputLayer[i] = outputLayer[i] + biases[embeddingLength + hiddenLayerLength + i];
        }



        //return the outputLayer
        return outputLayer;
    }

    public double[] HiddenState(double[] hiddenLayerPast, double[] hiddenLayerNow ,double[] weights, double[] biases) {

        int hiddenStateMatrixSize = embeddingLength * oneHotLength + hiddenLayerLength * embeddingLength + outputLayerLength * hiddenLayerLength;

        //create a new double array that stores the hiddenState layer values
        double[] hiddenState = new double[hiddenStateLength];

        for (int i = 0; i <= hiddenStateLength - 1; i++) {
            for (int k = 0; k <= hiddenLayerLength - 1; k++) {
                hiddenState[i] = hiddenState[i] + hiddenLayerPast[k] * weights[hiddenStateMatrixSize + i * hiddenStateLength + k];
            }
            //make hidden state
            hiddenState[i] = hiddenState[i] + hiddenLayerNow[i];

            //add biases
            hiddenState[i] = hiddenState[i] + biases[embeddingLength + i];

            //normalize it with ReLU
            if (hiddenState[i] < 0) {
                hiddenState[i] = 0;
            }


        }

        return hiddenState;

    }


}







