import numpy as np
from numpy.typing import NDArray


class Solution:
    #get derivative takes in the model predictions, correct answers, size of array, values, and which weight we want derivative value for
    def get_derivative(self, model_prediction: NDArray[np.float64], ground_truth: NDArray[np.float64], N: int, X: NDArray[np.float64], desired_weight: int) -> float:
        # note that N is just len(X)
        return -2 * np.dot(ground_truth - model_prediction, X[:, desired_weight]) / N
    #get model prediction takes in the points and given weights
    def get_model_prediction(self, X: NDArray[np.float64], weights: NDArray[np.float64]) -> NDArray[np.float64]:
        return np.squeeze(np.matmul(X, weights))

    learning_rate = 0.01

    def train_model(
        self, 
        X: NDArray[np.float64], 
        Y: NDArray[np.float64], 
        num_iterations: int, 
        initial_weights: NDArray[np.float64]
    ) -> NDArray[np.float64]:
        
        #1. given X (the dataset) Y ( the correct answers) num_iterations (how many rounds) and inital_weights
        #2. first, we get our prediction. prediction is needed for getting the derivative.
        #3. gradient descent updates weight at each step. new weight = old weight - derivative * learning rate 
        #4. call get derivative for each weight.
        #5. perform gradient descent for each weight.

        for iteration in range(num_iterations):
            model_prediction = self.get_model_prediction( X, initial_weights)

            d1 = self.get_derivative(model_prediction, Y, len(X), X, 0) # number at end is the desired weight we want
            d2 = self.get_derivative(model_prediction, Y, len(X), X, 1)
            d3 = self.get_derivative(model_prediction, Y, len(X), X, 2)

            initial_weights[0] = initial_weights[0] - d1 * self.learning_rate
            initial_weights[1] = initial_weights[1] - d2 * self.learning_rate
            initial_weights[2] = initial_weights[2] - d3 * self.learning_rate

        return np.round(initial_weights,5)


       



        