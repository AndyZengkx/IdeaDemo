package main.practice;

import java.util.*;

class Solution {
    public int minimumMoves(int[][] grid) {
        var q = new LinkedList<Node>();//0:x1; 1:y1; 2:x2; 3:y2; 4:step;
        var set = new HashSet<Node>();
        q.offer(new Node(0,0,0,1,0));
        set.add(new Node(0,0,0,1,0));
        int n = grid.length, m = grid[0].length;
        while(!q.isEmpty()){
            Node poll = q.poll();
            int x1 = poll.x1, x2 = poll.x2, y1 = poll.y1, y2 = poll.y2, step = poll.step;
            System.out.println(x1+" "+y1+" "+x2+" "+y2+" "+step);
            if(x1==n-1 && x2==n-1 && y1==m-2 && y2==m-1) return step;
            if(x1==x2){
                if(y2+1<m && grid[x2][y2+1]==0 && !set.contains(new Node(x2,y2,x2,y2+1,step+1))){
                    Node tmp = new Node(x2,y2,x2,y2+1,step+1);
                    set.add(tmp);
                    q.offer(tmp);
                }
                if(x2+1<n && grid[x1+1][y1]==0 && grid[x2+1][y2]==0 && !set.contains(new Node(x1,y1,x1+1,y1,step+1))){
                    Node tmp = new Node(x1,y1,x1+1,y1,step+1);
                    set.add(tmp);
                    q.offer(tmp);
                }
            }
            if(y1==y2){
                if(x2+1<n && grid[x2+1][y2]==0 && !set.contains(new Node(x2,y2,x2+1,y2,step+1))){
                    Node tmp = new Node(x2,y2,x2+1,y2,step+1);
                    set.add(tmp);
                    q.offer(tmp);
                }
                if(y2+1<m && grid[x1][y1+1]==0 && grid[x2][y2+1]==0 && !set.contains(new Node(x1,y1,x1,y1+1,step+1))){
                    Node tmp = new Node(x1,y1,x1,y1+1,step+1);
                    set.add(tmp);
                    q.offer(tmp);
                }
            }
        }
        return -1;
    }
}

public class LeetCodePractice {
    public static void main(String... args) {
        var solution = new Solution();
        var set = new HashSet<Node>();
        Node node1 =new Node(0,0,0,0,1);
        Node node2 = new Node(0,0,0,0,2);
        set.add(node1);
        System.out.println(set.contains(node2));
        set.add(node2);
        System.out.println(set.size());
        System.out.println(node1.hashCode());
        System.out.println(node2.hashCode());
        System.out.println(node1.equals(node2));
    }
}
