class Trie_node(object):
    def __init__(self, node_char):
        self.children = dict()
        self.node_char = node_char
        self.word = None

    def insert(self, word):
        """
         insert word[index:] into trie tree 
        """
        curr_node = self
        index = 0
        while index < len(word):
            if word[index] not in curr_node.children:
                curr_node.children[word[index]] = Trie_node(word[index]) 
            if index ==  len(word) - 1:
                curr_node.word = word
            curr_node = curr_node.children[word[index]]
            index += 1

    def look_up(self, word):
        """
        To see if a word is contained in the key
        """
        curr_node = self
        index = 0
        while index < len(word) - 1:
            if word[index] not in curr_node.children:
                return False
            curr_node = curr_node.children[word[index]]
            index += 1
        return curr_node.word != None

def build_trie(names):
    root = Trie_node(' ')
    for one_name in names:
        root.insert(one_name)
    return root


# test 
names = ['Kate', 'James', 'Ann']
root = build_trie(names)



