/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private HashMap<Integer,UndirectedGraphNode> nodeMap;
    private HashSet<Integer> is_visited;
    private UndirectedGraphNode find_or_create(int label){
        if (!nodeMap.containsKey(label)){           
            UndirectedGraphNode new_node = new UndirectedGraphNode(label);
            nodeMap.put(label, new_node);
        }
        return nodeMap.get(label);        
    }
    
    private void visit(UndirectedGraphNode node){
        
        if (is_visited.contains(node.label))
            return;
        is_visited.add(node.label);
        UndirectedGraphNode copied_node = find_or_create(node.label);    
        for(UndirectedGraphNode one_node: node.neighbors){
            copied_node.neighbors.add(find_or_create(one_node.label));
            visit(one_node);
        }
    }
           
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (node == null) return null;
        nodeMap = new HashMap<Integer,UndirectedGraphNode>();
        is_visited = new HashSet<Integer>();
        visit(node);
        return nodeMap.get(node.label);
    }
}
