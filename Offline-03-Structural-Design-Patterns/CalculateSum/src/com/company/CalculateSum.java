package com.company;

import java.io.File;

public class CalculateSum implements Sum{
    DecimalAsciiAdapter sumAdapter;
    String type;
    File fileObj;

    CalculateSum(String type, File fileObj){
        this.type = type;
        this.fileObj = fileObj;
    }
    @Override
    public int getSum() {
        if(type.equalsIgnoreCase("decimal")){
            Sum sum = new DecimalSum(fileObj);
            return sum.getSum();
        }
        else if(type.equalsIgnoreCase("ascii")){
            Sum sum = new DecimalAsciiAdapter(fileObj);
            return sum.getSum();
        }
        return 0;
    }
}
