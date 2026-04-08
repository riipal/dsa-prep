class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Approach 02
        // Map<Integer, Integer> frequencyMap = new HashMap<>();
        // int max = 1;
        // for(int num : nums) {
        //     frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        //     max = Math.max(max, frequencyMap.get(num));
        // }

        // List<Integer>[] bucket = new ArrayList<>()[max + 1];

        // for(int key : frequencyMap.keySet()) {
        //     int frequency = frequencyMap.get(key);
        //     if(bucket[frequency] == null) {
        //         bucket[frequency] = new ArrayList<>();
        //     }
        //     bucket[frequency].add(key);
        // }
        
        
        
        
        
        //Approach 01
    
        List<Integer>[] bucket = new List[nums.length + 1];  
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for(int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();
        for (int pos = bucket.length - 1;pos >= 0 && topK.size() < k; pos--) {
            if (bucket[pos] != null) {
                topK.addAll(bucket[pos]);
            }
        }

        return topK.stream().mapToInt(i -> i).toArray();

    }
}