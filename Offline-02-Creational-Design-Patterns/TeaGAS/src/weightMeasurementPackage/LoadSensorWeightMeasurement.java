package weightMeasurementPackage;

public class LoadSensorWeightMeasurement implements WeightMeasurement{
    String name;

    public LoadSensorWeightMeasurement(){
        name = "Load Sensor Weight Measurement";
    }
    @Override
    public String getWeightMeasurement() {
        return name;
    }
}
