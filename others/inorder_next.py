from bst import Bst

def min_val(node):
    curr = node
    while curr.left != None:
        curr = curr.left
    return curr

def find_next(root, node):
    if node.right != None:
        return min_val(node.right)
    # search sucessor 
    curr = root
    suc = None
    while( curr != None):
        if curr.val == node.val:
            break
        if curr.val < node.val:
            curr = curr.right
        else:
            suc = curr
            curr = curr.left
    return suc

#test
root = Bst(5)
num = [5,2,8,1,3,7,9,6]
#num = [1,5,6,7,9, 10, 2, 4]
for val in num:
    root.insert(val)

#print level by level
root.level_print()
print root.find(19)
n3 = root.find(7)
print find_next(root, n3).val

