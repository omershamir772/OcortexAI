class NeuralNetwork {
    public void DeepLearning() {

        //create an object
        UserInterface user = new UserInterface();

        //check if the user wants to run or train the model
        String runOrTrain = user.RunOrTrain();

        if (runOrTrain.equals("r") ||runOrTrain.equals("run")) {
            //create an object
            ForwardPropagation FP = new ForwardPropagation();

            //get the input
            String text = FP.forwardPropagationInput();

            //calculate the output
            ForwardPropagationCache result = FP.ForwardPropagationCalculation(text);

            //print output
            UserInterface.UserOutput(result.output);
        }

        if (runOrTrain.equals("t")|| runOrTrain.equals("train")) {
            //create an object
            BackPropagation BP = new BackPropagation();

            //calculate the gradient of the weight
            BP.BackPropagationCalculation();
        }

    }

}
