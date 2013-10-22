class Bst(object):

    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

    def insert(self, val):
        curr = self
        while curr != None:
           if curr.val == val:
               break

           if curr.val < val:
               if curr.right == None:
                   curr.right = Bst(val)
               curr = curr.right 
           else:
               if curr.left == None:
                   curr.left = Bst(val)
               curr = curr.left
     
    def find(self, val):
        curr = self
        while curr != None:
            if curr.val == val:
                return curr

            if curr.val < val:
                curr = curr.right
            else:
                curr = curr.left

        return curr

    def level_print(self):
        """
        print bst level by level
        """
        result = ""
        que = list()
        level = list()
        que.append(self)
        level.append(0)
        i = 0
        pre_level = 0
        while i < len(que):
            if pre_level != level[i]:
                result += '\n'
                pre_level = level[i]

            curr = que[i]
            if curr == None:
                result += "* "
            else:
                result += (str(curr.val) + " ")

            if curr != None:
                que.append(curr.right)
                que.append(curr.left)
                level.append(pre_level + 1)
                level.append(pre_level + 1)
            i += 1
        print result
                

                


