class Solution:
    def readBinaryWatch(self, num: int):
        hrs = num if num <= 4 else 4
        mins = 0 if num <=4 else num -4
        times = []

        while hrs>= 0: 
            hrs_arr = self.combine(4, hrs)
            mins_arr = self.combine(6, mins)
            
            hrs_list = []
            mins_list = []
            for arr in hrs_arr:
                val = self.convert(arr)
                if val <12:
                    hrs_list.append(val)
            for arr in mins_arr:
                val = self.convert(arr)
                if val < 60:
                    mins_list.append(val)

            for i in range(len(hrs_list)):
                for j in range(len(mins_list)):
                    _min = mins_list[j]
                    if _min < 10:
                        _min = f"0{_min}"
                    times.append(f"{hrs_list[i]}:{_min}")

            hrs -=1
            mins +=1 
        return times

    def convert(self, arr):
        _sum = 0
        for i in arr: 
            _sum += pow(2, i-1)
        return _sum
        
    def combine(self, n: int, k: int):
        remaining = set({})
        for i in range(n):
            remaining.add(i)
            
        value =[]
        self.backtrackDfs([], n, k, value)
        return value
        
        
    def backtrackDfs(self, arr, n, k, value):
        if len(arr) == k:
            value.append(arr)
            return 
        
        last = None
        if len(arr) ==0:
            last = 0
        else: 
            last = arr[len(arr)-1]
        

        for i in range(last+1,  n+1):
            arr2 = arr.copy()
            arr2.append(i)
            self.backtrackDfs(arr2, n, k, value)
