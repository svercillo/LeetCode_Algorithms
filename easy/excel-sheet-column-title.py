class Solution:
    def convertToTitle(self, n: int) -> str:


        m = {}
        i =1
        for c in string.ascii_uppercase:
            m[i] = c
            i +=1
        m[0] = 'Z'

        s = ''
        i =1
        while n > 0:
            # print(n)
            print(n%26)
            s += m[n%26]
            if n % 26 == 0:
                n -= 26 
            else:
                
                n -= n %26
            n /= (26)
            n = int(n) 
            i +=1

        return s[::-1]
