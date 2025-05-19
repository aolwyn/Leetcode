import pandas as pd

def getDataframeSize(players: pd.DataFrame) -> List[int]:
    temp = players.shape
    return [temp[0],temp[1]]
    