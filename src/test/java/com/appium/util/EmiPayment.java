package com.appium.util;

public class EmiPayment {
    private String loan;
    private String interest;
    private String period;
    private String pFee;
    private String mEMI;
    private String tInterest;
    private String tpFee;
    private String tPayment;

    public EmiPayment(String loan, String interest, String period, String pFee, String mEMI, String tInterest, String tpFee, String tPayment) {
        this.loan = loan;
        this.interest = interest;
        this.period = period;
        this.pFee = pFee;
        this.mEMI = mEMI;
        this.tInterest = tInterest;
        this.tpFee = tpFee;
        this.tPayment = tPayment;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setpFee(String pFee) {
        this.pFee = pFee;
    }

    public void setmEMI(String mEMI) {
        this.mEMI = mEMI;
    }

    public void settInterest(String tInterest) {
        this.tInterest = tInterest;
    }

    public void setTpFee(String tpFee) {
        this.tpFee = tpFee;
    }

    public void settPayment(String tPayment) {
        this.tPayment = tPayment;
    }

    public String getLoan() {
        return loan;
    }

    public String getInterest() {
        return interest;
    }

    public String getPeriod() {
        return period;
    }

    public String getpFee() {
        return pFee;
    }

    public String getmEMI() {
        return mEMI;
    }

    public String gettInterest() {
        return tInterest;
    }

    public String getTpFee() {
        return tpFee;
    }

    public String gettPayment() {
        return tPayment;
    }
}
