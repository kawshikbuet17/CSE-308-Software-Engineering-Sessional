package com.company;

public class TeaGASBuilder implements Builder{
    private MicroController microController;
    private WeightMeasurement weightMeasurement;
    private Identification identification;
    private SDcard storage;
    private Display display;
    private Connection internetConnection;
    private FrameWork frameWork;

    @Override
    public void setMicroController(MicroController mc) {
        this.microController = mc;
    }

    @Override
    public void setWeightMeasurement(WeightMeasurement wm) {
        this.weightMeasurement = wm;
    }

    @Override
    public void setIdentification(Identification id) {
        this.identification = id;
    }

    @Override
    public void setStorage(SDcard sd) {
        this.storage=sd;
    }

    @Override
    public void setDisplay(Display dp) {
        this.display = dp;
    }

    @Override
    public void setConnection(Connection conn) {
        this.internetConnection = conn;
    }

    @Override
    public void setFrameWork(FrameWork fw) {
        this.frameWork = fw;
    }

    public TeaGAS getResult(){
        return new TeaGAS(microController, weightMeasurement, identification,storage,display,internetConnection,frameWork);
    }
}
