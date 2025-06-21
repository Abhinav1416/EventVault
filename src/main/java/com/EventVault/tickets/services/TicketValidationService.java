package com.EventVault.tickets.services;

import com.EventVault.tickets.domain.entities.TicketValidation;
import java.util.UUID;

public interface TicketValidationService {
  TicketValidation validateTicketByQrCode(UUID qrCodeId);
  TicketValidation validateTicketManually(UUID ticketId);
}
