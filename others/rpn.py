ops = ['#', ')', '+', '-', '*', '/', '(' ]

ops_priorities = dict()

for i in range(len(ops)):
    ops_priorities[ops[i]] = i

def get_postfix_notation(tokens):
    tokens.append('#')
    s_ops = list()
    postfix = list()
    s_ops.append('#')
    index = 0
    while len(s_ops) > 0:
        one_token = tokens[index]
        if ops_priorities.has_key(one_token):
            prior = ops_priorities[one_token]
            stack_top = s_ops[-1]
            if (stack_top == '#' and one_token == '#') or (stack_top == '(' and one_token == ')') :
                s_ops.pop()
                index += 1
                continue
            if prior <= ops_priorities[stack_top] and stack_top != '(':
                #pop one
                postfix.append(s_ops.pop())
            else:
                s_ops.append(one_token)
                index += 1
        else:
            postfix.append(one_token)
            index += 1
    return postfix            
     
def evaluation(post_fix_tokens):
    print post_fix_tokens
    return 0


# test 
tokens = '( 3 + 4 ) + 5 * 9'.split()
print tokens
postfix = get_postfix_notation(tokens)
val = evaluation(postfix)
