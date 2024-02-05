import java.util.Scanner;
public class MentalHealthANNTest{
	static Scanner sc=new Scanner(System.in);
	public static void main(String args[]){
		System.out.println("Welcome to the Artificial Neural Networks based Mental Health Diagnosis");
		System.out.println(" ");
		System.out.println("To test the Artificial Neural Network for Bipolar Disoder Diagnosis enter 1");
		System.out.println("To test the Artificial Neural Network for Schizophrenia Diagnosis enter 2");
		System.out.println(" ");
		System.out.print("Enter any other number to exit the system:  ");
		int input=0;
		input= sc.nextInt();
		switch(input){
			case 1:
				System.out.println("----------Bipolar Disorder Artificial Neural Network----------");
				trainBipolarDisorderNet();
				break;
			case 2:
				System.out.println("----------Schizophrenia Artificial Neural Network----------");
				trainSchizophreniaNet();
				
				break;
			default:
				System.exit(1);
		}
	}
	
	public static void trainBipolarDisorderNet(){
		BipolarDisorderNet testNet1= new BipolarDisorderNet();
		BipolarDisorderNet trainedNet1 =new BipolarDisorderNet();
		testNet1.setMaxEpochs(50);
		testNet1.setTargetError(0.002);
		testNet1.setLearningRate(0.6);
		System.out.print("Enter 1 for Training using Perceptron algorithms or 2 for Training using Adaline ");
		System.out.println(" ");
		System.out.println("Enter any other number to exit the system: ");
		int input= sc.nextInt();
		switch(input){
			case 1:
				/*	First column has bais
					Remaining columns are for the various symptoms with 0 meaning symptom is not exhibited and 1 meaning symptom exhibited. The symptoms are:
					Feeling overly happy or high
					Having a decreased need for sleep
					Talking fast
					Feeling extremely restless or impulsive
					Being easily distracted
					Having over confidence in your abilities
					Engaging in risky activities
				*/
				testNet1.setTrainSet(new double[][]{
					{1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},{1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0},
					{1.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0},{1.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0},
					{1.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0},{1.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0},
					{1.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0},{1.0,1.0,1.0,0.0,0.0,0.0,0.0,1.0},
					{1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0},{1.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0},
					{1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0},{1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0},
					{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0}
				});
				testNet1.setRealOutputSet(new double[]{0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0});
				testNet1.initPerceptronNet();
				System.out.println("----------PERCEPTRON INIT NET----------");
				testNet1.printNet(testNet1);
				testNet1.setTrainType(Training.TrainingTypesENUM.PERCEPTRON);
				testNet1.setActivationFnc(Training.ActivationFncENUM.STEP);
				trainedNet1=(BipolarDisorderNet)testNet1.trainNet(testNet1);
				System.out.println(" ");
				System.out.println("----------PERCEPTRON TRAINED NET----------");
				testNet1.printNet(trainedNet1);
				System.out.println("----------PERCEPTRON PRINT RESULT----------");
				Perceptron p1=(Perceptron)trainedNet1.getTrainingAlgorithm();
				p1.print(trainedNet1);
				break;
			case 2:
				//first column has bais
					testNet1.setTrainSet(new double[][]{
					{1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},{1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0},
					{1.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0},{1.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0},
					{1.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0},{1.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0},
					{1.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0},{1.0,1.0,1.0,0.0,0.0,0.0,0.0,1.0},
					{1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0},{1.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0},
					{1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0},{1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0},
					{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0}
				});
				testNet1.setRealOutputSet(new double[]{0.000,0.143,0.143,0.143,0.143,0.143,0.143,0.286,0.429,0.571,0.714,0.857,1.000});
				testNet1.initAdalineNet();
				System.out.println("----------ADALINE INIT NET----------");
				testNet1.printNet(testNet1);
				testNet1.setTrainType(Training.TrainingTypesENUM.ADALINE);
				System.out.println("Enter 1 to use Linear Activation Function or 2 for Sigmoid Logistic Activation Function");
				System.out.print("or 3 for Hyperbolic Tangent Activation Function");
				System.out.println(" ");
				System.out.println("Enter any other number to exit the system: ");
				input= sc.nextInt();
				switch(input){
					case 1:
						testNet1.setActivationFnc(Training.ActivationFncENUM.LINEAR);
						trainedNet1=(BipolarDisorderNet)testNet1.trainNet(testNet1);
						System.out.print("---------Linear Activation Function----------");
						break;
					case 2:
						testNet1.setActivationFnc(Training.ActivationFncENUM.SIGLOG);
						trainedNet1=(BipolarDisorderNet)testNet1.trainNet(testNet1);
						System.out.print("---------SIGMOID LOGISTIC Activation Function----------");
						break;
					case 3:
						testNet1.setActivationFnc(Training.ActivationFncENUM.HYPERTAN);
						trainedNet1=(BipolarDisorderNet)testNet1.trainNet(testNet1);
						System.out.print("---------SIGMOID LOGISTIC Activation Function----------");
						break;
					default:
						System.exit(1);
				}
				System.out.println(" ");
				System.out.println("----------ADALINE TRAINED NET----------");
				testNet1.printNet(testNet1);
				System.out.println("----------ADALINE PRINT RESULT----------");
				Adaline a=(Adaline)trainedNet1.getTrainingAlgorithm();
				a.print(trainedNet1);
				break;
			default:
				System.exit(1);
		}
		
	}
	public static void trainSchizophreniaNet(){
		SchizophreniaNet testNet2=new SchizophreniaNet();

		SchizophreniaNet trainedNet2 =new SchizophreniaNet();
		testNet2.setMaxEpochs(10);
		testNet2.setTargetError(0.09);
		testNet2.setLearningRate(1.0);
		System.out.print("Enter 1 for Training using Perceptron algorithms or 2 for Training using Adaline ");
		System.out.println(" ");
		System.out.println("Enter any other number to exit the system: ");
		int input= sc.nextInt();
		switch(input){
			case 1:
				/*First column has bais
				  Remaining columns are for the various symptoms with 0 meaning symptom is not exhibited and 1 meaning symptom exhibited. The symptoms are:	
				  Delusions
				  Hallucinations
				  Disorganized thinking or speech
				  Extremely disorganized or abnormal motor behaviour
				  Withdrawal from friends and family
				  Trouble sleeping
				  Lack of motivation
				  Irritability or depressed mood
				  A drop in performance in school
				*/
				testNet2.setTrainSet(new double[][]{
					{1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},{1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},
					{1.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},{1.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0},
					{1.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0},{1.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0},
					{1.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0},{1.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0},
					{1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0},{1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0},
					{1.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},{1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0},
					{1.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0},{1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0},
					{1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0},{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0},
					{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0},{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0},
				});
				testNet2.setRealOutputSet(new double[]{0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0});
				testNet2.initPerceptronNet();
				System.out.println("----------PERCEPTRON INIT NET----------");
				testNet2.printNet(testNet2);
				testNet2.setTrainType(Training.TrainingTypesENUM.PERCEPTRON);
				testNet2.setActivationFnc(Training.ActivationFncENUM.STEP);
				trainedNet2=(SchizophreniaNet)testNet2.trainNet(testNet2);
				System.out.println(" ");
				System.out.println("----------PERCEPTRON TRAINED NET----------");
				testNet2.printNet(trainedNet2);
				System.out.println("----------PERCEPTRON PRINT RESULT----------");
				Perceptron p2=(Perceptron)trainedNet2.getTrainingAlgorithm();
				p2.print(trainedNet2);
				break;
			case 2:
				//first column has bais
				testNet2.setTrainSet(new double[][]{
					{1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},{1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},
					{1.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},{1.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0},
					{1.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0},{1.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0},
					{1.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0},{1.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0},
					{1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0},{1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0},
					{1.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},{1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0},
					{1.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0},{1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0},
					{1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0},{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0},
					{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0},{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0},
				});
				testNet2.setRealOutputSet(new double[]{0.000,0.111,0.111,0.111,0.111,0.111,0.111,0.111,0.111,0.111,0.222,0.333,0.444,0.556,0.667,0.778,0.889,1.000});
				testNet2.initAdalineNet();
				System.out.println("----------ADALINE INIT NET----------");
				testNet2.printNet(testNet2);
				testNet2.setTrainType(Training.TrainingTypesENUM.ADALINE);
				System.out.println("Enter 1 to use Linear Activation Function or 2 for Sigmoid Logistic Activation Function");
				System.out.print("or 3 for Hyperbolic Tangent Activation Function");
				System.out.println(" ");
				System.out.println("Enter any other number to exit the system: ");
				input= sc.nextInt();
				switch(input){
					case 1:
						testNet2.setActivationFnc(Training.ActivationFncENUM.LINEAR);
						trainedNet2=(SchizophreniaNet)testNet2.trainNet(testNet2);
						System.out.print("---------Linear Activation Function----------");
						break;
					case 2:
						testNet2.setActivationFnc(Training.ActivationFncENUM.SIGLOG);
						trainedNet2=(SchizophreniaNet)testNet2.trainNet(testNet2);
						System.out.print("---------SIGMOID LOGISTIC Activation Function----------");
						break;
					case 3:
						testNet2.setActivationFnc(Training.ActivationFncENUM.HYPERTAN);
						trainedNet2=(SchizophreniaNet)testNet2.trainNet(testNet2);
						System.out.print("---------SIGMOID LOGISTIC Activation Function----------");
						break;
					default:
						System.exit(1);
				}
				System.out.println(" ");
				System.out.println("----------ADALINE TRAINED NET----------");
				testNet2.printNet(trainedNet2);
				System.out.println("----------ADALINE PRINT RESULT----------");
				Adaline a=(Adaline)trainedNet2.getTrainingAlgorithm();
				a.print(trainedNet2);
				break;
			default:
				System.exit(1);
		}
		
	}

}