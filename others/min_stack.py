class MinStack(object):
    
    def __init__(self):
        self.s = list()
        self.m = list()
    
    def push(self, val):
        self.s.append(val)
        self.m.append(min(val, self.m[-1]))
   
    def pop(self):
        val = self.s[-1]
        self.s.pop(-1)    
        self.m.pop(-1)
        return val

    def min(self):
        return self.m[-1]
