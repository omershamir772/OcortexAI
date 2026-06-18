class neuralNetwork {
    public void DeepLearning() {
        forwardPropagation fn1 = new forwardPropagation();
        String text = fn1.forwardPropagationInput();
        fn1.forwardPropagationCalculation(text);
    }

}
