import torch
import torch.nn as nn
from torchtyping import TensorType

class Solution(nn.Module):
    def __init__(self):
        super().__init__()
        torch.manual_seed(0)
        #architecture:
        # - linear layer with 512 neurons
        # - ReLU activation 
        # - dropout layer, probability =  0.2
        # - final layer, 10 neurons 
        # - sigmoid activation

        self.linear1 = nn.Linear(784,512)
        self.relu = nn.ReLU()
        self.dropout = nn.Dropout(p=0.2)
        self.projection = nn.Linear(512,10)
        self.sigmoid = nn.Sigmoid()


    
    def forward(self, images: TensorType[float]) -> TensorType[float]: #similar to get_model_predictions
        torch.manual_seed(0)
        output = self.sigmoid(self.projection(self.dropout(self.relu(self.linear1(images))))) #basically call all layers of the architecture
        return torch.round(output,decimals=4) # Return the model's prediction to 4 decimal places
