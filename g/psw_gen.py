def gen(k , n):
    """
    range 0 .. k , len n 
    """
    visited = set()
    seq = list()    
    def visit(node):
        for i in range(k):
            edge = tuple(list(node) + [i])
            if edge not in visited:
                visited.add(tuple(edge))
            else:
                continue
            visit(edge[1:])
            seq.append(i)
    seq = [0] * (n - 1)
    visit(tuple([0] * (n - 1)))
    return seq
# test 

print len(gen(8, 3))
