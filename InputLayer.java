import java.util.ArrayList;
class InputLayer extends Layer{
	public void initLayer(InputLayer inputLayer){
		setListOfNeurons(inputLayer.getListOfNeurons());
	}
	public void setNumberOfNeuronsInLayer(int numberOfNeuronsInLayer){
		setNumberOfNeuronsInLayer(numberOfNeuronsInLayer);
	}
	public static void printLayer(InputLayer inputLayer){
		System.out.println("## Input Layer ##");
		ArrayList<Neuron> neuronlist= inputLayer.getListOfNeurons();
		int y=0;
		for(int j=0;j<neuronlist.size();j++){
			y=j+1;
			System.out.println("Neuron "+(y));
			Neuron neuron =(Neuron) neuronlist.get(j);
			ArrayList<Double> weightInList=neuron.getListOfWeightIn();
			ArrayList<Double> weightOutList=neuron.getListOfWeightOut();
			System.out.println("Input Weights");
			for(int k=0;k<weightInList.size();k++){
				y=k+1;
				Double d1=(Double) weightInList.get(k);
				System.out.print("["+d1+"]");
			}
			System.out.println(" ");
		
		}
	}
}