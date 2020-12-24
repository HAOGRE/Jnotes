# -*- coding: utf-8 -*-
# pip install pandas
# pip install xlrd==1.2.0
# pip install openpyxl

import pandas as pd

#                      这里替换Excel的路径                         这里替换sheet名称
data = pd.read_excel('/Users/3t/Desktop/test.xlsx', sheet_name='Sheet1')

row_num, column_num = data.shape    #数据共有多少行，多少列
print('the sample number is %s and the column number is %s' % (row_num, column_num))
#这里我们的数据共有4600行，假设要让每个文件500行数据，即分成10个文件
for i in range(0, 10):
    # 你改这里的500就行
    save_data = data.iloc[i*500:(i+1)*500, :] #每隔1万循环一次
    file_name= '/Users/3t/Desktop/' + str(i) + '.xlsx'
    save_data.to_excel(file_name, sheet_name = 's1', index = False)