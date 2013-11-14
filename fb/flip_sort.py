def flip(a, index):
    end = a[index:]
    return a[:index] + end.reverse()

def flip_sort(a):
    """
    A sort function that use only flip function
    Algorithm:
        Key to the problem is to keep a[i:] monolic either increasing or decreasing
    """
 
#test 
a = [1, 4, 0, 6, 7]
print flip_sort(a)


