import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    HashSet<listi> hash = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // Sort to handle duplicates
        List<Integer> list = new ArrayList<>();
        findit(nums, 0, list);
        return ans;
    }

    void findit(int[] nums, int i, List<Integer> list) {
        if (i == nums.length) {
            listi listWrapper = new listi(new ArrayList<>(list));
            if (!hash.contains(listWrapper)) {
                ans.add(new ArrayList<>(list));
                hash.add(listWrapper);  // Add to set to avoid duplicates
            }
        } else {
            list.add(nums[i]);
            findit(nums, i + 1, list);
            list.remove(list.size() - 1);
            findit(nums, i + 1, list);
        }
    }
}

class listi {
    List<Integer> list;

    listi(List<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        listi other = (listi) o;
        return list.equals(other.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode(); // Use list's hashCode for consistent hashing
    }
}
