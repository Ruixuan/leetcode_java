

def is_valid(number):
    number_list = number.split('e')
    if len(number_list) > 2:
        return False
    
