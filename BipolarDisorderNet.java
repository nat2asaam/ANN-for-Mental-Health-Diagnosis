import java.util.ArrayList;
class BipolarDisorderNet extends NeuralNet{
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
		
		Neuron inputNeuron4=new Neuron();
		ArrayList<Double> inputWeight4=new ArrayList<Double>();
		inputWeight4.add(new Double(Math.random()));
		inputNeuron4.setListOfWeightIn(inputWeight4);
		listOfInputNeurons.add(inputNeuron4);
		inputLayer.setListOfNeurons(listOfInputNeurons);
		
		Neuron inputNeuron5=new Neuron();
		ArrayList<Double> inputWeight5=new ArrayList<Double>();
		inputWeight5.add(new Double(Math.random()));
		inputNeuron5.setListOfWeightIn(inputWeight5);
		listOfInputNeurons.add(inputNeuron5);
		inputLayer.setListOfNeurons(listOfInputNeurons);
		
		Neuron inputNeuron6=new Neuron();
		ArrayList<Double> inputWeight6=new ArrayList<Double>();
		inputWeight6.add(new Double(Math.random()));
		inputNeuron6.setListOfWeightIn(inputWeight6);
		listOfInputNeurons.add(inputNeuron6);
		inputLayer.setListOfNeurons(listOfInputNeurons);
		
		Neuron inputNeuron7=new Neuron();
		ArrayList<Double> inputWeight7=new ArrayList<Double>();
		inputWeight7.add(new Double(Math.random()));
		inputNeuron7.setListOfWeightIn(inputWeight7);
		listOfInputNeurons.add(inputNeuron7);
		inputLayer.setListOfNeurons(listOfInputNeurons);
		
		Neuron inputNeuron8=new Neuron();
		ArrayList<Double> inputWeight8=new ArrayList<Double>();
		inputWeight8.add(new Double(Math.random()));
		inputNeuron8.setListOfWeightIn(inputWeight8);
		listOfInputNeurons.add(inputNeuron8);
		inputLayer.setListOfNeurons(listOfInputNeurons);
		
		this.setInputLayer(inputLayer);
		
		/* Output Layer */
		outputLayer=new OutputLayer();
		ArrayList<Neuron> listOfOutputNeurons=new ArrayList<Neuron>();
		Neuron outputNeuron1=new Neuron();
		ArrayList<Double> outWeight=new ArrayList<Double>();
		outWeight.add(new Double(Math.random()));
		outputNeuron1.setListOfWeightOut(outWeight);
		listOfOutputNeurons.add(outputNeuron1);
		outputLayer.setListOfNeurons(listOfOutputNeurons);
	}
	public void initPerceptronNet(){
		this.initNet();
	}
	public void initAdalineNet(){
		this.initNet();
	}
}