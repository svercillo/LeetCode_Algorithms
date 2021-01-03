class Solution:
    def bitwiseComplement(self, N: int) -> int:
        s = list(str(bin(N))[2:])
        print(s)
        for i in range(0, len(s)):
            s[i] = '1' if s[i] == '0' else '0'
        
        print(int(''.join(s), 2))
        return int(''.join(s), 2)
        # return int(bin('0b' +''.join(s)))
