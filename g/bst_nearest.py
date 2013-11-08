def find_nearest(root, target):
    if root == None:
        return  ERROR

    if root.val == target:
       return root.val

    tmp = root.val

    if root.val > target:
        if root.right != None:
            tmp = near(target, tmp, find_nearest(root.right))
    elif root.left != None:
            tmp = near(target, tmp, find_nearest(root.left))

    return tmp

