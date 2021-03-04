class Solution:
    def letterCombinations(self, digits: str):
        numbers = {
            "2" : 'abc',
            "3" : 'def',
            "4" : 'ghi',
            "5" : 'jkl',
            "6" : 'mno',
            "7" : 'pqrs',
            "8" : 'tuv',
            "9" : 'wxyz'
        }
        
        
        _list = []
        for dig in digits:
            if len(_list) == 0:
                print(numbers[dig])
                
                for l in numbers[dig]:
                    _list.append(l)

            else:
                temp = []
                for arr in _list:
                    for l in numbers[dig]:
                        t = f"{arr}"
                        t += l
                        temp.append(t)
                _list = temp
        return _list


            
        
        
