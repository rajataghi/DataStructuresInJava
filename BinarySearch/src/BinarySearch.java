public class BinarySearch {
    public static int binarySearch(int a[], int l, int h, int target)
    {
        if (h>=l){
            int mid = l + (h-l)/2;
            if(target==a[mid])
                return mid;
            else if(target<a[mid])
               return binarySearch(a,l,mid-1,target);
            else if(target>a[mid])
                return binarySearch(a,mid+1,h,target);
        }
        return -1;
    }


    public static int binaryIterative(int[] nums, int x){
        int size = nums.length;
        if(size==0)
            return -1;
        if(size==1)
            return 0;
        int lo = 0;
        int hi = size-1;
        int mid = 0;
        while(hi>=lo){
            mid = lo + (hi-lo)/2;
            if(nums[mid]==x)
                return mid;
            else if(nums[mid]>x)
                hi = mid-1;
            else
                lo = mid+1;
        }
        return -1;
    }

    public static void main(String args[])
    {
        int[] a = {20,40,40,50,70,8};
        int x = 70;
      //  int res = ob.binarySearch(a, 0, n - 1, x);
        int res = binaryIterative(a, x);
        if (res == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + res);
    }
}
