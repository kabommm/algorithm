class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
    	int right = 0;
    	int sum = 0;
    	int len = sequence.length;
        int arr[] = new int[2];
    	
    	for(right=0; right<sequence.length; right++) {    		
    		sum += sequence[right];
    		
    		while(sum > k) {
    			sum -= sequence[left];
    			left++;
    		}
    		
    		if(sum == k) {
    			if(len > right-left) {
    				len = right-left;
    				arr[0] = left;
    				arr[1] = right;
    			}
    			else if(len == right-left) {
    				arr[0] = Math.min(arr[0], left);
    				arr[1] = Math.min(arr[1], right);
    			}
    		}
    		
    	}
    	
    	return arr;
    }
}