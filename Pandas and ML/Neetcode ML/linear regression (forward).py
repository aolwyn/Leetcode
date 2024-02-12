import numpy as np
from numpy.typing import NDArray


# Helpful functions:
# https://numpy.org/doc/stable/reference/generated/numpy.matmul.html
# https://numpy.org/doc/stable/reference/generated/numpy.mean.html
# https://numpy.org/doc/stable/reference/generated/numpy.square.html

class Solution:
    
    def get_model_prediction(self, X: NDArray[np.float64], weights: NDArray[np.float64]) -> NDArray[np.float64]:
        # X is an Nx3 NumPy array
        # weights is a 3x1 NumPy array

        #general equation is Yn = Xn * Wn for each tuple in X.
        model_prediction = np.matmul(X,weights)
        return np.round(model_prediction,5)
 

    

    def get_error(self, model_prediction: NDArray[np.float64], ground_truth: NDArray[np.float64]) -> float:
        # model_prediction is an Nx1 NumPy array
        # ground_truth is an Nx1 NumPy array
        
        # we can calculate Root Mean Square Deviation/Error (RMSE)
        error = np.mean(np.square(model_prediction - ground_truth))
        return np.round(error,5)


