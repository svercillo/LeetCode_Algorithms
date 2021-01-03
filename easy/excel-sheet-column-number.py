class Solution:
    def titleToNumber(self, s: str) -> int:
        alphabet_string = string.ascii_lowercase

        m = {}
        i =1
        for c in string.ascii_uppercase:
            m[c] = i
            i +=1

        val =0
        j =0 
        for i in range(len(s)-1, -1, -1):
            
            print(s[i])
            val += m[s[i]] * 26 **j
            j +=1 
        return val
