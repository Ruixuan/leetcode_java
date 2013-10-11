/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<RandomListNode,RandomListNode> old2new = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode pt;
        pt = head;
        old2new.put(null, null);
        while(pt != null){
            RandomListNode tmp = new RandomListNode(pt.label);
            old2new.put(pt, tmp);
            pt = pt.next;
        }
        pt = head;
        while(pt != null){
            RandomListNode copy;
            copy = old2new.get(pt);
            copy.next = old2new.get(pt.next);
            copy.random = old2new.get(pt.random);
            pt = pt.next;
        }
        return old2new.get(head);
    }
}
