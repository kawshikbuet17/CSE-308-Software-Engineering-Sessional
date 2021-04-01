package frameWorkPackage;

public class DjangoFrameWork implements FrameWork{
    String name;

    public DjangoFrameWork(){
        name = "Django";
    }
    @Override
    public String getFrameWork() {
        return name;
    }
}
