import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class Driver
{
    public static void main(String[] args){
        if(args.length < 0) {
            System.out.println("API Key and Base URL are required parameters");
            System.exit(1);
        }

        BreezeCall newCall = new BreezeCall(args[0],args[1]);
        ArrayList<Calendar> calInfo = null;
        try{
            calInfo = newCall.getCalIDs();
        }catch (Exception ex){
            ex.printStackTrace();
            System.exit(1);
        }
        MainUI uiInit = new MainUI(calInfo);
    }
}
