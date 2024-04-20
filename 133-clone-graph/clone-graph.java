/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Deque<Node> bfs1 = new ArrayDeque<>();
        bfs1.offer(node);
        Node res = new Node(node.val);
        Deque<Node> bfs2 = new ArrayDeque<>();
        Node[] added = new Node[101];
        bfs2.offer(res);
        added[node.val] = res;
        while (!bfs1.isEmpty()) {
            Node prev1 = bfs1.remove();
            Node prev2 = bfs2.remove();
            for (Node child: prev1.neighbors) {
                if (added[child.val] == null) {
                    Node copy = new Node(child.val);
                    bfs1.offer(child);
                    bfs2.offer(copy);
                    added[child.val] = copy;
                    prev2.neighbors.add(copy);
                } else {
                    prev2.neighbors.add(added[child.val]);
                }
            }
        }
        return res;
    }
}