
class LinkedList{
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data ;
            this.next =  null;
        }
    }
    public static Node head = null;
    public static Node tail = null;
    
    public static void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode ;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public static void addLast(int data){
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public static void deleteFirst(){
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        else if(head == tail){
            System.out.println("Item is deleted " + head.data);
            head = tail = null;
            return;
        }
        else{
            head = head.next;
        }
    }
    public static void deleteLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        else if(head == tail){
            head = tail = null;
            return;
        }
            Node temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
    }
    public static void add(int data , int pos){
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        if(pos == 0){
            addFirst(data);
            return;
        }
        Node temp =head;
        for(int i=0 ;i<pos-1;i++){
            if(temp.next == null){
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            temp = temp.next;
        }
        if(temp.next == null){
            addLast(data);
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static void delete(int pos){
        if(head == null){
            System.out.println("the is is empty");
            return;
        }
        else if(pos == 0){
            deleteFirst();
            return;
        }
        Node temp = head;
        for(int i=0;i<pos-1;i++){
            if(temp.next == null){
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public static void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> "  );
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static void reverse(){
        Node prev = null;
        Node curr = head ;
        Node next ;
        while(curr != null){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
        }
        head = prev;
    }
    public static Node mid(){
        Node slow = head;
        Node fast = head ;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static boolean pallindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node midNode = mid();
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next ;
        }
        Node right = prev;
        Node left = head;
        
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void detectCycle(){
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast=fast.next.next;
            if(slow==fast){
                isCycle = true;
                break;
            }
        }
        if(isCycle){
            slow = head;
            Node prev = null;
            while(slow != fast){
                slow = slow.next ;
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;
        }
    }
    public static Node findCycleStart(){
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if(isCycle){
            slow = head;
            int count =0;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
                count ++;
            }
            System.out.println(count);
            return slow;
        }
        else{
            System.out.println("No Cycle found");
            return null;
        }
    }

    public static void removeNthFromEnd(int n){
        Node slow = head ;
        Node fast = head;
        for(int i=0;i<n;i++){
            if(fast == null){
                System.out.println("the n is larger than the list");
               return;
            }
            fast = fast.next;
        }
        if(fast == null){
            head = head.next ;
            return;
        }
        while(fast.next != null){
            slow = slow.next;
            fast=fast.next;
        }
        slow.next = slow.next.next;
    }

    public static void main(String[] args) {
        addFirst(1);
        addFirst(2);
        addFirst(3);
        addLast(4);
        addLast(1);
        addLast(2);
        addLast(3);
        display();
        // deleteFirst();
        // System.out.println();
        // display();
        // add(6,3);
        // System.out.println();
        // display();
        // System.out.println();
        // reverse();
        // display();
        // System.out.println();
        // System.out.println(pallindrome());
        
        // tail.next = head.next.next;
        System.out.println();
        removeNthFromEnd(2);
        display();
    }
}