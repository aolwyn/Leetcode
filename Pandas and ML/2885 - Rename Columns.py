import pandas as pd

def renameColumns(students: pd.DataFrame) -> pd.DataFrame:
    names= ['student_id','first_name','last_name','age_in_years']
    students.columns = names
    return students
    