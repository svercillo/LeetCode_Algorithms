class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        start =-1
        end = -1
        if s == "":
            return 0
        
        for i in range(len(s) -1, -1, -1):
            if end == -1: 
                if s[i] != " ":
                    end = i
            else: 
                if s[i] == " ":
                    start = i
                    break
    
        if start == -1:
            if end == -1:
                if s[0] ==" ":
                    print("d")
                    return 0
                else:
                    print("e")
                    return end
                    
            else:
                
                print("=d")
                print(end)
                print(start)
                                
                return end +1
        elif end == -1:
            print("b")
            return len(s) - start
        else:
            print("a")
            return end - start
                    
