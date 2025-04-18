import pandas as pd
import statsmodels.api as sm
from typing import List, Dict

def load_data(file: str, cols: List[str]) -> pd.DataFrame:
    try:
        data = pd.read_csv(file)
    except FileNotFoundError:
        raise FileNotFoundError(f"File '{file}' not found.")
    
    data.columns = data.columns.str.strip().str.lower()
    
    col_map = {c.lower(): c for c in data.columns}
    missing = [c for c in cols if c.lower() not in data.columns]
    
    if missing:
        raise KeyError(f"Missing columns: {missing}")
    
    num_cols = ['year', 'population total', 'gdp', 'birth rate', 'health exp % gdp',
                'infant mortality rate', 'life expectancy male', 'life expectancy female']
    for c in num_cols:
        if c.lower() in data.columns:
            data[c.lower()] = pd.to_numeric(data[c.lower()], errors='coerce')
    
    return data

def make_model(d: pd.DataFrame, x: List[str], y: str) -> sm.OLS:
    model_data = d[[y] + x].dropna()
    
    if model_data.empty:
        raise ValueError(f"No data for columns: {[y] + x}")
    
    X = sm.add_constant(model_data[x])
    Y = model_data[y]
    
    try:
        m = sm.OLS(Y, X).fit()
        return m
    except Exception as e:
        raise ValueError(f"Model error: {str(e)}")

def predict(m: sm.OLS, input: Dict) -> float:
    input_df = pd.DataFrame([input])
    input_df = sm.add_constant(input_df, has_constant='add')
    return m.predict(input_df).iloc[0]

def start():
    cols = [
        'country/region', 'region', 'year', 'population total', 'birth rate', 'gdp',
        'health exp % gdp', 'infant mortality rate', 'life expectancy male',
        'life expectancy female'
    ]
    
    try:
        d = load_data("World Indicators.csv", cols)
        
        us = d[d['country/region'].str.lower() == 'united states'].copy()
        
        if us.empty:
            raise ValueError("No US data.")
        
        m1 = make_model(
            d=us,
            x=['year'],
            y='population total'
        )
        
        pred_input = {'year': 2015}
        pred_pop = predict(m1, pred_input)
        print(f"Predicted US Population 2015: {int(pred_pop):,}")
        
        eu = d[d['region'].str.lower() == 'europe'].copy()
        
        if eu.empty:
            raise ValueError("No Europe data.")
        
        x_vars = [
            'birth rate', 'gdp', 'health exp % gdp',
            'infant mortality rate', 'life expectancy male'
        ]
        
        m2 = make_model(
            d=eu,
            x=x_vars,
            y='life expectancy female'
        )
        
        significant_vars = [var for var in x_vars if m2.pvalues[var] < 0.05]
        
        final_vars = significant_vars if significant_vars else x_vars
        m2_final = make_model(
            d=eu,
            x=final_vars,
            y='life expectancy female'
        )
        
        print("\nFinal Model Summary for Life Expectancy Female (Europe):")
        print(m2_final.summary())
        
        custom = {
            'birth rate': 0.03,
            'gdp': 1e9,
            'health exp % gdp': 0.04,
            'infant mortality rate': 0.05,
            'life expectancy male': 80
        }

        custom = {k: v for k, v in custom.items() if k in final_vars}
        pred_life_custom = predict(m2_final, custom)
        print(f"\nPredicted Life Expectancy Female (custom): {pred_life_custom:.2f} years")
        
    except Exception as e:
        print(f"Error: {str(e)}")

if __name__ == "__main__":
    start()