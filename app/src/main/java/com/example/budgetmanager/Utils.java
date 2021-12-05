package com.example.budgetmanager;

import java.text.DecimalFormat;

public class Utils {

    public static String formatCurrency(double amount) {
        DecimalFormat formatter = new DecimalFormat("$###,###,##0.00");
        return formatter.format(Double.parseDouble(String.valueOf(amount)));
    }
}
