record Pair(int val, int freq) {}

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int i=0;
        int j=0;
        int n=nums.length;
        
        int[] hash = new int[51];
        Arrays.fill(hash, 0);
        int size = n - k + 1;
        int[] ans = new int[size];
        int idx=0; 
        while(j<n && idx<size) {
            hash[nums[j]]++;

            if(j-i+1==k) {
                PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                    if (b.freq() != a.freq()) {
                        return b.freq() - a.freq();
                    } else {
                        return b.val() - a.val();
                    }
                });
                int sum=0;
                for(int l=0;l<hash.length;l++) {
                    if (hash[l] > 0) pq.add(new Pair(l, hash[l]));
                }
                int temp=x;
                while(!pq.isEmpty() && temp-->0) {
                    Pair pair = pq.poll();
                    sum += pair.val()*pair.freq();
                }
                ans[idx++] = sum;
                hash[nums[i]]--;
                i++;
            }
            
            j++;
        }
        return ans;
    }
}