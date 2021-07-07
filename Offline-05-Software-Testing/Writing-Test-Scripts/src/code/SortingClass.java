package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingClass {
    private List<Integer> list;

    SortingClass(List<Integer> list){
        this.list = new ArrayList<>();
        this.list = list;
    }

    public List<Integer> getSortedList(){
        Collections.sort(list);
        return list;
    }
}
