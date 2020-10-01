class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        string = list(s)
        table = {}
        v = "aeiouAEIOU"
        
        for c in v:
            table[c] = 1

        stack = []
        vowelInd = []
        
        for i in range(0, len(s)):
            c = s[i]
            if table.get(c, "--") != "--":
                vowelInd.append(i)
                stack.append(c)
        
        for i in vowelInd:
            c = stack.pop()
            string[i] = c
        
        return "".join(string)
            
            
        
