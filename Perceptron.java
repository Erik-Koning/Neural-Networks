
package Components;

import java.util.*;

public class Perceptron {
	float[] weights = new float[2];			//this particular perceptron will have 2 weights
	float[] possibleWeights = {-1f,1f};		//possible weights to randomly choose
	float c = 0.1f; 							//learning rate
	

	public Perceptron(){					//if i had void here it would be a method that happened to share the name with the class
		
		Random rand; 
		for (int i = 0;i < weights.length; i++) {
			rand = new Random();
			weights[i] = possibleWeights[rand.nextInt( possibleWeights.length)];
		}
	}

	//What does the perceptron think
	public int guess(float[] inputs){
		float sum = 0f;
		for(int i = 0; i < weights.length; i++){
			sum+= inputs[i]*weights[i];				//sum
		}
		int output = sign(sum);						//activation function given sum
		return output;
	}

	//Training the perceptron
	void train(float[] inputs, int target) {
		int guess = guess(inputs);
		int error = target - guess;

		for(int i = 0; i < weights.length; i++){
			weights[i] += error*inputs[i];
		}
	}

	public int sign(float n){
		if(n>= 0f){
			return 1;
		}
		else{
			return -1;
		}
	}
}

