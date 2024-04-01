class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = list.get(i - 1);
            row.add(1); // First element is always 1

            for (int j = 1; j < i; j++) {
                // Each element is the sum of the two elements above it
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1); // Last element is always 1
            list.add(row);
        }

        return list;
    }
}
