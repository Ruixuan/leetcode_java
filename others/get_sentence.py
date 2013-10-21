def get_sentence(text, dic):
    """
    parse a text into words using a dict
    """
    n = len(text)
    is_parsed = [0] * (n + 1)
    is_parsed[0] = 1
    parse_index = [0] * (n + 1)

    for i in range(1, n+1):
        for j in range(0, i):
            if is_parsed[j] != 1:
                continue
            if text[j:i] in dic:
                is_parsed[i] = 1
                parse_index[i] = j
                break
    # now retrive words
    j = n
    if is_parsed[n] != 1:
        return None
    answer = list()
    while(j != 0):
       answer.append(text[parse_index[j]:j])
       j = parse_index[j]
    
    answer.reverse()
    return answer

# test 
text = "iamastudentfromdartmouth"
dic = set(['i','am','a','student','from','dartmouth'])
print get_sentence(text, dic)
