def parse(s):
    result = list()
    i = 0
    while i < len(s):
        curr = ''
        if  '0' <= s[i] and s[i] <= '9':
            end_index = i
            while '0' <= s[end_index] and s[end_index] <= '9':
                end_index += 1
                if end_index >= len(s):
                    break
            curr = s[i:end_index]
            i = end_index - 1
        
        if s[i] in ['+', '-', 'x', '=', '(', ')']:
            curr = s[i]
        if curr != '':
            result.append(curr)
        i += 1
    return result    

def solve(input_string):
    tokens = parse(input_string)
    flag = 1
    x_index = 0
    c_index = 0
    i = 0
    op = 1
    stack = list()
    while i < len(tokens):
        if tokens[i] == 'x':
            x_index += op * flag
        elif tokens[i] == '+':
            op = 1
        elif tokens[i] == '-':
            op = -1
        elif tokens[i] == '=':
            flag = 0 - flag
            op = 1
        elif tokens[i] == '(':
            # set the current flag
            stack.append(op)
            flag =   flag * op
            op = 1
        elif tokens[i] == ')': 
            # reset the flag
            flag = flag * stack.pop()
        else:
            c_index += op * flag * int(tokens[i])
        i += 1
    if x_index == 0:
        raise ValueError('x index is Zero!')
    return float(-c_index) / float(x_index)

        
# test 
print solve('x+9-2-4+x = -x + 5 - 1 + 3 - x')
print solve('x+9-1 = 0')
print solve('x+4 = - 3 - x') 
print solve(' -( x - ( - 2 + x)) + x =  10') # expected 8
