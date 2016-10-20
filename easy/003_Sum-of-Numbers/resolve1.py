def get_sum(a, b):
    if a == b:
        return a
    elif a > b:
        tmp = a
        a = b
        b = tmp

    sum = 0
    for i in range(a, b + 1):
        sum += i

    return sum

print(get_sum(0, 2))

