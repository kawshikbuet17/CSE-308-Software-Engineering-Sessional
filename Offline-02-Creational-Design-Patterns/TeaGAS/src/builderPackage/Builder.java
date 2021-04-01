package builderPackage;

import productPackage.TeaGAS;
import connectionPackage.Connection;
import displayPackage.Display;
import frameWorkPackage.FrameWork;
import identificationPackage.Identification;
import microControllerPackage.MicroController;
import storagePackage.SDcard;
import weightMeasurementPackage.WeightMeasurement;

public interface Builder {
    void setMicroController(MicroController mc);
    void setWeightMeasurement (WeightMeasurement wm);
    void setIdentification (Identification id);
    void setStorage (SDcard sd);
    void setDisplay (Display dp);
    void setConnection (Connection conn);
    void setFrameWork (FrameWork fw);
    TeaGAS getResult();
}
