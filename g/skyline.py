def put(result, interval):
    if interval[0] < itnerval[1]:
        result.append(interval)

def clean(result):
    ret = list()
    if len(result) == 0:
        return ret

    ret.append(result[0])

    for i in range(1, len(result)):
        pre = result[i - 1]
        curr = result[i]
        if curr[0] == pre[0] or curr[1] == pre[1]:
            continue
        ret.append(curr)

    return ret


def merge(first , second):
    p1 = 0
    p2 = 0
    result = list()
    h1 = 0
    h2 = 0
    while p1 < len(first) or p2 < len(second):
        flag = 1
        if p1 < len(first) and p2 < len(second):
            if first[p1][0] > second[p2][0]:
                flag = 2
            else:
                flag = 1

        elif p1 >= len(first):
            flag = 2
        else:
            flag = 1

        if flag  == 1:
            h = max(h2, first[p1][1])
            result.append((first[p1][0], h))
            h1 = first[p1][1]
            p1 += 1
        else:
            h = max(h1, second[p2][1])
            result.append((second[p2][0], h))
            h2 = second[p2][1]
            p2 += 1
    
    return clean(result)


def sky_line(intervals):
    n = len(intervals)
    if n == 1:
        return [(intervals[0][0], intervals[0][1]), (intervals[0][2], 0)]

    first = sky_line(intervals[0: n / 2])
    second = sky_line(intervals[n /2 :])
    return merge(first, second)

# test

test = [(1, 11, 5), (3, 13, 9), (2,6,7), (12, 7, 16), (14, 3, 25), (19, 18, 22)]
test = sorted(test, key = lambda x: x[0])
print sky_line(test)

