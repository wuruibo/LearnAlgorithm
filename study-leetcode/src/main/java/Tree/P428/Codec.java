package Tree.P428;

import java.util.*;
import java.util.stream.Collectors;


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Codec {
    public String serialize(Node root) {
        Queue<Node> queue= new LinkedList<>();
        if (root==null) {
            return null;
        }
        queue.offer(root);
        StringBuilder result=new StringBuilder(root.val+"#");
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                Node current=queue.poll();
                result.append(current.children.stream()
                        .map(node -> {
                            queue.offer(node);
                            return String.valueOf(node.val);
                        }).reduce((s, s2) -> s+","+s2).orElse(""));

                result.append("#");
            }
        }
        return result.toString();
    }

    public Node deserialize(String data) {
        if (data==null) {
            return null;
        }
        Queue<Node> queue=new LinkedList<>();
        String[] sons=data.split("#");
        Node root=new Node(Integer.valueOf(sons[0]),new ArrayList<>());
        queue.offer(root);
        int index=1;
        while (!queue.isEmpty()) {
            Node current=queue.poll();

            if (index<sons.length){
                String[] next=sons[index].split(",");
                List<Node> nodes=Arrays.stream(next)
                        .filter(s -> !s.isEmpty())
                        .map(s->{
                            Node node=new Node(Integer.valueOf(s),new ArrayList<>(0));
                            queue.offer(node);
                            return node;
                        }).collect(Collectors.toList());
                current.children=nodes;
                index++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String s=",";
        String[] strings=s.split(",");
        System.out.println(Arrays.stream(strings).map(string -> Integer.valueOf(string)).collect(Collectors.toList()));
        List<Integer> list= new ArrayList<>();
        list.stream().forEach(System.out::println);
        String s1="44##";
        Node root=new Codec().deserialize(s1);

        System.out.println(new Codec().serialize(new Node(44,new ArrayList<>())));
        System.out.println(new Codec().serialize(root));
        System.out.println(new Codec().serialize(root).equals(s1));

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));