package com.EventVault.tickets.services;

import com.EventVault.tickets.domain.entities.Ticket;
import java.util.UUID;

public interface TicketTypeService {
  Ticket purchaseTicket(UUID userId, UUID ticketTypeId);
}
