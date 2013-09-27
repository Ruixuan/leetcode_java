import operator

op_func = {
            '+': operator.add,
            '-': operator.sub,
            '*': operator.mul
            }

def calc( op, first, second):
    return op_func[op](first, second)

def evaluate(s):
    tokens = s.split()
    s = list()
    for one_token in tokens:
        try:
            number = int(one_token)
            s.append(number)
        except ValueError:
            second = s.pop()
            first = s.pop()
            new_val = calc( one_token, first, second)
            s.append(new_val)
 
    return s.pop()

# test
print evaluate("5 1 2 + 4 * + 3 -")
