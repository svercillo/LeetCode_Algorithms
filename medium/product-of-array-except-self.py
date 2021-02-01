class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        
        pre = [1] * (len(nums))
        post = [1] * (len(nums))
        
        
        
        if len(nums) ==2:
            t= nums[1]
            nums [1] = nums[0] 
            nums[0] = t
            return nums


        pre[0]  = nums [0]
        for i in range(1, len(nums)):
            pre[i] = pre[i-1] * nums[i]
            

        # post[len(nums)-1] = nums[len(nums)-1]
        for i in range(len(nums) -2, -1, -1):
            if i == len(nums) -2:
                post[i] = nums[len(nums)-1]
            else:
                post[i] = post[i+1] * nums[i+1]
            
        print(pre)
        print(post)
        
        
        
        arr = []
        arr.append(post[i])
        for i in range(len (nums)-2):
            arr.append(pre[i] * post[i+1])
        arr.append(pre[len(nums)-2])
            
            
        return arr 
