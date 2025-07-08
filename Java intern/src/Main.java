import Annotations.DiAndReflection.Controller;
import Annotations.DiAndReflection.DI_Injector;
import Design_Patterns.BuilderP.BuilderExample;
import Type_Classes.EnumImpl.Days;
import Type_Classes.EnumImpl.SerializeEnum;

import java.lang.reflect.InvocationTargetException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Starts Reflection example
        //ReflectionStarter.startReflectionExample();

        //Starts Serialization example
        //SerializeStarter.startSerializationExample();

        //Inject dependency with reflection, this is example that shows how Spring use annotation to inject Dependency
        //Controller controller = new Controller();
        //DI_Injector.injectDependencies(controller);

        //Example for Builder Pattern
        //BuilderExample.printCat();

        //Enum example
        //Days[] day = Days.values();

        //for (Days d : day) {
        //    System.out.println(d + "--> " + d.writeDescription() );
        //}

        SerializeEnum sEnum = new SerializeEnum();
        sEnum.serializeEnum(Days.FRIDAY);
    }
}