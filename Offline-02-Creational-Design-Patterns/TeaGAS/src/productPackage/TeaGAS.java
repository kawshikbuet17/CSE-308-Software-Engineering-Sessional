package productPackage;

import connectionPackage.Connection;
import displayPackage.Display;
import frameWorkPackage.FrameWork;
import identificationPackage.Identification;
import microControllerPackage.MicroController;
import storagePackage.SDcard;
import weightMeasurementPackage.WeightMeasurement;

public class TeaGAS {
    private final MicroController microController;
    private final WeightMeasurement weightMeasurement;
    private final Identification identification;
    private final SDcard storage;
    private final Display display;
    private final Connection internetConnection;
    private final FrameWork frameWork;

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
        System.out.println("MicroController/MicroProcessor : " + microController.getMicroController());
        System.out.println("WeightMeasurement : " + weightMeasurement.getWeightMeasurement());
        System.out.println("Identification : " + identification.getIdentification());
        try {
            System.out.println("SDcard : " + storage.getSDcard());
        }
        catch(Exception e) {
            System.out.println("SDcard : Not Inserted");
        }

        System.out.println("Display : " + display.getDisplay());
        System.out.println("Connection : " + internetConnection.getConnection());
        System.out.println("FrameWork : " + frameWork.getFrameWork());
    }
}
