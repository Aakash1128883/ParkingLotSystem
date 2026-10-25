package com.parking.repository;

import com.parking.model.ParkingTicket;
import java.util.ArrayList;

public class ParkingTicketRepository {
    private ArrayList<ParkingTicket> tickets = new ArrayList<>();
    private int ticketCounter = 1;

    public String generateTicketId() {
        return String.format("TKT%03d", ticketCounter++);
    }

    public void save(ParkingTicket ticket) { tickets.add(ticket); }

    public ParkingTicket findActiveTicketByVehicle(String registrationNumber) {
        for (ParkingTicket ticket : tickets) {
            if (ticket.isActive()
                    && ticket.getVehicle().getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                return ticket;
            }
        }
        return null;
    }

    public ArrayList<ParkingTicket> getActiveTickets() {
        ArrayList<ParkingTicket> active = new ArrayList<>();
        for (ParkingTicket ticket : tickets) {
            if (ticket.isActive()) {
                active.add(ticket);
            }
        }
        return active;
    }
}
