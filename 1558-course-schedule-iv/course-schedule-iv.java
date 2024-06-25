class Solution {
    public List<Boolean> checkIfPrerequisite(final int n, final int[][] prerequisites, final int[][] queries) {
        final boolean[][] dependencies = new boolean[n][n];

        for(final int[] prerequisite : prerequisites)
            dependencies[prerequisite[0]][prerequisite[1]] = true;

        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                for(int k = 0; k < n; ++k)
                    if(!dependencies[j][k])
                        dependencies[j][k] = dependencies[j][i] && dependencies[i][k];

        final List<Boolean> result = new ArrayList<>();

        for(final int[] query : queries)
            result.add(dependencies[query[0]][query[1]]);

        return result;
    }
}