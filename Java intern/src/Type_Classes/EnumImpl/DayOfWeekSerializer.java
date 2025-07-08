package Type_Classes.EnumImpl;

import java.io.*;

public class DayOfWeekSerializer {

    public static void serializeDay(Days days, OutputStream out) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(out); //Позволява на пишем примитивни типове
        dataOutputStream.writeInt(days.getValue());//Взимаме стойноста на enum-a и я записваме в сриима
        dataOutputStream.flush();
    }

    public static Days deserializeDay(InputStream in) throws IOException {

        DataInputStream dataInputStream = new DataInputStream(in);
        int dayValue = dataInputStream.readInt();
        return Days.fromValue(dayValue);
    }
}
