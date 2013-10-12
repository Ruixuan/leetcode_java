def merge_sort(A):
    """
    Using merge sort to get the pair count
    """
    n = len(A)
    if n == 0:
        return 0, list()
    elif n == 1:
        return 0, list(A)
    first = A[0:n/2]
    second = A[n/2: n]
    count1, sorted1 = merge_sort(first)
    count2, sorted2 = merge_sort(second)
    counts = count1 + count2
    # merge first and second part
    index1 = 0
    index2 = 0
    sorted_all = list()
    while index2 < len(sorted2) or index1 < len(sorted1):
        if index2 >= len(sorted2):
            big_head = 1
        elif index1 >= len(sorted1):
            big_head = 2
        elif sorted2[index2] >= sorted1[index1]:
            big_head = 2
        else:
            big_head = 1
        
        if big_head == 2:
            sorted_all.append(sorted2[index2])
            # new pairs found
            counts += index1
            index2 += 1
        else:
            sorted_all.append(sorted1[index1])
            index1 += 1
    return counts, sorted_all

def pairs(A):
    """
    get the reverse pairs count in A
    """

    (counts, Asorted) = merge_sort(A)
    print A
    print counts
    print Asorted
    return counts


#
A = [9, 3, 5, 7, 7, 1, 4, 2]
print pairs(A)
