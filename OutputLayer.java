import java.util.ArrayList;
class OutputLayer extends Layer{
	public OutputLayer initLayer(OutputLayer outputLayer){
		setListOfNeurons(outputLayer.getListOfNeurons());
		return outputLayer;
	}
	public static void printLayer(OutputLayer outputLayer){
		System.out.println("## Output Layer ##");
		ArrayList<Neuron> neuronlist= outputLayer.getListOfNeurons();
		int y=0;
		for(int j=0;j<neuronlist.size();j++){
			y=j+1;
			System.out.println("Neuron "+y);
			Neuron neuron =(Neuron) neuronlist.get(j);
			//ArrayList<Double> weightInList=neuron.getListOfWeightIn();
			ArrayList<Double> weightOutList=neuron.getListOfWeightOut();
			/*
			System.out.println("Input Weights");
			for(int k=0;k<weightInList.size();k++){
				y=k+1;
				Double d1=(Double) weightInList.get(k);
				System.out.println("Weight "+y);
				System.out.println(d1);
			}*/
			System.out.println("Output Weights");
			for (int l=0; l<weightOutList.size();l++){
					y=l+1;
					Double d2=(Double) weightOutList.get(l);
					//System.out.println("Weight "+y);
					System.out.print("["+d2+"]");
			}
			System.out.println(" ");
		}
	}
}