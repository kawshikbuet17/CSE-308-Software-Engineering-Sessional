package frameWorkPackage;

public class LaravelFrameWork implements FrameWork{
    String name;

    public LaravelFrameWork(){
        name = "Laravel";
    }
    @Override
    public String getFrameWork() {
        return name;
    }
}
