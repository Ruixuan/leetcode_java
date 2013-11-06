def regions(mat):
    m = len(mat)
    n = len(mat[0])
    count = 0
    for i in range(m):
        j = 0
        while j < n:
            if mat[i][j] == 0:
                flag = 1
                while j < n and mat[i][j] == 0:
                    if i > 0:
                        if mat[i - 1][j] == 0:
                            flag = 0
                    j += 1
                count += flag
            j += 1
    
    return count
    
# test
mat = [ [0,0,1,1,1],
        [0,1,0,0,1],
        [1,1,1,0,0],
        [1,0,1,1,1],
        [1,1,1,1,1]        
        ]
    
print regions(mat)    
                  
