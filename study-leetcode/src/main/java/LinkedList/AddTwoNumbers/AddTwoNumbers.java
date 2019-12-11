package LinkedList.AddTwoNumbers;

/**
 *
 * 寻找两个有序数组的中位数那题相似
 * 时间复杂度m+n
 * 空间复杂度1
 * @autor yeqiaozhu.
 * @date 2019-04-24
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位变量
        int temp=0;
        ListNode addListNode=new ListNode(0);
        ListNode tailListNode = addListNode;
        ListNode indexListNode1=l1;
        ListNode indexListNode2=l2;
        while(indexListNode1!= null || indexListNode2!=null){
            ListNode tempListNode;
            if(indexListNode1 == null){
                tempListNode= new ListNode((indexListNode2.val+temp)%10);
                temp= (indexListNode2.val+temp)/10;
                indexListNode2=indexListNode2.next;
            }else  if(indexListNode2 == null){
                tempListNode=new ListNode((indexListNode1.val+temp)%10);
                temp= (indexListNode1.val+temp)/10;
                indexListNode1=indexListNode1.next;
            }else {
                tempListNode= new ListNode((indexListNode2.val+temp+indexListNode1.val)%10);
                temp = (indexListNode2.val+temp+indexListNode1.val)/10;
                indexListNode1=indexListNode1.next;
                indexListNode2=indexListNode2.next;
            }
            tailListNode.next=tempListNode;
            tailListNode = tempListNode;
        }
        if(temp != 0){
            tailListNode.next= new ListNode(temp);
        }
        return addListNode.next;
    }

    public static void main(String[] args) {
        ListNode t1=new ListNode(5);

        ListNode t2 = new ListNode(5);


        ListNode listNode=new AddTwoNumbers().addTwoNumbers(t1,t2);
        while (listNode !=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}

