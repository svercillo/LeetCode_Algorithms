class Solution:
    def addBinary(self, a: str, b: str) -> str:
        
        if len(a) < len(b):
            c = a
            a = b
            b = c
        a = a[::-1]
        b =b[::-1]

            
        a = list(a)
        b = list(b)
            
        print (b)
        # add b to a 
        for i in range (0, len(b)):
            if b[i] == '1':
                cur = int(a[i]);
                cur += 1
                a[i] = str(cur)
                print(cur)
                y= i
                
                print(a[y])
                
                while int(a[y]) >1 and y < len (a)-1:
                    a[y] = "0"
                    a[y+1] = str(int(a[y+1])+1)
                    y += 1
                    
                if int(a[len(a) -1]) > 1:
                    a[len(a) -1] = "0"
                    a.append("1")
                    
                    
        return "".join(a)[::-1]

                    
            
        
        
