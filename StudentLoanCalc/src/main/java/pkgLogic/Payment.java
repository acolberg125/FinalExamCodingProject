package pkgLogic;

import java.time.LocalDate;

public class Payment {
	private int PaymentNbr;
	private LocalDate dueDate;
	private double Payment;
	private double AdditionalPayment;
	private double InterestPayment;
	private double Principle;
	private double EndingBalance;
	
	
	public Payment(double beginningBalance, int paymentNbr, LocalDate dueDate, Loan loan)
	{
		this.PaymentNbr = paymentNbr;
		this.dueDate = dueDate;
		this.Payment = (beginningBalance > loan.GetPMT()) ? loan.GetPMT(): beginningBalance + (beginningBalance * (loan.getInterestRate() / 12));
		this.AdditionalPayment = loan.getAdditionalPayment();
		
		
		InterestPayment = beginningBalance * (loan.getInterestRate() / 12);
		
		
		Principle = loan.GetPMT() + loan.getAdditionalPayment() - InterestPayment;
		EndingBalance = beginningBalance - Principle; 
		
	}
	
	
	
	public int getPaymentNbr() {
		return PaymentNbr;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public double getPayment() {
		return Payment;
	}
	public double getAdditionalPayment() {
		return AdditionalPayment;
	}
	public double getInterestPayment() {
		return InterestPayment;
	}
	public double getPrinciple() {
		return Principle;
	}
	public double getEndingBalance() {
		return EndingBalance;
	}
	public double getTotalPayment() {
		return this.getPayment() + this.AdditionalPayment;
	}
	
	}