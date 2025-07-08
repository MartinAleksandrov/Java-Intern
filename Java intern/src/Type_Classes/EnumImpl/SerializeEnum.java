package Type_Classes.EnumImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SerializeEnum {


    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();

    public void serializeEnum(Days day) {
        try{
            DayOfWeekSerializer.serializeDay(day,byteOut);

        }catch(IOException e){
            System.out.println(e);
        }
    }

    public Days deserializeEnum() {
        try {
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            Days deserializedDay = DayOfWeekSerializer.deserializeDay(byteIn);
            System.out.println("Deserialized Day: " + deserializedDay);
            System.out.println("Description: " + deserializedDay.getDescription());

            return deserializedDay;

        }catch(IOException e){
            System.out.println(e);
        }
        return null;
    }
}
