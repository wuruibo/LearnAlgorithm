package Design.P1244;

import java.util.*;

/**
 *
 * 输入：
 * ["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
 * [[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
 * 输出：
 * [null,null,null,null,null,null,73,null,null,null,141]
 *
 * 解释：
 * Leaderboard leaderboard = new Leaderboard ();
 * leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
 * leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
 * leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
 * leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
 * leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
 * leaderboard.top(1);           // returns 73;
 * leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
 * leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
 * leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
 * leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
 *
 */
class Leaderboard {

    private class Node implements Comparable<Node>{
        private Integer playerId;
        private Integer score;

        public Node(Integer playerId, Integer score) {
            this.playerId = playerId;
            this.score = score;
        }

        @Override
        public int compareTo(Node node) {
            return this.score.equals(node.score)?node.playerId-this.playerId:node.score-this.score;
        }
    }

    /**
     * 红黑树
     */
    private Set<Node> set;
    private Map<Integer,Node> nodeMap= new HashMap<>();
    public Leaderboard() {
       this.set=new TreeSet<>();
    }
    
    public void addScore(int playerId, int score) {
        Node node=new Node(playerId,score);
        set.add(node);
        nodeMap.put(playerId,node);
    }
    
    public int top(int K) {
        Iterator<Node> iterator=set.iterator();
        int result=0;
        while (iterator.hasNext() && K!=0) {
            Node current=iterator.next();
            result+=current.score;
            K--;
        }
        return result;
    }
    
    public void reset(int playerId) {
        set.remove(nodeMap.get(playerId));
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */