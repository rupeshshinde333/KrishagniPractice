import json
import csv
import pandas as pd
from collections import defaultdict

d = defaultdict(int)

with open("stock_input.csv") as f:
    for line in f:
        tokens = [t.strip() for t in line.split(",")]
        try:
            product = str(tokens[1])
            delta = int(tokens[2])
        except ValueError:
            continue
        d[product] += delta
j = json.dump(d, open('temp.json', 'w'))
print(dict(d))

df = pd.read_json('temp.json',typ='series')
print(df)
df.to_csv('test_stock.csv', sep='\t')


   
