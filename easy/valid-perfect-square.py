class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        i =0
        res = 0
        while res < num :
            res = i*i
            if res == num:
                return True
            i +=1
        return False
