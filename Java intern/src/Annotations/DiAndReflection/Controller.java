package Annotations.DiAndReflection;

public class Controller {

    //Here we inject dependency with injector that use reflection
    @Inject
    public Service service;

    //Uяe that field
    public void process() {
        service.create();
    }
}
