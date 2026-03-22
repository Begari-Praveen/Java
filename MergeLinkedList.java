import java.util.*;

public class MergeLinkedList {

    
    public static java.util.LinkedList<Integer> mergeTwoLists(java.util.LinkedList<Integer> list1, java.util.LinkedList<Integer> list2) {

        java.util.LinkedList<Integer> mergeList = new java.util.LinkedList<>();
        int i=0,j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i) < list2.get(j)){
                mergeList.add(list1.get(i));
                i++;
            }
            else{
                mergeList.add(list2.get(j));
                j++;
            }
        }
        while(i<list1.size()){
            mergeList.add(list1.get(i));
            i++;
        }
        while(j<list2.size()){
            mergeList.add(list2.get(j));
            j++;
        }
        return mergeList;
    }
    public static void main(String[] args){

        java.util.LinkedList<Integer> list1 = new java.util.LinkedList<>();
        java.util.LinkedList<Integer> list2 = new java.util.LinkedList<>();
        list1.add(10);
        list1.add(30);
        list1.add(50);
        list2.add(20);
        list2.add(40);
        list2.add(60);
        System.out.println(list1);
        System.out.println(list2);

        java.util.LinkedList<Integer> mergedList = mergeTwoLists(list1, list2);

        System.out.println(mergedList);
    }
}
