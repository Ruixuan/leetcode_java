/* 
Random set of WORD. 

Criterion : Given a word find out if the word can be broken into smaller word, by removing one alphabet at a time. 
a) all such word should be valid dictionary word.( Assume a function is there to test whether the word exist in dictionary) 
b) Remove one alphabet at a time but the new word need to be in dictionary. 

For eg : 
restated -> restate -> estate -> state -> stat -> sat -> at -> a 
fullfill the criterion. ( single alphabet assume belong to dict) 
*/

def test_word(s, dic):
    if len(s) == 0:
       return True

    if s not in dic:
        return False

    if result_cache.hasKey(s):
        return result_cache[s]

    for i in range(len(s)):
        new_s = s[0:i] + s[i+1:]
        if test_word(new_s):
            result_cache[s] = True
            return True

    result_cache[s] = False

    return False
