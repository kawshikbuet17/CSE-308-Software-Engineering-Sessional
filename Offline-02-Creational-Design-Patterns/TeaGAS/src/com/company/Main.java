package com.company;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new TeaGASBuilder();
        director.constructSilver(builder);

        TeaGAS teaGAS = builder.getResult();
        teaGAS.getTeaGASPrint();
    }
}
