class Quad:
    def __init__(self):
        self.quads = list([0,0,0,0])


def count_black(root):
    if root == None:
       return 0
    if is_black(root):
       return root.size()
    elif is_white(root):
       return 0
    s = 0
    for one_quad in root.quads:
        s += count_black(root)
    return s
