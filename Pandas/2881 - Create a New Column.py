import pandas as pd

def createBonusColumn(employees: pd.DataFrame) -> pd.DataFrame:
    temp = employees
    temp['bonus'] = 2*temp['salary']
    return temp
    