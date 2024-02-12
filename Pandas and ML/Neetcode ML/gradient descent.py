class Solution:
    def get_minimizer(self, iterations: int, learning_rate: float, init: int) -> float:
        #Gradient Descent has a few steps:
        #1. find gradient (dy/dx)
        #2. start with an initial guess or initial x starting point. (init)
        #3. at each iteration, move  in negative gradient direction xn= (x0 - (deriv*learningrate))
        #4. repeat for n iterations

        start = init

        for iteration in range(iterations):
            derivative = 2 * start
            start = start - (learning_rate*derivative)
        
        return round(start,5)
    