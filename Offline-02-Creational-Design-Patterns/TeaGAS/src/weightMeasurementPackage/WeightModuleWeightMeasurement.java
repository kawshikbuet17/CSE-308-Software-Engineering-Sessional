package weightMeasurementPackage;

public class WeightModuleWeightMeasurement implements WeightMeasurement{
    String name;

    public WeightModuleWeightMeasurement(){
        name = "Weight Module Weight Measurement";
    }
    @Override
    public String getWeightMeasurement() {
        return name;
    }
}
