package Utils;

import Enums.Constants;

public abstract class Utils {
    public static double totalWithTVA(double total) {
        return total + total * Constants.TVA/100;
    }
}
