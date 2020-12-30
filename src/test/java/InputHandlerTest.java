import Service.ReminderCars;
import Service.InputHandler;
import entity.InputInfo;
import entity.OutputParam;
import entity.Taxi;
import org.junit.Test;
import Service.OutputHandler;

import java.util.List;

public class InputHandlerTest {
    @Test
    public void getTaxiTest(){
        String str = "CAR0002|2029/10/14|Porsche|9000|F";
        Taxi taxi = new InputHandler().getTaxi(str);

        str = "SubmitDate: 2050/05/01\n" +
                "\n" +
                "CAR0001|2044/05/01|Volkswagen|65535|F\n" +
                "\n" +
                "CAR0002|2044/05/03|BMW|100001|F\n" +
                "\n" +
                "CAR0003|2047/05/02|Mercedes-Benz|37789|T\n" +
                "\n" +
                "CAR0004|2047/05/03|Honda|59908|T\n" +
                "\n" +
                "CAR0005|2049/12/10|Peugeot|49999|F\n" +
                "\n" +
                "CAR0006|2046/11/15|Jeep|2000|F\n" +
                "\n" +
                "CAR0007|2046/11/16|Jeep|5000|F";
        List<Taxi> taxis = new InputHandler().getTaxiInfo(str).getCheckTaxis();
        InputInfo taxiInfo = new InputHandler().getTaxiInfo(str);
        ReminderCars reminderCars = new ReminderCars(taxiInfo);
        OutputParam outputParam = reminderCars.getAllTypeCarsList();
        System.out.println(new OutputHandler().printOutput(outputParam).toString());
    }
}
