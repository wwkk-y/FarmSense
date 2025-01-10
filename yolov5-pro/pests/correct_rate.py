import os
from pathlib import Path

input_file = "./labels/"
output_file = "./test_output/exp4/labels/"

result = [] # 结果 [对True | 错 False, filename]

def get_id(f):
    with open(f, 'r') as file:
        content = file.read()
        words = content.split()
        return int(words[0])

def judge_corret(f):
    if get_id(f) == get_id(input_file + f.name):
        result.append((True, f.name))
    else:
        result.append((False, f.name))


def main():
    if not os.path.exists(input_file):
        print(input_file, 'not exsits')
        return

    if not os.path.exists(output_file):
        print(output_file, 'not exsits')
        return

    for f in Path(output_file).iterdir():
        judge_corret(f)
    
    ## 计算正确率
    corret_num = 0
    error_set = []
    for item in result:
        if item[0]:
            corret_num += 1
        else:
            error_set.append(item[1])
    
    print('正确率：', corret_num/len(result))
    print('预测错误数据：', error_set)

if __name__ == "__main__":
    main()