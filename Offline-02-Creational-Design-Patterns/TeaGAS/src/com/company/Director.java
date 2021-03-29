package com.company;

public class Director {
    public void constructSilver(Builder builder){
        //ATMega32 with load sensor
        MicroController mc = new ATMega32();
        builder.setMicroController(mc);

        WeightMeasurement wm = new LoadSensorWeightMeasurement();
        builder.setWeightMeasurement(wm);

        Identification id = new RFIDIdentification();
        builder.setIdentification(id);

        SDcard sd = new SDcard();
        builder.setStorage(sd);

        Display dp = new LCDDisplay();
        builder.setDisplay(dp);

        Connection conn = new WiFiConnection();
        builder.setConnection(conn);

        FrameWork fw = new DjangoFrameWork();
        builder.setFrameWork(fw);

    }

    public void constructGold(Builder builder){
        //Arduino with weight module
        MicroController mc = new Arduino();
        builder.setMicroController(mc);

        WeightMeasurement wm = new WeightModuleWeightMeasurement();
        builder.setWeightMeasurement(wm);

        Identification id = new RFIDIdentification();
        builder.setIdentification(id);

        SDcard sd = new SDcard();
        builder.setStorage(sd);

        Display dp = new LEDDisplay();
        builder.setDisplay(dp);

        Connection conn = new WiFiConnection();
        builder.setConnection(conn);

        FrameWork fw = new DjangoFrameWork();
        builder.setFrameWork(fw);
    }

    public void constructDiamond(Builder builder){
        // Pi with load sensor
        MicroController mc = new RaspberryPi();
        builder.setMicroController(mc);

        WeightMeasurement wm = new LoadSensorWeightMeasurement();
        builder.setWeightMeasurement(wm);

        Identification id = new NFCIdentification();
        builder.setIdentification(id);

        Display dp = new TouchScreen();
        builder.setDisplay(dp);

        Connection conn = new WiFiConnection();
        builder.setConnection(conn);

        FrameWork fw = new DjangoFrameWork();
        builder.setFrameWork(fw);
    }

    public void constructPlatinum(Builder builder){
        //Raspberry Pi with weight module
        MicroController mc = new RaspberryPi();
        builder.setMicroController(mc);

        WeightMeasurement wm = new WeightModuleWeightMeasurement();
        builder.setWeightMeasurement(wm);

        Identification id = new NFCIdentification();
        builder.setIdentification(id);

        Display dp = new TouchScreen();
        builder.setDisplay(dp);

        Connection conn = new WiFiConnection();
        builder.setConnection(conn);

        FrameWork fw = new DjangoFrameWork();
        builder.setFrameWork(fw);
    }
}
