import sys

directions = [(-1, 0), (1, 0), (0, -1), (0, 1), (1,1), (1,-1), (-1,1),(-1,-1)]

def neighbor(s, i, j):
    result = list()
    for (off_i, off_j) in directions:
        x = i + off_i
        y = j + off_j
        if x < 0 or x >= s or y <0 or y >=s:
            continue
        else:
            result.append((x, y))
   # print (i,j), result
    return result
# read input 
s = int(sys.stdin.readline())
farm = list()
for i in range(s):
    line = sys.stdin.readline().split()
    one_line = [int(height) for height in line]
    farm.append(one_line)
# lower map record the lowest neighbor that is lower than current point, -1 if not exist
lower = list()
for i in range(s):
    curr_line = list()
    for j in range(s):
        lowest_neighbor = (-1, -1)
        lowest_val = farm[i][j] 
        for (x,y) in neighbor(s, i, j):
            if farm[x][y] < lowest_val:
                lowest_neighbor = (x, y)
                lowest_val = farm[x][y]
        curr_line.append(lowest_neighbor)
    lower.append(curr_line)
    #print curr_line

# now we can build a topological sort
# pre count[i][j], count how many edges that points to [i][j]
# area_size[i][j] to calc the contiguors area that higher or equal to this point
pre_count = list()
area_size = list()
for i in range(s):
    tmp_count = list()
    tmp_size = list()
    for j in range(s):
        tmp_count.append(0)
        tmp_size.append(1)
    pre_count.append(tmp_count)
    area_size.append(tmp_size)

# init pre count
for i in range(s):
    for j in range(s):
        (x, y) = lower[i][j]
        if x >=0 and y >= 0:
            pre_count[x][y] += 1
# now find a point with zero pres
topo_list = list()
for i in range(s):
    #print lower[i]
    #print lower[i]
    for j in range(s):
        if pre_count[i][j] == 0:
            topo_list.append((i,j))

# go through the topo_list
head = 0
result = list()
while head < len(topo_list):
    (i,j) = topo_list[head]
    (x,y) = lower[i][j]
    # is sink?
    if x < 0:
        result.append(area_size[i][j])
    else:
        area_size[x][y] += area_size[i][j]
        pre_count[x][y] -= 1
        if pre_count[x][y] == 0:
            topo_list.append((x,y))
    head += 1


#print sum(result)
result.sort()
output = ''
for one in reversed(result):
    output += str(one)+ ' '
print output.strip()

