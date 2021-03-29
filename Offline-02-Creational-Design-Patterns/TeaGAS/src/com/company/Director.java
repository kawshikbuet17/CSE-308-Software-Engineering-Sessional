package com.company;

import builderPackage.Builder;
import connectionPackage.Connection;
import connectionPackage.EthernetConnection;
import connectionPackage.GSMConnection;
import connectionPackage.WiFiConnection;
import displayPackage.Display;
import displayPackage.LCDDisplay;
import displayPackage.LEDDisplay;
import displayPackage.TouchScreenDisplay;
import frameWorkPackage.DjangoFrameWork;
import frameWorkPackage.FrameWork;
import frameWorkPackage.LaravelFrameWork;
import frameWorkPackage.SpringFrameWork;
import identificationPackage.Identification;
import identificationPackage.NFCIdentification;
import identificationPackage.RFIDIdentification;
import microControllerPackage.ATMega32;
import microControllerPackage.Arduino;
import microControllerPackage.MicroController;
import microControllerPackage.RaspberryPi;
import storagePackage.SDcard;
import weightMeasurementPackage.LoadSensorWeightMeasurement;
import weightMeasurementPackage.WeightMeasurement;
import weightMeasurementPackage.WeightModuleWeightMeasurement;

public class Director {
    String connection;
    String framework;

    public void setRequirement(String connection, String framework){
        this.connection = connection;
        this.framework = framework;
    }

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

        switch (connection) {
            case "wifi" -> {
                Connection conn = new WiFiConnection();
                builder.setConnection(conn);
                break;
            }
            case "gsm" -> {
                Connection conn = new GSMConnection();
                builder.setConnection(conn);
                break;
            }
            case "ethernet" -> {
                Connection conn = new EthernetConnection();
                builder.setConnection(conn);
                break;
            }
        }

        switch (framework) {
            case "django" -> {
                FrameWork fw = new DjangoFrameWork();
                builder.setFrameWork(fw);
                break;
            }
            case "spring" -> {
                FrameWork fw = new SpringFrameWork();
                builder.setFrameWork(fw);
                break;
            }
            case "laravel" -> {
                FrameWork fw = new LaravelFrameWork();
                builder.setFrameWork(fw);
                break;
            }
        }


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

        switch (connection) {
            case "wifi" -> {
                Connection conn = new WiFiConnection();
                builder.setConnection(conn);
                break;
            }
            case "gsm" -> {
                Connection conn = new GSMConnection();
                builder.setConnection(conn);
                break;
            }
            case "ethernet" -> {
                Connection conn = new EthernetConnection();
                builder.setConnection(conn);
                break;
            }
        }

        switch (framework) {
            case "django" -> {
                FrameWork fw = new DjangoFrameWork();
                builder.setFrameWork(fw);
                break;
            }
            case "spring" -> {
                FrameWork fw = new SpringFrameWork();
                builder.setFrameWork(fw);
                break;
            }
            case "laravel" -> {
                FrameWork fw = new LaravelFrameWork();
                builder.setFrameWork(fw);
                break;
            }
        }
    }

    public void constructDiamond(Builder builder){
        // Pi with load sensor
        MicroController mc = new RaspberryPi();
        builder.setMicroController(mc);

        WeightMeasurement wm = new LoadSensorWeightMeasurement();
        builder.setWeightMeasurement(wm);

        Identification id = new NFCIdentification();
        builder.setIdentification(id);

        Display dp = new TouchScreenDisplay();
        builder.setDisplay(dp);

        switch (connection) {
            case "wifi" -> {
                Connection conn = new WiFiConnection();
                builder.setConnection(conn);
                break;
            }
            case "gsm" -> {
                Connection conn = new GSMConnection();
                builder.setConnection(conn);
                break;
            }
            case "ethernet" -> {
                Connection conn = new EthernetConnection();
                builder.setConnection(conn);
                break;
            }
        }

        switch (framework) {
            case "django" -> {
                FrameWork fw = new DjangoFrameWork();
                builder.setFrameWork(fw);
                break;
            }
            case "spring" -> {
                FrameWork fw = new SpringFrameWork();
                builder.setFrameWork(fw);
                break;
            }
            case "laravel" -> {
                FrameWork fw = new LaravelFrameWork();
                builder.setFrameWork(fw);
                break;
            }
        }
    }

    public void constructPlatinum(Builder builder){
        //Raspberry Pi with weight module
        MicroController mc = new RaspberryPi();
        builder.setMicroController(mc);

        WeightMeasurement wm = new WeightModuleWeightMeasurement();
        builder.setWeightMeasurement(wm);

        Identification id = new NFCIdentification();
        builder.setIdentification(id);

        Display dp = new TouchScreenDisplay();
        builder.setDisplay(dp);

        switch (connection) {
            case "wifi" -> {
                Connection conn = new WiFiConnection();
                builder.setConnection(conn);
                break;
            }
            case "gsm" -> {
                Connection conn = new GSMConnection();
                builder.setConnection(conn);
                break;
            }
            case "ethernet" -> {
                Connection conn = new EthernetConnection();
                builder.setConnection(conn);
                break;
            }
        }

        switch (framework) {
            case "django" -> {
                FrameWork fw = new DjangoFrameWork();
                builder.setFrameWork(fw);
                break;
            }
            case "spring" -> {
                FrameWork fw = new SpringFrameWork();
                builder.setFrameWork(fw);
                break;
            }
            case "laravel" -> {
                FrameWork fw = new LaravelFrameWork();
                builder.setFrameWork(fw);
                break;
            }
        }
    }
}
