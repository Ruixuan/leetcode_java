from collections import deque

def slidewindow(A, w):
    que = deque()
    answer = list()
    for i in range(len(A)):
        while(len(que) > 0 and A[que[0]] < A[i]):
            que.popleft()
        que.appendleft(i)
        while que[-1] <= i - w:
            que.pop()
        answer.append(A[que[-1]])
    return answer



# test
A = [ -1, 3, 1, -3, 5, 3, 6, 7]
w = 3
answer = slidewindow(A,w)
print A
print answer
