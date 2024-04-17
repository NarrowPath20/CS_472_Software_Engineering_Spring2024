package spring2024.cs472.hotelwebsite.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Will be stored for Guests' viewing of reservations in their account
@Entity
public class ReservationDetails implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Guest guest;

	@OneToMany
	private List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();
	private String paymentInformation;
	private double total = 0;

	protected ReservationDetails() {
	}

	//Generated by Cart
	public ReservationDetails(Guest guest, List<RoomReservation> reservations, String paymentInformation, double total) {
		super();
		this.guest = guest;
		this.roomReservations.addAll(reservations);
		this.paymentInformation = paymentInformation;
		this.total = total;
	}

	public String getPaymentInformation() {
		return paymentInformation;
	}
	public void setPaymentInformation(String paymentInformation) {
		this.paymentInformation = paymentInformation;
	}


	public Guest getGuest() {
		return guest;
	}

	public List<RoomReservation> getRoomReservations() {
		return roomReservations;
	}
	public void addRoomReservation(RoomReservation roomreservation) {
		this.roomReservations.add(roomreservation);
	}
	public void addRoomReservations(List<RoomReservation> reservations) {
		this.roomReservations.addAll(reservations);
	}
	public Long getId() {
		return id;
	}


}