package com.company;

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
