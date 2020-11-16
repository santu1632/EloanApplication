package com.iiht.evaluation.eloan.model;

public class LoanInfo {
	private String applno;
	private String purpose;
	private double amtrequest;
	private String doa;
	private String bstructure;
	private String bindicator;
	private String address;

	@Override
	public String toString() {
		return "LoanInfo [applno=" + applno + ", purpose=" + purpose + ", amtrequest=" + amtrequest + ", doa=" + doa
				+ ", bstructure=" + bstructure + ", bindicator=" + bindicator + ", address=" + address + ", email="
				+ email + ", mobile=" + mobile + ",amtEligible=" + amtEligible + ",Rate_of_Interest=" + Rate_of_Interest
				+ ",monthlyPayment=" + monthlyPayment + ",termPaymentAmount=" + termPaymentAmount + ",status=" + status
				+ "]";
	}

	private String email;
	private String mobile;
	private String status;
	private String typeOfLoan;
	private boolean taxindicator;
	private int loanTenure;
	private double amtEligible;
	private double Rate_of_Interest;
	private double monthlyPayment;
	private double termPaymentAmount;

	public String getTypeOfLoan() {
		return typeOfLoan;
	}

	public void setTypeOfLoan(String typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}

	public boolean isTaxindicator() {
		return taxindicator;
	}

	public void setTaxindicator(boolean taxindicator) {
		this.taxindicator = taxindicator;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public LoanInfo() {

	}

	public LoanInfo(String applno, String purpose, int amtrequest, String doa, String bstructure, String bindicator,
			String address, String email, String mobile, String status, boolean taxindicator, String typeOfLoan,
			double amtEligible, double monthlyPayment, double termPaymentAmount, double Rate_of_Interest) {
		super();
		this.applno = applno;
		this.purpose = purpose;
		this.amtrequest = amtrequest;
		this.doa = doa;
		this.bstructure = bstructure;
		this.bindicator = bindicator;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.taxindicator = taxindicator;
		this.typeOfLoan = typeOfLoan;
		this.amtEligible = amtEligible;
		this.monthlyPayment = monthlyPayment;
		this.termPaymentAmount = termPaymentAmount;
		this.Rate_of_Interest = Rate_of_Interest;
	}

	public double getAmtEligible() {
		return amtEligible;
	}

	public void setAmtEligible(double amtEligible) {
		this.amtEligible = amtEligible;
	}

	public double getRate_of_Interest() {
		return Rate_of_Interest;
	}

	public void setRate_of_Interest(double rate_of_Interest) {
		Rate_of_Interest = rate_of_Interest;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public double getTermPaymentAmount() {
		return termPaymentAmount;
	}

	public void setTermPaymentAmount(double termPaymentAmount) {
		this.termPaymentAmount = termPaymentAmount;
	}

	public String getApplno() {
		return applno;
	}

	public void setApplno(String applno) {
		this.applno = applno;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getDoa() {
		return doa;
	}

	public void setDoa(String doa) {
		this.doa = doa;
	}

	public String getBstructure() {
		return bstructure;
	}

	public void setBstructure(String bstructure) {
		this.bstructure = bstructure;
	}

	public String getBindicator() {
		return bindicator;
	}

	public void setBindicator(String bindicator) {
		this.bindicator = bindicator;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public double getAmtrequest() {
		return amtrequest;
	}

	public void setAmtrequest(double amtrequest) {
		this.amtrequest = amtrequest;
	}

}
