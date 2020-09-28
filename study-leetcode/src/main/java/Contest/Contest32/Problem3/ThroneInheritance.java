package Contest.Contest32.Problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用二叉树
 */
class ThroneInheritance {

    private class Node{
        String name;
        List<String> list;
        public int state;//0live 1 death
        public Node(String name) {
            this.name = name;
            list=new ArrayList<>();
            state=0;
        }
    }
    private Node root;
    private Map<String,Node> allMap =new HashMap<>();
    public ThroneInheritance(String kingName) {
        root=new Node(kingName);
        allMap.put(kingName,root);
    }

    public void birth(String parentName, String childName) {
        Node father=allMap.get(parentName);
        Node child=new Node(childName);
        allMap.put(childName,child);
        father.list.add(childName);
    }

    public void death(String name) {
        Node father=allMap.get(name);
        father.state=1;
    }
    private List<String> list=new ArrayList<>();
    public List<String> getInheritanceOrder() {
        list.clear();
        get(root);
        return list;
    }
    private void get(Node root){
        if (root.state==0) {
            list.add(root.name);
        }
        for(String name:root.list){
            get(allMap.get(name));
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */