class Solution:
    def isValid(self, s: str) -> bool:
        a =0
        b =0
        d =0
        
        
        stack = []
        last = '-'
        for c in s:
            
            if c == ')':
                if len(stack) ==0 or stack.pop() != '(': return 0
            
            elif c == ']':
                if len(stack) ==0 or stack.pop() != '[': return 0
                
            elif c == '}':
                if len(stack) ==0 or stack.pop() != '{': return 0
            else:
                stack.append(c)
                
                
                
        return not (len(stack) > 0)
            
                
