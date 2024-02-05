import java.util.ArrayList;
class Layer{
	private ArrayList<Neuron> listOfNeurons;
	private int numberOfNeuronsInLayer;
	public ArrayList<Neuron> getListOfNeurons(){
		return listOfNeurons;
	}
	public void setListOfNeurons(ArrayList<Neuron> listOfNeurons){
		this.listOfNeurons=listOfNeurons;
	}
	public int getNumberOfNeuronsInLayer(){
		return numberOfNeuronsInLayer;
	}
	public void setNumberOfNeuronsInLayer(int numberOfNeuronsInLayer){
		this.numberOfNeuronsInLayer=numberOfNeuronsInLayer;
	}
}