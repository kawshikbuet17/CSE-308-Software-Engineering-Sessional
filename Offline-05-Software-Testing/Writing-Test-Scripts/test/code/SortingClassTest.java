package code;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortingClassTest {
    Random rd = new Random();
    List<Integer> unsortedList;
    SortingClass sortingClass;
    List<Integer> sortedList;
    @Test
    void getSortedList_test1() {
        System.out.println("Test With Element Number = 0");
        testWithElementsNumber(0);  //with 0 element
    }
    @Test
    void getSortedList_test2() {
        System.out.println("Test With Element Number = 1");
        testWithElementsNumber(1);  //with 1 element
    }
    @Test
    void getSortedList_test3() {
        System.out.println("Test With Element Number = 2");
        testWithElementsNumber(2);  //with 2 elements
    }

    @Test
    void getSortedList_test4() {
        System.out.println("Test With Random Element Number");
        testWithElementsNumber(rd.nextInt(9000));   //with random size elements
    }

    @Test
    void getSortedList_test5() {
        System.out.println("Test With Ascending Case");
        testAscendingCase(10);//rd.nextInt(9000));    //test with ascending
    }

    @Test
    void getSortedList_test6() {
        System.out.println("Test With Descending Case");
        testDescendingCase(10);//rd.nextInt(9000));   //test with descending
    }

    @Test
    void getSortedList_test7() {
        System.out.println("Test With All Equal");
        testAllEqualCase(rd.nextInt(9000));  //test with all equal
    }

    @Test
    void getSortedList_test8() {
        System.out.println("Test With Hardcoding");
        testWithHardcoding();
    }

    void testWithElementsNumber(int num){
        unsortedList = new ArrayList<>();
        for(int i=0; i<num; i++){
            unsortedList.add(rd.nextInt());
        }
        sortingClass = new SortingClass(unsortedList);
        sortedList = sortingClass.getSortedList();
        checkAll();
    }

    void testAscendingCase(int num){
        unsortedList = new ArrayList<>();
        for(int i=0; i<num; i++){
            unsortedList.add(i);
        }
        sortingClass = new SortingClass(unsortedList);
        sortedList = sortingClass.getSortedList();
        checkAll();
    }

    void testDescendingCase(int num){
        unsortedList = new ArrayList<>();
        for(int i=num; i>0; i--){
            unsortedList.add(i);
        }
        sortingClass = new SortingClass(unsortedList);
        sortedList = sortingClass.getSortedList();
        checkAll();
    }

    void testAllEqualCase(int num){
        unsortedList = new ArrayList<>();
        int val = rd.nextInt();
        for(int i=0; i<num; i++){
            unsortedList.add(val);
        }
        sortingClass = new SortingClass(unsortedList);
        sortedList = sortingClass.getSortedList();
        checkAll();
    }

    void testWithHardcoding(){
        unsortedList = new ArrayList<>(Arrays.asList(5,-4,3,-2,1));
        sortingClass = new SortingClass(unsortedList);
        sortedList = sortingClass.getSortedList();
        checkAll();
    }

    void checkAll(){
        assertEquals(sizePreserved(), true, "Size before and after sort didn't match");
        assertEquals(allElementsPresent(), true, "Not All Elements Present");
        assertEquals(correctlySorted(), true, "Not Correctly Sorted");
    }

    boolean sizePreserved(){
        boolean preserved = true;
        if(unsortedList.size()!=sortedList.size()){
            preserved = false;
        }
        return preserved;
    }

    boolean allElementsPresent(){
        boolean present1 = true;
        for(int i=0; i<sortedList.size(); i++){
            if(!unsortedList.contains(sortedList.get(i))){
                present1 = false;
                break;
            }
        }
        boolean present2 = true;
        for(int i=0; i<unsortedList.size(); i++){
            if(!sortedList.contains(unsortedList.get(i))){
                present2 = false;
                break;
            }
        }

        Map<Integer, Integer> hm =  new HashMap<Integer, Integer>();
        for(int i=0; i<unsortedList.size(); i++){
            hm.put(unsortedList.get(i), 0);
        }
        for(int i=0; i<unsortedList.size(); i++){
            hm.put(unsortedList.get(i), hm.get(unsortedList.get(i))+1);
        }

        Map<Integer, Integer> hm2 =  new HashMap<Integer, Integer>();
        for(int i=0; i<sortedList.size(); i++){
            hm2.put(sortedList.get(i), 0);
        }
        for(int i=0; i<sortedList.size(); i++){
            hm2.put(sortedList.get(i), hm2.get(sortedList.get(i))+1);
        }

        boolean present = true;
        for(int i = 0; i<unsortedList.size(); i++){
//            System.out.println("from 1: "+unsortedList.get(i)+" = "+hm.get(unsortedList.get(i)));
//            System.out.println("from 2: "+unsortedList.get(i)+" = "+hm2.get(unsortedList.get(i)));
            if(!hm.get(unsortedList.get(i)).equals(hm2.get(unsortedList.get(i)))){
                present = false;
                break;
            }
        }
        return present1 && present2 && present;
    }

    boolean correctlySorted(){
        boolean correct = true;
        for(int i=0; i<sortedList.size()-1; i++){
            if(sortedList.get(i)>sortedList.get(i+1)){
                correct = false;
                break;
            }
        }
        return correct;
    }
}