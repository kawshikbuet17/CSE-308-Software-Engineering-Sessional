package code;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        SortingClass sortingClass = new SortingClass(list);
        list = sortingClass.getSortedList();
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
