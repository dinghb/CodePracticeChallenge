# 描述： 统计字符串中整数的个数，如abc123egf，其中整数为1个，字符串中无整数时，返回0。
# 输入:	输入字符串
# 输出:	输出字符串中整数的个数
# 样例输入:	a2sdkj321sjk
# 样例输出:	2

import re


def count_integral_num_from(inputstr):
    # python regex ==> https://docs.python.org/3.5/library/re.html
    pattern = re.compile(r"\d+")
    # regex.findall ==> https://docs.python.org/3.5/library/re.html#re.findall
    return len(pattern.findall(inputstr))


while True:
    input_str = input()
    if len(input_str) == 0:
        break
    print(count_integral_num_from(input_str))
