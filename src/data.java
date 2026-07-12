import java.io.*;
import java.util.Arrays;


abstract class Data {
    //create public final variables type int that stores the length of layer in the
    public final int oneHotLength = 10000;
    public final int embeddingLength = 128;
    public final int hiddenLayerLength = 10;
    public final int outputLayerLength = 2;
    public final int hiddenStateLength = 10;

    //other important variables
    public static String weightsFile = "./weights.txt";
    public static String biasesFile = "./biases.txt";
    public static String AiTextFile = "./ai_data.txt";
    public static String HumanTextFile = "./human_data.txt";

    public final int datasetLength = 5000;


    //create a function that is responsible for reading weights
    public double[] ReadWeights() {
        //calculate the amount of weights
        int totalWeights = embeddingLength * oneHotLength
                + hiddenLayerLength * embeddingLength
                + outputLayerLength * hiddenLayerLength
                + hiddenStateLength * hiddenLayerLength;

        //create the variable that is responsible for weights
        double[] weights = new double[totalWeights]; //first layer 10,000 second layer 128 third layer 10 fourth layer (output) 2 and hidden state 10 (10*10 = 100 weights)

        //read the file that stores the weights
        try(BufferedReader weightsFileReader = new BufferedReader(new FileReader(weightsFile))) {
            String weight;

            for (int i = 0; (weight = weightsFileReader.readLine()) != null; i++) {
                weights[i] = Double.parseDouble(weight);
            }
        }
        catch (IOException error) {
            error.printStackTrace();

        }

        return weights;
    }


    //create a function that is responsible for reading biases
    public double[] ReadBiases() {

        //create the variable that is responsible for weights
        double[] biases = new double[140]; //128 + 10 + 2

        //read the file that stores the weights
        try(BufferedReader biasesFileReader = new BufferedReader(new FileReader(biasesFile))) {
            String biases_str;

            for (int i = 0; (biases_str = biasesFileReader.readLine()) != null; i++) {
                biases[i] = Double.parseDouble(biases_str);
            }
        }
        catch (IOException error) {
            error.printStackTrace();

        }

        return biases;
    }


    public double[] Softmax(double[] input) {
        // 1. Find the maximum value in the array to prevent overflow
        double max = Arrays.stream(input).max().orElse(Double.NEGATIVE_INFINITY);

        // 2. Compute the exponentials of the input array (minus the max)
        double[] expValues = Arrays.stream(input)
                .map(x -> Math.exp(x - max))
                .toArray();

        // 3. Sum of all exponentiated values
        double sum = Arrays.stream(expValues).sum();

        // 4. Divide each exponential by the sum to get probabilities
        return Arrays.stream(expValues).map(x -> x / sum).toArray();
    }

    public String[][] GetDataset() {
        //create the Strings that will store the datasey
        String AiDataSetLine;
        String[] AiDataset = new String[datasetLength];

        //read the AI data file
        try (BufferedReader AiDataFileReader = new BufferedReader(new FileReader(AiTextFile))) {
            for (int i = 0; (AiDataSetLine = AiDataFileReader.readLine()) != null; i++) {
                AiDataset[i] = AiDataSetLine.replace("Detailed evaluation parameter sequence-", "");
            }
        }
        catch (IOException error) {
            error.printStackTrace();

        }

        //create the Strings that will store the datasey
        String HumanDataSetLine;
        String[] HumanDataset = new String[datasetLength];

        //read the AI data file
        try (BufferedReader HumanDataFileReader = new BufferedReader(new FileReader(HumanTextFile))) {
            for (int i = 0; (HumanDataSetLine = HumanDataFileReader.readLine()) != null; i++) {
                HumanDataset[i] = HumanDataSetLine.replace("Item reference index ID-", "");
            }
        }
        catch (IOException error) {
            error.printStackTrace();

        }

        String[][] Dataset = {HumanDataset, AiDataset};

        //return dataset
        return Dataset;

    }
    //create public static final int that name
}


