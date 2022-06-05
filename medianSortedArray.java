class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length >nums2.length){
          return findMedianSortedArrays(nums2,nums1);
        }
      
      int lo=0, hi=nums1.length;
      while(lo<=hi){
        int mid1=(lo+hi)/2;
        int mid2=(nums1.length+nums2.length)/2-mid1;
        
        int l1=mid1==0 ? Integer.MIN_VALUE:nums1[mid1-1];
        int l2=mid2==0 ? Integer.MIN_VALUE:nums2[mid2-1];
        int r1=mid1==nums1.length ? Integer.MAX_VALUE:nums1[mid1];
        int r2=mid2==nums2.length ? Integer.MAX_VALUE:nums2[mid2];
        
        if(l1>r2)
          hi=mid1-1;
        else if(l2>r1)
          lo=mid1+1;
        else{
          return (
            (nums1.length+nums2.length)%2==0?
            ((Math.max(l1,l2)+Math.min(r1,r2))/2.0) 
            : Math.min(r1,r2)
          );
        }
        
      }
      
      return -1;
    }
}