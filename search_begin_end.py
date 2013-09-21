def search_begin_end( L, val):
    n = len(L)
    print n
    head = 0
    tail = n - 1
    # first determine the begin
    while( head <= tail):
        k = head + int((tail - head) / 2)
        if val <= L[k]:
            tail = k - 1
        else:
            head = k + 1
            
    begin = head
    # then get the end
    head = 0
    tail = n - 1 
    while(head <= tail):
        k = head + int( ( tail - head) / 2 )
        if val >= L[k]:
            head = k + 1
        else:
            tail = k - 1
    end = tail
    return (begin, end)

# test 
L = [ 0,1,2,3,3,3,3,3,5,9,10,11]
print search_begin_end(L,3)
