package code;

import java.util.ArrayList;
import java.util.List;

public class SortingClass {
    private List<Integer> list;

    SortingClass(List<Integer> list){
        this.list = new ArrayList<>(list);
    }

    public List<Integer> getSortedList(){
        int n = list.size();
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(list.get(j) > list.get(j+1)){
                    int t = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, t);
                }
            }
        }
        return list;
    }
}
