import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    List<List<String>> ans = new ArrayList<>();
    HashSet<Integer> hashc = new HashSet<>();
    HashSet<Integer> hashs = new HashSet<>();
    HashSet<Integer> hashd = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> arr = new ArrayList<>();
        findit(arr, 0, n);
        return ans;
    }

    void findit(List<String> arr, int i, int n) {
        if (i == n) {
            if(arr.size()==n)ans.add(new ArrayList<>(arr));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (hashc.contains(j) || hashs.contains(i + j) || hashd.contains(i - j)) continue;
            StringBuilder str = new StringBuilder(".".repeat(n));
            str.setCharAt(j, 'Q');
            arr.add(str.toString());
            hashc.add(j);
            hashs.add(i + j);
            hashd.add(i - j);
            findit(arr, i + 1, n);
            arr.remove(arr.size() - 1);
            hashc.remove(j);
            hashs.remove(i + j);
            hashd.remove(i - j);
        }
    }
}
