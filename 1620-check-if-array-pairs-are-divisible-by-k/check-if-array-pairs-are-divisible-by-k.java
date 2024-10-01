import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                arr[i] = arr[i] % k;
            } else {
                arr[i] = (k - (Math.abs(arr[i]) % k)) % k;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!hash.containsKey(arr[i])) continue;
            
            if (arr[i] == 0) {
                if (hash.getOrDefault(0, 0) % 2 != 0) return false;
                hash.remove(0);
            } else {
                int complement = k - arr[i];
                if (hash.getOrDefault(arr[i], 0) == 0 || hash.getOrDefault(complement, 0) == 0) {
                    return false;
                }
                
                if (hash.getOrDefault(arr[i], 0) == 1) {
                    hash.remove(arr[i]);
                } else {
                    hash.put(arr[i], hash.getOrDefault(arr[i], 0) - 1);
                }
                
                if (hash.getOrDefault(complement, 0) == 1) {
                    hash.remove(complement);
                } else {
                    hash.put(complement, hash.getOrDefault(complement, 0) - 1);
                }
            }
        }
        
        return true;
    }
}
