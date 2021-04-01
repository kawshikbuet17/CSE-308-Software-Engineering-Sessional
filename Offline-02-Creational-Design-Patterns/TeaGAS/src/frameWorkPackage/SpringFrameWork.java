package frameWorkPackage;

public class SpringFrameWork implements FrameWork{
    String name;

    public SpringFrameWork(){
        name = "Spring";
    }

    @Override
    public String getFrameWork() {
        return name;
    }
}
