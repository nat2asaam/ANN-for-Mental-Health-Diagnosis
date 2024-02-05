import java.util.ArrayList;
class NeuralNet{
	protected InputLayer inputLayer;
	protected OutputLayer outputLayer;
	private double[][] trainSet;
	private double[] realOutputSet;
	private int maxEpochs;
	private double learningRate;
	private double targetError;
	private double trainingError;

	private Training.TrainingTypesENUM trainType;
	private Training.ActivationFncENUM activationFnc;
	private ArrayList<Double> listOfMSE=new ArrayList<Double>();
	
	private Training trainingAlgorithm;
	public  void printTrainedNetResult(NeuralNet n){
		
	}
	public void setTrainSet(double[][] trainSet){
		this.trainSet=trainSet;
	}
	public double[][] getTrainSet(){
		return trainSet;
	}
	public InputLayer getInputLayer(){
		return inputLayer;
	}
	
	public double[] getRealOutputSet(){
		return realOutputSet;
	}
	public void setRealOutputSet(double []realOutputSet){
		this.realOutputSet=realOutputSet;
	}
	public int getMaxEpochs(){
		return maxEpochs;
	}
	public void setMaxEpochs(int maxEpochs){
		this.maxEpochs=maxEpochs;
	}
	public void setTargetError(double targetError){
		this.targetError=targetError;
	}
	public double getTargetError(){
		return targetError;
	}
	public void setTrainingError(double trainingError){
		this.trainingError=trainingError;
	}
	public double getTrainingError(){
		return trainingError;
	}
	public double getLearningRate(){
		return learningRate;
	}
	public void setActivationFnc(Training.ActivationFncENUM activationFnc){
		this.activationFnc=activationFnc;
	}
	public Training.ActivationFncENUM getActivationFnc(){
		return activationFnc;
	}
	public void setTrainType(Training.TrainingTypesENUM trainType){
		this.trainType=trainType;
	}
	public Training.TrainingTypesENUM getTrainType(){
		return trainType;
	}
	
	public void setLearningRate(double learningRate){
		this.learningRate=learningRate;
	}
	public void setInputLayer(InputLayer inputLayer){
		this.inputLayer=inputLayer;
	}
	public void setListOfMSE(ArrayList<Double> listOfMSE){
		this.listOfMSE=listOfMSE;
	}
	public ArrayList<Double> getListOfMSE(){
		return listOfMSE;
	}
	public Training getTrainingAlgorithm(){
		return trainingAlgorithm;
	}
	public void setTrainingAlgorithm(Training trainingAlgorithm){
		this.trainingAlgorithm=trainingAlgorithm;
	}
	public NeuralNet trainNet(NeuralNet n){
		Training.TrainingTypesENUM trainType=n.getTrainType();
		Training.ActivationFncENUM activationFnc=n.getActivationFnc();
		double resultOfActivationFnc;
		switch(trainType){
			case PERCEPTRON:
				 this.setTrainingAlgorithm( new Perceptron());
				n=trainingAlgorithm.trainNet(n);
			break;
			case ADALINE:
				this.setTrainingAlgorithm( new Adaline());
				n=trainingAlgorithm.trainNet(n);
			break;
			default:
				throw new IllegalArgumentException(trainType+"does not exist in TrainingTypesENUM");
		}
		return n;
	}
	public void printTrainedNet(NeuralNet n){
		
	}
	public void initAdalineNet(){
		/* Input layer */
		inputLayer=new InputLayer();
		ArrayList<Neuron> listOfInputNeurons=new ArrayList<Neuron>();
		
		Neuron inputNeuron1=new Neuron();
		ArrayList<Double> inputWeight=new ArrayList<Double>();
		inputWeight.add(new Double(Math.random()));
		inputNeuron1.setListOfWeightIn(inputWeight);
		listOfInputNeurons.add(inputNeuron1);
		inputLayer.setListOfNeurons(listOfInputNeurons);
		
		Neuron inputNeuron2=new Neuron();
		ArrayList<Double> inputWeight2=new ArrayList<Double>();
		inputWeight2.add(new Double(Math.random()));
		inputNeuron2.setListOfWeightIn(inputWeight2);
		listOfInputNeurons.add(inputNeuron2);
		inputLayer.setListOfNeurons(listOfInputNeurons);

		Neuron inputNeuron3=new Neuron();
		ArrayList<Double> inputWeight3=new ArrayList<Double>();
		inputWeight3.add(new Double(Math.random()));
		inputNeuron3.setListOfWeightIn(inputWeight3);
		listOfInputNeurons.add(inputNeuron3);
		inputLayer.setListOfNeurons(listOfInputNeurons);
		
		Neuron inputNeuron4=new Neuron();
		ArrayList<Double> inputWeight4=new ArrayList<Double>();
		inputWeight4.add(new Double(Math.random()));
		inputNeuron4.setListOfWeightIn(inputWeight4);
		listOfInputNeurons.add(inputNeuron4);
		inputLayer.setListOfNeurons(listOfInputNeurons);

		this.setInputLayer(inputLayer);
		
		/* Output Layer */
		outputLayer=new OutputLayer();
		ArrayList<Neuron> listOfOutputNeurons=new ArrayList<Neuron>();
		Neuron outputNeuron1=new Neuron();
		ArrayList<Double> outWeight4=new ArrayList<Double>();
		outWeight4.add(new Double(Math.random()));
		outputNeuron1.setListOfWeightOut(outWeight4);
		listOfOutputNeurons.add(outputNeuron1);
		outputLayer.setListOfNeurons(listOfOutputNeurons);
	}
	public void initNet(){
		/* Input layer */
		inputLayer=new InputLayer();
		ArrayList<Neuron> listOfInputNeurons=new ArrayList<Neuron>();
		
		Neuron inputNeuron1=new Neuron();
		ArrayList<Double> inputWeight=new ArrayList<Double>();
		inputWeight.add(new Double(Math.random()));
		inputNeuron1.setListOfWeightIn(inputWeight);
		listOfInputNeurons.add(inputNeuron1);
		inputLayer.setListOfNeurons(listOfInputNeurons);
		
		Neuron inputNeuron2=new Neuron();
		ArrayList<Double> inputWeight2=new ArrayList<Double>();
		inputWeight2.add(new Double(Math.random()));
		inputNeuron2.setListOfWeightIn(inputWeight2);
		listOfInputNeurons.add(inputNeuron2);
		inputLayer.setListOfNeurons(listOfInputNeurons);

		Neuron inputNeuron3=new Neuron();
		ArrayList<Double> inputWeight3=new ArrayList<Double>();
		inputWeight3.add(new Double(Math.random()));
		inputNeuron3.setListOfWeightIn(inputWeight3);
		listOfInputNeurons.add(inputNeuron3);
		inputLayer.setListOfNeurons(listOfInputNeurons);

		this.setInputLayer(inputLayer);
		
		/* Output Layer */
		outputLayer=new OutputLayer();
		ArrayList<Neuron> listOfOutputNeurons=new ArrayList<Neuron>();
		Neuron outputNeuron1=new Neuron();
		ArrayList<Double> outWeight4=new ArrayList<Double>();
		outWeight4.add(new Double(Math.random()));
		outputNeuron1.setListOfWeightOut(outWeight4);
		listOfOutputNeurons.add(outputNeuron1);
		outputLayer.setListOfNeurons(listOfOutputNeurons);
	}
	public void printNet(NeuralNet n){
		InputLayer.printLayer(inputLayer);
		System.out.println("");
		OutputLayer.printLayer(outputLayer);
		
	}
}