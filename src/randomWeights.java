import java.util.Random;

abstract class randomWeights {

    //create an array that is responsible
    protected double[] WeightBatchDouble;

    public void createRandomWeights(int amount) {
        //create a class object that will be used to generate random weights
        Random randomWeights = new Random();

        //declare the length of the array
        this.WeightBatchDouble = new double[amount];

        
        for (int i = 0; i < amount; i++) {
            WeightBatchDouble[i] = randomWeights.nextDouble();
        }

    }
}
