package code;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortingClassTest {
    Random rd = new Random();
    @Test
    void getSortedList() {
        testWithElementsNumber(0);  //with 0 element
        testWithElementsNumber(1);  //with 1 element
        testWithElementsNumber(2);  //with 2 elements
        testWithElementsNumber(rd.nextInt(9000));   //with random size elements
        testAscendingCase(rd.nextInt(9000));    //test with ascending
        testDescendingCase(rd.nextInt(9000));   //test with descending
        testAllEqualCase(rd.nextInt(9000));  //test with all equal
    }

    void testWithElementsNumber(int num){
        List<Integer> unsortedList = new ArrayList<>();
        for(int i=0; i<num; i++){
            unsortedList.add(rd.nextInt());
        }
        SortingClass sortingClass = new SortingClass(unsortedList);
        List<Integer> sortedList = sortingClass.getSortedList();
        checkAll(unsortedList, sortedList);
    }

    void testAscendingCase(int num){
        List<Integer> unsortedList = new ArrayList<>();
        for(int i=0; i<num; i++){
            unsortedList.add(rd.nextInt());
        }
        Collections.sort(unsortedList);
        SortingClass sortingClass = new SortingClass(unsortedList);
        List<Integer> sortedList = sortingClass.getSortedList();
        checkAll(unsortedList, sortedList);
    }

    void testDescendingCase(int num){
        List<Integer> unsortedList = new ArrayList<>();
        for(int i=0; i<num; i++){
            unsortedList.add(rd.nextInt());
        }
        Collections.sort(unsortedList, Collections.reverseOrder());
        SortingClass sortingClass = new SortingClass(unsortedList);
        List<Integer> sortedList = sortingClass.getSortedList();
        checkAll(unsortedList, sortedList);
    }

    void testAllEqualCase(int num){
        List<Integer> unsortedList = new ArrayList<>();
        Random rd = new Random();
        int val = rd.nextInt();
        for(int i=0; i<num; i++){
            unsortedList.add(val);
        }
        Collections.sort(unsortedList);
        SortingClass sortingClass = new SortingClass(unsortedList);
        List<Integer> sortedList = sortingClass.getSortedList();
        checkAll(unsortedList, sortedList);
    }

    void checkAll(List<Integer> unsortedList, List<Integer> sortedList){
        assertEquals(sizePreserved(unsortedList, sortedList), true);
        assertEquals(allElementsPresent(unsortedList, sortedList), true);
        assertEquals(correctlySorted(sortedList), true);
    }

    boolean sizePreserved(List<Integer> unsortedList, List<Integer> sortedList){
        boolean preserved = true;
        if(unsortedList.size()!=sortedList.size()){
            preserved = false;
        }
        return preserved;
    }

    boolean allElementsPresent(List<Integer> unsortedList, List<Integer> sortedList){
        boolean present = true;
        for(int i=0; i<sortedList.size(); i++){
            if(!unsortedList.contains(sortedList.get(i))){
                present = false;
                break;
            }
        }
        return present;
    }

    boolean correctlySorted(List<Integer> sortedList){
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