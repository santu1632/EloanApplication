package com.iiht.evaluation.eloan.model;

public class ApprovedLoan {
	String applno;
	int amotsanctioned;
	int loanterm;
	String psd;
	String lcd;
	double emi;
	double rateofInterest;
	double totalPayableAmount;
	String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}

	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}

	public ApprovedLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovedLoan(String applno, int amotsanctioned, int loanterm, String psd, String lcd, int emi, double rateofInterest, String status, double totalPayableAmount) {
		super();
		this.applno = applno;
		this.amotsanctioned = amotsanctioned;
		this.loanterm = loanterm;
		this.psd = psd;
		this.lcd = lcd;
		this.status=status;
		this.emi = emi;
		this.rateofInterest=rateofInterest;
		this.totalPayableAmount=totalPayableAmount;
	}

	public double getRateofInterest() {
		return rateofInterest;
	}

	public void setRateofInterest(double rateofInterest) {
		this.rateofInterest = rateofInterest;
	}

	public String getApplno() {
		return applno;
	}

	public void setApplno(String applno) {
		this.applno = applno;
	}

	public int getAmotsanctioned() {
		return amotsanctioned;
	}

	public void setAmotsanctioned(int amotsanctioned) {
		this.amotsanctioned = amotsanctioned;
	}

	public int getLoanterm() {
		return loanterm;
	}

	public void setLoanterm(int loanterm) {
		this.loanterm = loanterm;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String getLcd() {
		return lcd;
	}

	public void setLcd(String lcd) {
		this.lcd = lcd;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	@Override
	public String toString() {
		return "ApprovedLoan [applno=" + applno + ", amotsanctioned=" + amotsanctioned + ", loanterm=" + loanterm
				+ ", psd=" + psd + ", lcd=" + lcd + ", emi=" + emi + ",status=" + status + ",totalPayableAmount=" + totalPayableAmount + ", rateofInterest=" + rateofInterest +"]";
	}
	
	
}
