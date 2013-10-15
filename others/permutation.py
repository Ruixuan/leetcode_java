
count = dict()

def get_permute(curr_result, i, A, last_visited):
    if i > len(curr_result):
        return  

    if i >= len(curr_result):
        print curr_result
        return

    for a in count.iterkeys():
        m = count[a]
        if a == last_visited:
            continue

        for c in range(1,m+1):
            #  add 'a...a' of length c
            if i + c > len(curr_result):
                break

            count[a] -= c
            for j in range(i, i + c):
                curr_result[j] = a

            get_permute(curr_result, i + c, A, a)
            count[a] += c
 


# test 
A = [1,1,2,2,2,3]
print A
curr_result = [0] * 6
for a in A:
    if count.has_key(a):
        count[a] += 1
    else:
        count[a] = 1

get_permute(curr_result, 0, A, -1)
