 class Pair implements Comparable<Pair> {
        int freq;
        int val;

        Pair(int f, int v) {
            this.freq = f;
            this.val = v;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.freq != other.freq)
                return Integer.compare(this.freq, other.freq);
            return Integer.compare(this.val, other.val);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) return false;
            Pair other = (Pair) obj;
            return this.freq == other.freq && this.val == other.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(freq, val);
        }
    }

class Solution {
    long sum;
    TreeSet<Pair> main;
    TreeSet<Pair> sec;
    int x;

    public void insertinSet(Pair pair) {
        if(main.size() < x || pair.compareTo(main.first()) > 0) {
            sum += (long)pair.val * pair.freq;
            main.add(pair);

            if(main.size() > x) {
                Pair smallest = main.first();
                main.remove(smallest);
                sum -= (long)smallest.freq*smallest.val;
                sec.add(smallest);
            }
        }else{
            sec.add(pair);
        }
    }

    public void removeFromSet(Pair pair) {
        if(main.contains(pair)) {
            sum -= (long)pair.freq*pair.val;
            main.remove(pair);

            if(!sec.isEmpty()) {
                Pair largest = sec.last();
                sum += (long)largest.freq*largest.val;
                main.add(largest);
                sec.remove(largest);
            }
        }else{
            sec.remove(pair);
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        this.x=x;
        int n = nums.length;
        int size = n - k + 1;
        int idx=0;
        long[] res= new long[size];
        Map<Integer, Integer> mpp = new HashMap<>();
        main = new TreeSet<>();
        sec = new TreeSet<>();

        sum=0;
        int i=0;
        int j=0;
        while(j<n) {
            if(mpp.containsKey(nums[j])) {
                removeFromSet(new Pair(mpp.get(nums[j]), nums[j]));
            }

            mpp.put(nums[j], mpp.getOrDefault(nums[j], 0) + 1);
            insertinSet(new Pair(mpp.get(nums[j]), nums[j]));

            if(j-i+1 == k) {
                res[idx++] = sum;

                int oldFreq = mpp.get(nums[i]);
                removeFromSet(new Pair(oldFreq, nums[i]));
                mpp.put(nums[i], mpp.get(nums[i])-1);
                  if (oldFreq == 1) {
                    mpp.remove(nums[i]);
                } else {
                    mpp.put(nums[i], oldFreq - 1);
                    insertinSet(new Pair(oldFreq - 1, nums[i]));
                }
                i++;
            }
            j++;
        }
        return res;
    }
}