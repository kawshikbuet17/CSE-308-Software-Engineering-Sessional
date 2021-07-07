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
            unsortedList.add(rd.nextInt());
        }
        Collections.sort(unsortedList);
        sortingClass = new SortingClass(unsortedList);
        sortedList = sortingClass.getSortedList();
        checkAll();
    }

    void testDescendingCase(int num){
        unsortedList = new ArrayList<>();
        for(int i=0; i<num; i++){
            unsortedList.add(rd.nextInt());
        }
        Collections.sort(unsortedList, Collections.reverseOrder());
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
        Collections.sort(unsortedList);
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
        boolean present = true;
        for(int i=0; i<sortedList.size(); i++){
            if(!unsortedList.contains(sortedList.get(i))){
                present = false;
                break;
            }
        }
        return present;
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