package hwonline.testing;

import java.util.Scanner;

/**
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 */
public class HJ51 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();// n 为节点个数
            Node header = new Node();

            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                Node node = new Node(value, header.next);
                header.next = node;
            }

            int target = sc.nextInt();

            for (int i = 0; i < target; i++) {
                header = header.next;
            }

            System.out.println(header.value);

        }

    }

    static class  Node{
        int value;
        Node next;
        public Node(){}

        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }

    }

}
