package com.appium.config;

import com.appium.util.EmiPayment;
import com.appium.util.GeneralUtil;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
    public static List<EmiPayment> getEmiPayments() {
        // Read text from file.
        List<EmiPayment> emiPayments = new ArrayList<>();

        String filePath = System.getProperty("user.dir") + "/src/test/resources/" + GeneralUtil.CSV_FILE;
        System.out.println(filePath);
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String st;
            while ((st = br.readLine()) != null) {
                String[] strings = st.split(",");
                //loan,interest,period,pFee,mEMI,tInterest,tpFee,tPayment
//                System.out.println(strings[0] + " " + strings[1] + "" + strings[2] + " " + strings[3] + " " + strings[4] + " " + strings[5] + "" + strings[6] + " " + strings[7]);
                emiPayments.add(new EmiPayment(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6], strings[7]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emiPayments;
    }

    public static void main(String[] args) {
        for (EmiPayment emiPayment : getEmiPayments()) {
            System.out.println(emiPayment.getLoan());
            System.out.println(emiPayment.getInterest());
            System.out.println(emiPayment.gettPayment());
        }
    }

}
