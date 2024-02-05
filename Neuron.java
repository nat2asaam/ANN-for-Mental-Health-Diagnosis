import java.util.ArrayList;
class Neuron{
	private ArrayList<Double> listOfWeigthIn;
	private ArrayList<Double> listOfWeigthOut;
	public double initNeuron(){
		return 0.0;
	}
	public void setListOfWeightIn(ArrayList<Double> listOfWeigthIn){
		this.listOfWeigthIn=listOfWeigthIn;
	}
	public void setListOfWeightOut(ArrayList<Double> listOfWeigthOut){
		this.listOfWeigthOut=listOfWeigthOut;
	}
	public ArrayList<Double> getListOfWeightIn(){
		return listOfWeigthIn;
	}
	public ArrayList<Double> getListOfWeightOut(){
		return listOfWeigthOut;
	}
}