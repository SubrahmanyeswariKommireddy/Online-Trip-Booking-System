package com.sprint.otms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment_otms_details")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "Transaction_Mode")
	private TransactionMode transactionMode;
	
	@OneToOne
	private Booking booking;

	public Payment() {
		super();
	}

	public Payment(Long transactionId, TransactionMode transactionMode, Booking booking) {
		super();
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.booking = booking;
	}

	public Payment(TransactionMode transactionMode, Booking booking) {
		super();
		this.transactionMode = transactionMode;
		this.booking = booking;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionMode getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(TransactionMode transactionMode) {
		this.transactionMode = transactionMode;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Payment [transactionId=" + transactionId + ", transactionMode=" + transactionMode + ", booking="
				+ booking + "]";
	}	
}
