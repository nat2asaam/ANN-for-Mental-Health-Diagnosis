import java.util.ArrayList;
class Training{
	private int epochs=0;
	private double error;
	private double mse;
	public enum TrainingTypesENUM{
		PERCEPTRON,ADALINE
	}
	public enum ActivationFncENUM{
		STEP,LINEAR,SIGLOG,HYPERTAN
	}
	public int getEpochs(){
		return epochs;
	}
	public void setError(double error){
		this.error=error;
	}
	public double getError(){
		return error;
	}
	private double fncStep(double value){
		if(value<1){
			return 0.0;
		}
		else if(value>=1){
			return 1.0;
		}
		else{
			throw new IllegalArgumentException(value+" does not have any return value");
		}
	}
	private double fncLinear(double value){
		 return value-1;
	}
	private double fncSigLog(double value){
		return (1/(1+Math.pow(Math.E,-value)));
	}
	private double fncHyperTan(double value){
		double numerator=1-Math.pow(Math.E,-value);
		double denominator=1+Math.pow(Math.E,-value);
		return numerator/denominator;
	}
	private double fncStepDeriv(double value){
		if(value<1){
			return 0.0;
		}
		else if(value>=1){
			return 1.0;
		}
		else{
			throw new IllegalArgumentException(value+" does not have any return value");
		}
	}
	private double fncLinearDeriv(double value){
		 return value;
	}
	private double fncSigLogDeriv(double value){
		return (this.fncSigLog(value)*this.fncSigLog(1-value));
	}
	private double fncHyperTanDeriv(double value){
		return (1-Math.pow(this.fncHyperTan(value),2));
	}
	public double activationFnc(ActivationFncENUM fnc,double value){
		switch(fnc){
			case STEP:
				return this.fncStep(value);
			case LINEAR:
				return this.fncLinear(value);
			case SIGLOG:
				return fncSigLog(value);
			case HYPERTAN:
				return this.fncHyperTan(value);
			default:
				throw new IllegalArgumentException(fnc+"does not exist in ActivationFncENUM");
			
		}
	}
	public double derivativeActivationFnc(ActivationFncENUM fnc,double value){
				switch(fnc){
			case STEP:
				return this.fncStepDeriv(value);
			case LINEAR:
				return this.fncLinearDeriv(value);
			case SIGLOG:
				return this.fncSigLogDeriv(value);
			case HYPERTAN:
				return this.fncHyperTanDeriv(value);
			default:
				throw new IllegalArgumentException(fnc+"does not exist in ActivationFncENUM");
			
		}
	}
	public ArrayList<Neuron> teachNeuronsOfLayer(int cols,int i,NeuralNet n,double netValue){
		ArrayList <Double> inputWeightIn=new ArrayList<Double> ();
		InputLayer inputL=n.getInputLayer();
		ArrayList<Neuron> listOfNeurons=inputL.getListOfNeurons();
		ArrayList<Neuron> listOfNewNeurons=new ArrayList<Neuron>();
		for(int j=0;j<cols;j++){
			Neuron neuron=(Neuron)listOfNeurons.get(j);
			inputWeightIn=neuron.getListOfWeightIn();
			double inputWeight =inputWeightIn.get(0);
			double newInputWeight=this.calcNewWeight( n.getTrainType(), inputWeight, n, n.getTargetError(), n.getTrainSet()[i][j], netValue);
			inputWeightIn.set(0,newInputWeight);
			neuron.setListOfWeightIn(inputWeightIn);
			listOfNewNeurons.add(neuron);
		}		
		return listOfNewNeurons;
	}
	public double calcNewWeight(TrainingTypesENUM trainType,double inputWeightOld, NeuralNet n,double error,double trainsample,double netValue){
		switch(trainType){
			case PERCEPTRON:
				return inputWeightOld + n.getLearningRate() * error* trainsample;
			case ADALINE:
				return inputWeightOld + n.getLearningRate() * error* derivativeActivationFnc(n.getActivationFnc(),netValue);
			default:
				throw new IllegalArgumentException(trainType+"does not exist in TrainingTypesENUM");
		}
	}
	public void setMse(double mse){
		this.mse=mse;
	}
	public double getMse(){
		return mse;
	}
	public void setEpochs(int epochs){
		this.epochs=epochs;
	}
	public NeuralNet trainNet(NeuralNet n){
				ArrayList <Double> inputWeightIn=new ArrayList<Double> ();
		int rows=n.getTrainSet().length;
		int cols=n.getTrainSet()[0].length;
		while (this.getEpochs()<n.getMaxEpochs()){
			double estimatedOutput=0.0;
			double realOutput=0.0;
			for (int i=0;i<rows;i++){
				double netValue=0.0;
				InputLayer inputL=n.getInputLayer();
				ArrayList<Neuron> listOfNeurons=inputL.getListOfNeurons();
				int numberOfNeurons=listOfNeurons.size();
				for(int j=0;j<cols;j++){
					Neuron neuron=(Neuron)listOfNeurons.get(j);
					inputWeightIn=neuron.getListOfWeightIn();
					double inputWeight =inputWeightIn.get(0);
					netValue=netValue+inputWeight*n.getTrainSet()[i][j];
				}
				estimatedOutput=this.activationFnc(n.getActivationFnc(),netValue);
				realOutput=n.getRealOutputSet()[i];
				TrainingTypesENUM trainType=n.getTrainType();
				switch(trainType){
					case PERCEPTRON:
						this.setError(realOutput-estimatedOutput);
					case ADALINE:
						this.setError(Math.pow(estimatedOutput-realOutput,2));
				}
				if(Math.abs(this.getError())> n.getTargetError()){
					InputLayer inputLayer=new InputLayer();
					inputLayer.setListOfNeurons(this.teachNeuronsOfLayer(cols,i,n,netValue));
					n.setInputLayer(inputLayer);		
				}
			}
			this.setMse(Math.pow(realOutput-estimatedOutput,2.0));
			n.getListOfMSE().add(this.getMse());
			this.setEpochs(this.getEpochs()+1);
		}
		n.setTrainingError(this.getError());
		return n;
	}
}