import java.util.ArrayList;
class Perceptron extends Training{
	public void print(NeuralNet n){
		int rows=n.getTrainSet().length;
		int cols=n.getTrainSet()[0].length;
		double[]realOutput=n.getRealOutputSet();
		ArrayList <Double> inputWeightIn=new ArrayList<Double> ();
		for(int i=0;i<rows;i++){
			double netValue=0;
			InputLayer inputL=n.getInputLayer();
			ArrayList<Neuron> listOfNeurons=inputL.getListOfNeurons();
			for(int j=0;j<cols;j++){
				System.out.print(n.getTrainSet()[i][j]+" ");
				Neuron neuron=(Neuron)listOfNeurons.get(j);
				inputWeightIn=neuron.getListOfWeightIn();
				double inputWeight =inputWeightIn.get(0);
				netValue=netValue+inputWeight*n.getTrainSet()[i][j];
			}
			
			double estimatedOutput=this.activationFnc(n.getActivationFnc(),netValue);
			System.out.print(" Net Output:"+estimatedOutput);
			double error=realOutput[i]-estimatedOutput;
			System.out.print(" Real Output:"+n.getRealOutputSet()[i]);
			System.out.print(" Error:"+error);
			System.out.println(" ");
			
		}
	}
	
}