import java.util.ArrayList;
class HiddenLayer extends Layer{
	public ArrayList<HiddenLayer> initLayer(HiddenLayer hiddenLayer, ArrayList<HiddenLayer> listOfHiddenLayer,InputLayer inputlayer, OutputLayer outputLayer){
		setListOfNeurons(hiddenLayer.getListOfNeurons());
		listOfHiddenLayer.add(this);
		return listOfHiddenLayer;
	}
	public static void printLayer(ArrayList<HiddenLayer> listOfHiddenLayer){
		System.out.println("## Hidden Layer ##");
		int y=0;
		for(int i=0; i<listOfHiddenLayer.size();i++){
			HiddenLayer layer=(HiddenLayer) listOfHiddenLayer.get(i);
			ArrayList<Neuron> neuronlist= layer.getListOfNeurons();
			for(int j=0;j<layer.getNumberOfNeuronsInLayer();j++){
				y=j+1;
				System.out.println("Neuron "+y);
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
				System.out.println("Output Weights");
				for (int l=0; l<weightOutList.size();l++){
					y=l+1;
					Double d2=(Double) weightOutList.get(l);
					System.out.print("["+d2+"]");
				}
				System.out.println(" ");
			}
		}
	}
}