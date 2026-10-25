package com.parking.service;

import com.parking.model.ParkingSlot;
import com.parking.model.ParkingTicket;
import com.parking.model.Vehicle;
import com.parking.repository.ParkingSlotRepository;
import com.parking.repository.ParkingTicketRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParkingService {
    private ParkingSlotRepository slotRepository;
    private ParkingTicketRepository ticketRepository;

    public ParkingService(ParkingSlotRepository slotRepository, ParkingTicketRepository ticketRepository) {
        this.slotRepository = slotRepository;
        this.ticketRepository = ticketRepository;
    }

    public ArrayList<ParkingSlot> getAllSlots() { return slotRepository.getAllSlots(); }

    public ArrayList<ParkingTicket> getActiveTickets() { return ticketRepository.getActiveTickets(); }

    public ParkingTicket findActiveTicket(String registrationNumber) {
        return ticketRepository.findActiveTicketByVehicle(registrationNumber);
    }

    public boolean isVehicleParked(String registrationNumber) {
        return findActiveTicket(registrationNumber) != null;
    }

    // Returns the ticket, or null if parking is full
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        ParkingSlot slot = slotRepository.findFirstFreeSlot(vehicle.getVehicleType());
        if (slot == null && vehicle.getVehicleType().equals("BIKE")) {
            slot = slotRepository.findFirstFreeSlot("CAR");   // Bike can use a Car slot
        }
        if (slot == null) {
            return null;
        }
        slot.occupy();
        ParkingTicket ticket = new ParkingTicket(ticketRepository.generateTicketId(),
                vehicle, slot, LocalDateTime.now());
        ticketRepository.save(ticket);
        return ticket;
    }

    // Called only after a successful payment
    public void completeExit(ParkingTicket ticket, LocalDateTime exitTime) {
        ticket.close(exitTime);
        ticket.getSlot().free();
    }
}
