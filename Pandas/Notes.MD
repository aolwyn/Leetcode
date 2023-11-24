# Pandas Data Analysis Notebook

## Introduction
This notebook provides a concise overview of essential Pandas functionalities for data analysis. Make sure to replace the data URL (`https://example.com/data.csv`) with the actual path or URL of your dataset.

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

### Filtering Data

## Filter rows based on a condition
``` df[df['column'] > value] ```


### Let's assume we have a DataFrame 'sales_data' with columns 'Product', 'Quantity', and 'Revenue'.

### 1. Filtering products with quantity greater than 100
```high_quantity_products = sales_data[sales_data['Quantity'] > 100] ```

### 2. Selecting rows where revenue is above a certain threshold
```high_revenue_products = sales_data[sales_data['Revenue'] > 5000]```

### 3. Filtering data for a specific product
```product_data = sales_data[sales_data['Product'] == 'Product_A']```

### 4. Selecting rows based on multiple conditions
```special_sales = sales_data[(sales_data['Quantity'] > 50) & (sales_data['Revenue'] > 2000)]```

### 5. Filtering data for specific products using the 'isin' method
```selected_products = sales_data[sales_data['Product'].isin(['Product_A', 'Product_B'])]```

### 6. Filtering data based on a string pattern (e.g., products containing 'Widget')
```widget_products = sales_data[sales_data['Product'].str.contains('Widget')] ```

### 7. Selecting rows with null or non-null values in a specific column
```python
missing_data = sales_data[sales_data['Revenue'].isnull()]
valid_data = sales_data[sales_data['Revenue'].notnull()]
 ```

### 8. Using the loc method for more complex conditions and selecting specific columns
```targeted_data = sales_data.loc[(sales_data['Quantity'] > 50) & (sales_data['Product'] == 'Special_Product'), ['Product', 'Revenue']]```

### 9. Filtering based on index (e.g., selecting rows after the 100th index)
```recent_sales = sales_data.loc[sales_data.index > 100]```


## Data Cleaning
Cleaning is a crucial step in data analysis. Pandas offers tools to handle missing values and other data cleaning tasks.

### Handling Missing Values

- **Drop Rows or Columns:**
  - Use when a small percentage of data is missing, and removing rows or columns won't significantly impact analysis.
  - `df.dropna(axis=0, inplace=True)` for dropping rows.
  - `df.dropna(axis=1, inplace=True)` for dropping columns.
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

## Data Visualization

Data Visualization
------------------

Visualize key aspects of the dataset to gain insights.

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