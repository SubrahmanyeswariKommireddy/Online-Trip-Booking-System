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

/**
 * 
 * @author Satish
 *
 */
@Entity
@Table(name = "payment_tableOne1")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "Transaction_Mode")
	private TransactionMode transactionMode;
	private Float amount;

	@OneToOne
	private Booking booking;

	/**
	 * 
	 */
	public Payment() {
		super();
	}

	/**
	 * @param transactionId
	 * @param transactionMode
	 * @param booking
	 */
	public Payment(Long transactionId, TransactionMode transactionMode, Booking booking) {
		super();
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.booking = booking;
	}

	/**
	 * @param transactionMode
	 * @param booking
	 */
	public Payment(TransactionMode transactionMode, Booking booking) {
		super();
		this.transactionMode = transactionMode;
		this.booking = booking;
	}

	/**
	 * @param transactionId
	 * @param transactionMode
	 * @param amount
	 * @param booking
	 */
	public Payment(Long transactionId, TransactionMode transactionMode, Float amount, Booking booking) {
		super();
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.amount = amount;
		this.booking = booking;
	}

	/**
	 * @return Amount
	 */
	public Float getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	/**
	 * @param transactionId
	 */
	public Payment(Long transactionId) {
		super();
		this.transactionId = transactionId;
	}

	/**
	 * @return transaction By Id
	 */
	public Long getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return Mode Of Transaction
	 */
	public TransactionMode getTransactionMode() {
		return transactionMode;
	}

	/**
	 * @param transactionMode
	 */
	public void setTransactionMode(TransactionMode transactionMode) {
		this.transactionMode = transactionMode;
	}

	/**
	 * @return all Bookings
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Payment [transactionId=" + transactionId + ", transactionMode=" + transactionMode + ", amount=" + amount
				+ ", booking=" + booking + "]";
	}
}
