import Service.FixInfo;
import entity.InputInfo;
import entity.Output;
import entity.Taxi;
import input.InputParam;
import org.junit.Test;
import output.OutputInfo;

import java.util.List;

public class InputParamTest {
    @Test
    public void getTaxiTest(){
        String str = "CAR0002|2029/10/14|Porsche|9000|F";
        Taxi taxi = new InputParam().getTaxi(str);

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
        List<Taxi> taxis = new InputParam().getTaxiInfo(str).getCheckTaxis();
        InputInfo taxiInfo = new InputParam().getTaxiInfo(str);
        FixInfo fixInfo = new FixInfo(taxiInfo);
        Output output = fixInfo.getAllTypeCarsList();
        System.out.println(new OutputInfo().printOutput(output).toString());
    }
}
