# Pandas Data Analysis Notebook

## Introduction
This notebook provides a concise overview of essential Pandas functionalities for data analysis. Make sure to replace the data URL (`https://example.com/data.csv`) with the actual path or URL of your dataset.

The basic order of data analysis typically follows a structured process to ensure a comprehensive and meaningful exploration of the dataset. The general order includes the following steps:

1. **Define the Problem or Research Question:**
   - Clearly articulate the problem you are trying to solve or the questions you aim to answer through data analysis.

2. **Data Collection:**
   - Gather relevant data from various sources, ensuring it aligns with the problem statement.

3. **Data Cleaning:**
   - Address missing values, handle outliers, and clean the dataset to ensure data quality.

4. **Exploratory Data Analysis (EDA):**
   - Gain insights into the dataset's structure, identify patterns, and understand the distributions of variables.

5. **Data Visualization:**
   - Create visualizations to better understand the data, including histograms, scatter plots, and correlation matrices.

6. **Feature Engineering:**
   - Create new features or transform existing ones to enhance the dataset for analysis. This step often involves techniques like encoding categorical variables, scaling numerical features, and creating derived features.

7. **Data Transformation:**
   - Prepare the data for modeling by scaling, normalizing, or transforming features as needed.

8. **Statistical Analysis:**
   - Conduct statistical tests, if applicable, to validate hypotheses or relationships within the data.

9. **Model Building:**
   - If the analysis involves predictive modeling, build and train appropriate models on the prepared data.

10. **Model Evaluation:**
    - Assess the performance of the models using relevant metrics and validate their effectiveness in solving the defined problem.


## Data Collection


## Import Libraries
```python
import pandas as pd
import numpy as np
```

## Load Data

### from CSV
```python
url = "https://example.com/data.csv"
df = pd.read_csv(url)
```

### From a Dictionary
`data = {'Column1': [1, 2, 3], 'Column2': ['A', 'B', 'C']}
df = pd.DataFrame(data)`

### From a List of Lists
`data = [[1, 'A'], [2, 'B'], [3, 'C']]
columns = ['Column1', 'Column2']
df = pd.DataFrame(data, columns=columns)`

### Merging and Joining

Merging combines datasets, facilitating a comprehensive view of information.

-   Use Case:
    -   Joining customer and order data to create a unified dataset.


        `unified_data = pd.merge(customers, orders, on='customer_id')`


        `df['profit_margin'] = (df['revenue'] - df['cost']) / df['revenue'] * 100`

### Concatenating Datasets

Use if columns are all the same and want to merge vertically:
`pd.concat([df1,df2], axis=0)`

or if datasets have different column names / you want to handle indices properly, reset the index:
`result_reset_index = pd.concat([df1, df2], ignore_index=True)`

Data Cleaning, Selection, Filtering
--------------------

## Data Cleaning
Cleaning is a crucial step in data analysis. Pandas offers tools to handle missing values and other data cleaning tasks.

### Handling Missing Values

- **Drop Rows or Columns:**
  - Use when a small percentage of data is missing, and removing rows or columns won't significantly impact analysis.
  - `df.dropna(axis=0, inplace=True)` for dropping rows.
  - `df.dropna(axis=1, inplace=True)` for dropping columns.
  - `df.dropna(subset=['Value'], inplace=True)` for dropping based on column missing values.
  - `df.dropna() ` for both.


- **Imputation using Mean, Median, or Mode:**
  - Suitable when missing values are missing completely at random (MCAR) or missing at random (MAR).
  - `df['column_name'].fillna(df['column_name'].mean(), inplace=True)` for mean imputation.
  - `df['column_name'].fillna(df['column_name'].median(), inplace=True)` for median imputation.
  - `df['column_name'].fillna(df['column_name'].mode()[0], inplace=True)` for mode imputation.

- **Forward or Backward Fill:**
  - Appropriate when missing values follow a pattern and have some temporal order.
  - `df.fillna(method='ffill', inplace=True)` for forward fill.
  - `df.fillna(method='bfill', inplace=True)` for backward fill.

- **Interpolation:**
  - Useful when missing values have a linear relationship with other values.
  - `df['column_name'].interpolate(method='linear', inplace=True)` for linear interpolation.

- **Specific Value Fill:**
  - When you want to replace missing values with a predefined constant.
  - `df['column_name'].fillna(value, inplace=True)` for filling with a specific value.

### Handling Duplicates
- Check for and remove duplicate rows using one of 2 methods:
 ```python 
 df.duplicated().sum() 
 df.drop_duplicates(inplace=True).
 ```
 - of if you are looking to drop based on a specific column duplicate,
 `df_no_duplicates = df.drop_duplicates(subset='ID', keep='first')`

### Correct Data Types
- Ensure data types are appropriate for analysis.
- Use `df.dtypes` to check and convert data types using `df['column'] = pd.to_numeric(df['column'], errors='coerce')`

### Change Data Type
```python
#FILL NA BEFORE CHANGING DATATYPE!
# Changing the datatype of the 'numeric_column' to float
df['numeric_column'] = df['numeric_column'].astype(float)
```

### Handling Date and Time
- Ensure date/time columns are in the correct format using pd.to_datetime.
- Extract meaningful features like day, month, or year.
Example:` df['date'] = pd.to_datetime(df['date']).`

### Typos and Inconsistencies

- Address typos or inconsistent values in categorical columns.
- Use domain knowledge or tools like fuzzy matching to identify and correct errors.
Example: `df['category'].replace({'catgry': 'category'}, inplace=True)`

### Drop Redundant Columns
- Remove columns that do not contribute to the analysis.
- Example: `df.drop(['column1', 'column2'], axis=1, inplace=True)`

### Handling Categorical Data

Categorical data requires special attention during the data analysis process. It involves converting textual or categorical information into a format that machine learning algorithms can understand. 
1\. Label Encoding:
-------------------

-   Assigning a unique numerical label to each category. This method is suitable when there is an ordinal relationship between the categories.

`from sklearn.preprocessing import LabelEncoder

### Example: Label encoding for a 'gender' column
le = LabelEncoder()
df['gender_encoded'] = le.fit_transform(df['gender'])`

Keep in mind that label encoding might imply an ordinal relationship that may not exist in the original data.

2\. One-Hot Encoding:
---------------------

-   Creating binary columns for each category (dummy variables). This is suitable when there is no inherent order among the categories.


`### Example: One-hot encoding for a 'color' column
df_encoded = pd.get_dummies(df, columns=['color'])`

One-hot encoding prevents the model from assuming false ordinal relationships between categories.

3\. Ordinal Encoding:
---------------------

-   Explicitly specifying the order of categories. This is useful when there is a clear ordinal relationship, and label encoding might not capture it.


`### Example: Ordinal encoding for an 'education' column
education_order = ['High School', 'Associate', 'Bachelor', 'Master', 'PhD']
df['education_encoded'] = df['education'].astype('category', ordered=True, categories=education_order).cat.codes`

Ensure that the order specified aligns with the actual ordinal nature of the data.

4\. Frequency Encoding:
-----------------------

-   Encoding categories based on their frequency in the dataset. This can be useful when the frequency of occurrence is meaningful.


`### Example: Frequency encoding for a 'city' column
frequency_map = df['city'].value_counts().to_dict()
df['city_encoded'] = df['city'].map(frequency_map)`

Frequency encoding can be particularly effective for high-cardinality categorical features.

5\. Target Encoding (Mean Encoding):
------------------------------------

-   Encoding categories based on the mean of the target variable for each category. This is useful for binary classification problems.


`### Example: Target encoding for a binary classification problem
target_mean = df.groupby('category')['target'].mean()
df['category_encoded'] = df['category'].map(target_mean)`

Be cautious with target encoding to avoid leakage or overfitting. It's often recommended to use cross-validation.

6\. Embedding Layers (for Deep Learning):
-----------------------------------------

-   In the context of neural networks, embedding layers can be used to learn the representation of categorical variables.


`from keras.models import Sequential
from keras.layers import Embedding

model = Sequential()
model.add(Embedding(input_dim=num_categories, output_dim=embedding_dim, input_length=1))`

This is common in natural language processing tasks but can be adapted for other categorical features.

7\. Binary Encoding:
--------------------

-   Representing categories as binary codes. This reduces dimensionality compared to one-hot encoding.


`### Example: Binary encoding using the category_encoders library
import category_encoders as ce

encoder = ce.BinaryEncoder(cols=['country'])
df_binary_encoded = encoder.fit_transform(df)`

Binary encoding is efficient and suitable for high-cardinality categorical features.

8\. Hashing Encoding:
---------------------

-   Hashing the categories into a fixed number of bins. This is useful when dealing with a large number of unique categories.


`### Example: Hashing encoding using the category_encoders library
encoder = ce.HashingEncoder(cols=['city'], n_components=8)
df_hash_encoded = encoder.fit_transform(df)`

Hashing encoding provides a balance between efficiency and preserving information.

## Data Selection

### Selecting Columns
```python
# Select a single column
df['column_name']

# Select multiple columns
df[['column1', 'column2']]

# Select the first x columns
x = 5  # Replace with the desired number of columns
first_x_columns = df.iloc[:, :x]
```

### Selecting Rows
```python
# Select row by integer index
df.iloc[index]

# Select row by label
df.loc[label]

# Select the first x rows
x = 10  # Replace with the desired number of rows
first_x_rows = df.iloc[:x, :]
```

### Select rows and columns based on a comparison
```python
# Select rows and columns using loc (label-based)
selected_data = df.loc[df['category'] == 'A', ['value', 'feature1']] 
```

### Groupby and Aggregation

```python
# Group by 'category' and calculate the mean of 'value'
grouped_data = df.groupby('category')['value'].mean()

# Display the aggregated data
grouped_data.head()
```

### Sorting Data

Sorting data is crucial for better understanding and analysis.

-   Use Case:
    -   Sorting customer data alphabetically by name.


        `sorted_customers = df.sort_values(by='customer_name')`

-   Sort by Asc, Desc:
`df_sorted_asc = df.sort_values(by='Column1', ascending=True)` and `df_sorted_asc = df.sort_values(by='Column1', ascending=False)`

## Filtering Data

### Filter rows based on a condition
``` df[df['column'] > value] ```


### Let's assume we have a DataFrame 'sales_data' with columns 'Product', 'Quantity', and 'Revenue'.

### 1. Filtering products with quantity greater than 100
``` python
high_quantity_products = sales_data[sales_data['Quantity'] > 100] 
```

### 2. Selecting rows where revenue is above a certain threshold
```python
high_revenue_products = sales_data[sales_data['Revenue'] > 5000]
```

### 3. Filtering data for a specific product
```python
product_data = sales_data[sales_data['Product'] == 'Product_A']
```

### 4. Selecting rows based on multiple conditions
```python
special_sales = sales_data[(sales_data['Quantity'] > 50) & (sales_data['Revenue'] > 2000)]
```

### 5. Filtering data for specific products using the 'isin' method
```python
selected_products = sales_data[sales_data['Product'].isin(['Product_A', 'Product_B'])]
```

### 6. Filtering data based on a string pattern (e.g., products containing 'Widget')
```python
widget_products = sales_data[sales_data['Product'].str.contains('Widget')] 
```

### 7. Selecting rows with null or non-null values in a specific column
```python
missing_data = sales_data[sales_data['Revenue'].isnull()]
valid_data = sales_data[sales_data['Revenue'].notnull()]
 ```

### 8. Using the loc method for more complex conditions and selecting specific columns
```python
targeted_data = sales_data.loc[(sales_data['Quantity'] > 50) & (sales_data['Product'] == 'Special_Product'), ['Product', 'Revenue']]
```

### 9. Filtering based on index (e.g., selecting rows after the 100th index)
```python
recent_sales = sales_data.loc[sales_data.index > 100]
```


## Data Visualization and Exploration 

## Explore Data
```python
# Display the first few rows
df.head()

# Display last few rows
df.tail()

# Get basic information about the DataFrame
df.info()

# Summary statistics
df.describe()
```
### Correlation Matrix

A correlation matrix is a table showing correlation coefficients between variables. It helps identify relationships and patterns within a dataset.

```python
# Correlation Matrix
correlation_matrix = df.corr()
plt.figure(figsize=(10, 8))
sns.heatmap(correlation_matrix, annot=True, cmap="coolwarm", fmt=".2f")
plt.title('Correlation Matrix')
plt.show()
```


## Data Visualization

### Scatter Plot

```python

# Scatter Plot
plt.scatter(df['numerical_feature1'], df['numerical_feature2'])
plt.xlabel('Numerical Feature 1')
plt.ylabel('Numerical Feature 2')
plt.title('Scatter Plot of Numerical Features')
plt.show()
```

A scatter plot is useful for visualizing the relationship between two numerical variables.

### Histograms

```python
# Plot histograms for numeric columns
df.hist(figsize=(10, 8))
plt.show()
```

Histograms provide a visual representation of the distribution of a dataset, showing the frequency of values within different bins.

### Pair Plots

```python
# Create pair plot
sns.pairplot(df, hue='category', diag_kind='kde')
plt.show()
```

Pair plots display pairwise relationships between variables, making it easy to identify patterns and correlations.

### Box Plots

```python
# Box plot
plt.figure(figsize=(12, 8))
sns.boxplot(x='category', y='value', data=df)
plt.show()
```

Box plots help in understanding the distribution of a variable and identifying outliers.

### Violin Plots

```python
# Violin plot
plt.figure(figsize=(12, 8))
sns.violinplot(x='category', y='value', data=df)
plt.show()
```

Violin plots combine aspects of box plots and kernel density plots, providing a comprehensive view of the data distribution.

### 3D Plots

```python
# 3D Scatter plot
fig = plt.figure(figsize=(12, 10))
ax = fig.add_subplot(111, projection='3d')
ax.scatter(df['feature1'], df['feature2'], df['feature3'], c=df['value'], cmap='viridis')
ax.set_xlabel('Feature 1')
ax.set_ylabel('Feature 2')
ax.set_zlabel('Feature 3')
plt.show()
```

3D plots are useful for visualizing relationships in datasets with three or more dimensions.

### Radar Charts

```python
# Radar chart
categories = df.columns[1:]
values = df.iloc[0].drop('category').values.flatten().tolist()

fig, ax = plt.subplots(figsize=(8, 8), subplot_kw=dict(polar=True))
ax.fill_between(np.arange(len(categories)), values, alpha=0.25)
ax.set_thetagrids(np.arange(len(categories)) * 360 / float(len(categories)), labels=categories)
plt.show()
```

Radar charts are effective for comparing multivariate data across different categories.

### Animated Plots

```python
# Animated line plot
fig, ax = plt.subplots(figsize=(10, 6))

def update(frame):
    data = df[df['frame'] == frame]
    ax.clear()
    ax.plot(data['date'], data['value'])
    plt.title(f'Time Series - Frame {frame}')

ani = animation.FuncAnimation(fig, update, frames=df['frame'].unique(), repeat=False)
plt.show()
```

Animated plots provide a dynamic view of changes over time in time-series or sequential data.

### Geographic Plots

```python
# Geographic plot with Plotly
fig = px.scatter_geo(df, lat='latitude', lon='longitude', color='value', size='value',
                     projection='natural earth', title='Geographic Plot')
fig.show()
```

Geographic plots visualize data on a map, providing insights into spatial distributions.

### Treemaps

```python
# Treemap with Plotly
fig = px.treemap(df, path=['category', 'sub_category'], values='value', title='Treemap')
fig.show()
```

Treemaps display hierarchical data in a nested structure, making it easy to understand proportions within categories.

### Kernel Density Estimation (KDE) Plot

```python
# KDE Plot
sns.kdeplot(df['numerical_feature'], fill=True)
plt.title('Kernel Density Estimation (KDE) Plot')
plt.show()
```

A KDE plot represents the probability density function of a continuous random variable.

## Feature Engineering

### Relabel Existing Column
```python
# Original DataFrame
print("Original DataFrame:")
print(df)

# Relabeling a Column
df.rename(columns={'old_column_name': 'new_column_name'}, inplace=True)

# Display the DataFrame after relabeling
print("\nDataFrame after Relabeling:")
print(df)
```

### Relabel Multiple Existing Columns from List
```python 
# Original DataFrame
print("Original DataFrame:")
print(df)

# List of new column names
new_column_names = ['new_col1', 'new_col2', 'new_col3', 'new_col4', 'new_col5']

# Relabeling columns using the list of new names
df.columns = new_column_names

# Display the DataFrame after relabeling
print("\nDataFrame after Relabeling:")
print(df)
```


### 1. **Creation of New Features:**

   - **Use Case:** Combining 'quantity' and 'price' to calculate the total cost of a product.

   ```python

   # Creating a new feature 'total_cost' by multiplying 'quantity' and 'price'

   df['total_cost'] = df['quantity'] * df['price']

   ```

### 2. **Binning and Discretization:**

   - **Use Case:** Converting 'age' into age groups for demographic analysis.

   ```python

   # Binning 'age' into categories ('young', 'middle-aged', 'senior')

   bins = [0, 30, 40, 50, np.inf]

   labels = ['Young', 'Middle-aged', 'Senior', 'Elderly']

   df['age_category'] = pd.cut(df['age'], bins=bins, labels=labels)

   ```

### 3. **Log Transformations:**

   - **Use Case:** Applying log transformation to 'income' for better model performance.

   ```python

   # Log-transform 'income' values

   df['log_income'] = np.log1p(df['income'])

   ```

### 4. **Encoding Categorical Variables (One-Hot Encoding):**

   - **Use Case:** Converting 'gender' into numerical representations for machine learning models.

   ```python

   # One-hot encoding for the 'gender' column

   df_encoded = pd.get_dummies(df, columns=['gender'])

   ```

### 5. **Feature Scaling (Min-Max Scaling):**

   - **Use Case:** Scaling 'height' and 'weight' to a common range for a BMI analysis.

   ```python

   # Min-max scaling 'height' and 'weight'

   from sklearn.preprocessing import MinMaxScaler

   scaler = MinMaxScaler()

   df[['scaled_height', 'scaled_weight']] = scaler.fit_transform(df[['height', 'weight']])

   ```

### 6. **Time-Based Features:**

   - **Use Case:** Extracting 'month' and 'day' from 'transaction_date' for time-series analysis.

   ```python

   # Extracting 'month' and 'day' from 'transaction_date'

   df['transaction_date'] = pd.to_datetime(df['transaction_date'])

   df['transaction_month'] = df['transaction_date'].dt.month

   df['transaction_day'] = df['transaction_date'].dt.day

   ```

## Data Transformation and Manipulation

### Pivoting Data


The pivot function is used to reshape a DataFrame based on column values. It takes the following important parameters:

- index: This parameter specifies the column whose unique values will become the index of the new DataFrame.

- columns: This parameter specifies the column whose unique values will become the columns of the new DataFrame.

- values: This parameter specifies the column whose values will populate the cells of the new DataFrame.

- aggfunc: This parameter is used when there are duplicate entries for the same combination of index and columns. It specifies the aggregation function to handle these duplicates.

-   Use Case:
    -   Converting long-format survey responses to a wide-format for summary analysis.

        `df_wide_format = df.pivot(index='respondent_id', columns='question', values='response')`

- 'respondent_id' becomes the index.
'question' becomes the columns.
'response' becomes the values.

### Melting Data

The melt function is used to unpivot a DataFrame from wide to long format. It takes the following important parameters:

- id_vars: This parameter specifies the columns to be retained as-is during the melting process. These columns will become identifiers.

- var_name: This parameter specifies the name of the new column that will store the variable names (values in the original DataFrame).

- value_name: This parameter specifies the name of the new column that will store the values corresponding to the variable names.

-   Use Case:
    -   Unpivoting data to create a long-format for time-series analysis.


        `df_long_format = pd.melt(df, id_vars=['date'], value_vars=['product1', 'product2'])`

- Second Example:
    - `df_melted = pd.melt(df, id_vars=['date'], var_name='variable', value_name='value')`
- 'date' is retained as an identifier.
- 'variable' becomes the new column for the variable names.
- 'value' becomes the new column for the values.

### Stacking and Unstacking

Stacking and unstacking help manipulate multi-level index data.

-   Use Case:
    -   Stacking a multi-level index DataFrame to simplify the structure for certain analyses.

        `df_stacked = df.stack()`

### Reshaping with `stack` and `unstack`

Transforming data between long and wide formats provides flexibility in data representation.

-   Use Case:
    -   Converting a long-format time-series dataset to a wide-format for comparison.

        `df_wide_format = df_long.set_index(['date', 'category']).unstack('category')`


## Statistical Analysis

### 1. **Summary Statistics:**

   - `df.describe()` - Generate descriptive statistics for numerical columns.

### 2. **Correlation:**

   - `df.corr()` - Compute pairwise correlation of columns.

### 3. **Quantiles and Percentiles:**

   - `df['column'].quantile(q)` - Calculate specific quantiles or percentiles.

### 4. **Skewness and Kurtosis:**

   - `df['column'].skew()` - Measure the asymmetry of the data.

   - `df['column'].kurt()` - Measure the tail-heaviness of the distribution.

## Aggregation and Grouping

### 5. **GroupBy:**

   - `df.groupby('column').agg({'numeric_col': 'mean', 'other_col': 'max'})` - Group data and apply custom aggregations.

### 6. **GroupBy with Multiple Columns:**

   - `df.groupby(['col1', 'col2']).agg({'numeric_col': 'mean'})` - Group data by multiple columns.

### 7. **Custom Aggregations:**

   - `df.groupby('column').agg({'numeric_col': ['mean', 'sum'], 'other_col': 'max'})` - Apply multiple custom aggregations.

## Hypothesis Testing

### 8. **T-Test:**

   - `from scipy.stats import ttest_ind` - Compare means of two independent samples.

   - `ttest_ind(sample1, sample2)`

### 9. **ANOVA:**

   - `from scipy.stats import f_oneway` - Compare means of multiple groups.

   - `f_oneway(group1, group2, group3)`

### 10. **Chi-Square Test:**

   - `from scipy.stats import chi2_contingency` - Assess association between categorical variables.

   - `chi2_contingency(observed_table)`

### 11. **Paired T-Test:**

   - `from scipy.stats import ttest_rel` - Compare means of paired samples.

   - `ttest_rel(before_treatment, after_treatment)`

## Data Distribution

### 12. **Histogram:**

   - `df['numeric_col'].hist()` - Visualize the distribution of a numerical variable.

### 13. **Box Plot:**

   - `df.boxplot(column='numeric_col')` - Visualize summary statistics of a numerical variable.

### 14. **Kernel Density Estimation (KDE):**

   - `df['numeric_col'].plot.kde()` - Visualize the probability density function.

### 15. **Shapiro-Wilk Test:**

   - `from scipy.stats import shapiro` - Check for normality in a sample.

   - `shapiro(df['numeric_col'])`

## Time Series Analysis

### 16. **Resampling:**

   - `df.resample('D').sum()` - Resample time series data.

### 17. **Rolling Mean:**

    - `df['numeric_col'].rolling(window=3).mean()` - Compute rolling mean.

### 18. **Autocorrelation:**

   - `df['numeric_col'].autocorr(lag=1)` - Measure autocorrelation.

### 19. **Exponential Moving Average:**

   - `df['ema'] = df['numeric_col'].ewm(span=7, adjust=False).mean()` - Compute exponential moving average.


# For models, 
