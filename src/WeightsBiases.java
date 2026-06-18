import java.io.*;

abstract class WeightsAndBiases {
    public static String weightsFile = "./weights.txt";

    //create a function that is responsible for reading weights
    public double[] readWeights() {

        //create the variable that is responsible for weights
        double[] weights = new double[1281260]; //first layer 10,000 second layer 128 third layer 10 fourth layer (output) 2

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
}
