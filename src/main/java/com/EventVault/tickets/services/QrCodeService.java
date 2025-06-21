package com.EventVault.tickets.services;

import com.EventVault.tickets.domain.entities.QrCode;
import com.EventVault.tickets.domain.entities.Ticket;
import java.util.UUID;

public interface QrCodeService {

  QrCode generateQrCode(Ticket ticket);

  byte[] getQrCodeImageForUserAndTicket(UUID userId, UUID ticketId);
}
