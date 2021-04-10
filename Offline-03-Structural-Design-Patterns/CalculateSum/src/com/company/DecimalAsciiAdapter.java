package com.company;

import java.io.*;

public class DecimalAsciiAdapter implements Sum {
    DecimalSum decimalSum;
    public DecimalAsciiAdapter(File fileObj){
        try {
            FileReader fr = new FileReader(fileObj);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter("ascii_to_decimal.txt");
            int c;
            while ((c=br.read()) != -1){
                if(c != 32){
                    fw.write(c+" ");
                }
            }
            fw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File fileObj2 = new File("ascii_to_decimal.txt");
        decimalSum = new DecimalSum(fileObj2);
    }

    @Override
    public int getSum() {
        return decimalSum.getSum();
    }
}
