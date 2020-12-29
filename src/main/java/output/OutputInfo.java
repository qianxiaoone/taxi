package output;


import entity.Output;
import entity.Taxi;

import java.util.List;

/**
 * @author wang-hc
 */
public class OutputInfo {
    public StringBuilder printOutput(Output output) {
        StringBuilder out = new StringBuilder();
        out.append("\n" +
                "Reminder\n" +
                "\n" +
                "==================\n");
        StringBuilder writeOffStr = new StringBuilder();
        StringBuilder distanceRelatedStr = new StringBuilder();
        StringBuilder timeRelatedStr = new StringBuilder();
        if (output.getWriteOffTaxi().size() != 0) {
            writeOffStr.append("\n" +
                    "* Write-off coming soon...")
                    .append(getInfoFromTaxiList(output.getWriteOffTaxi()));
        }
        if (output.getDistanceRelatedMaintenanceTaxi().size() != 0) {
            distanceRelatedStr.append("\n" +
                    "* Distance-related maintenance coming soon...")
                    .append(getInfoFromTaxiList(output.getDistanceRelatedMaintenanceTaxi()));
        }
        if (output.getTimeRelatedMaintenanceTaxi().size() != 0) {
            timeRelatedStr.append("\n" +
                    "* Time-related maintenance coming soon...")
                    .append(getInfoFromTaxiList(output.getTimeRelatedMaintenanceTaxi()));
        }
        return out.append(timeRelatedStr).append(distanceRelatedStr).append(writeOffStr);
    }

    StringBuilder getInfoFromTaxiList(List<Taxi> taxis) {
        String brandName = taxis.get(0).getBrandName();
        int number = 1;
        StringBuilder cardNo = new StringBuilder();
        cardNo.append(taxis.get(0).getTaxiNo());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taxis.size(); i++) {
            if (i == 0 && taxis.size() == 1) {
                result.append(appendStr(brandName, number, cardNo));
                break;
            }
            if (i == 0) {
                continue;
            }
            if (brandName.equals(taxis.get(i).getBrandName())) {
                number++;
                cardNo.append(",").append(taxis.get(i).getTaxiNo());
                if (i == taxis.size() - 1) {
                    result.append(appendStr(brandName, number, cardNo));
                    break;
                }
                continue;
            }
            result.append(appendStr(brandName, number, cardNo));
            brandName = taxis.get(i).getBrandName();
            number = 1;
            cardNo.setLength(0);
            cardNo.append(taxis.get(i).getTaxiNo());
            if (i == taxis.size() - 1) {
                result.append(appendStr(brandName, number, cardNo));
//                result.append("\n").append(brandName).append(":")
//                        .append(number).append("(").append(cardNo).append(")");
            }
        }
        return result.append("\n");
    }

    StringBuilder appendStr(String brandName, int number, StringBuilder cardNo) {
        StringBuilder result = new StringBuilder();
        return result.append("\n").append(brandName).append(":")
                .append(number).append("(").append(cardNo).append(")");
    }

}
