package com.company;

public class TeaGAS {
    private MicroController microController;
    private WeightMeasurement weightMeasurement;
    private Identification identification;
    private SDcard storage;
    private Display display;
    private Connection internetConnection;
    private FrameWork frameWork;

    public TeaGAS(MicroController microController, WeightMeasurement weightMeasurement, Identification identification, SDcard storage, Display display, Connection internetConnection, FrameWork frameWork) {
        this.microController = microController;
        this.weightMeasurement = weightMeasurement;
        this.identification = identification;
        this.storage = storage;
        this.display = display;
        this.internetConnection = internetConnection;
        this.frameWork = frameWork;
    }

    public void getTeaGASPrint(){
        System.out.println("MicroController/MicroProcessor :" + microController);
        System.out.println("WeightMeasurement : " + weightMeasurement);
        System.out.println("Identification : " + identification);
        System.out.println("SDcard : " + storage);
        System.out.println("Display : " + display);
        System.out.println("Connection : " + internetConnection);
        System.out.println("FrameWork : " + frameWork);
    }
}
