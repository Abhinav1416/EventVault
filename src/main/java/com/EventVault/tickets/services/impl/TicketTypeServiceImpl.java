package com.EventVault.tickets.services.impl;

import com.EventVault.tickets.domain.entities.Ticket;
import com.EventVault.tickets.domain.entities.TicketStatusEnum;
import com.EventVault.tickets.domain.entities.TicketType;
import com.EventVault.tickets.domain.entities.User;
import com.EventVault.tickets.exceptions.TicketTypeNotFoundException;
import com.EventVault.tickets.exceptions.TicketsSoldOutException;
import com.EventVault.tickets.exceptions.UserNotFoundException;
import com.EventVault.tickets.repositories.TicketRepository;
import com.EventVault.tickets.repositories.TicketTypeRepository;
import com.EventVault.tickets.repositories.UserRepository;
import com.EventVault.tickets.services.QrCodeService;
import com.EventVault.tickets.services.TicketTypeService;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {

  private final UserRepository userRepository;
  private final TicketTypeRepository ticketTypeRepository;
  private final TicketRepository ticketRepository;
  private final QrCodeService qrCodeService;

  @Override
  @Transactional
  public Ticket purchaseTicket(UUID userId, UUID ticketTypeId) {
    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
        String.format("User with ID %s was not found", userId)
    ));

    TicketType ticketType = ticketTypeRepository.findByIdWithLock(ticketTypeId)
        .orElseThrow(() -> new TicketTypeNotFoundException(
            String.format("Ticket type with ID %s was not found", ticketTypeId)
        ));

    int purchasedTickets = ticketRepository.countByTicketTypeId(ticketType.getId());
    Integer totalAvailable = ticketType.getTotalAvailable();

    if(purchasedTickets + 1 > totalAvailable) {
      throw new TicketsSoldOutException();
    }

    Ticket ticket = new Ticket();
    ticket.setStatus(TicketStatusEnum.PURCHASED);
    ticket.setTicketType(ticketType);
    ticket.setPurchaser(user);

    Ticket savedTicket = ticketRepository.save(ticket);
    qrCodeService.generateQrCode(savedTicket);

    return ticketRepository.save(savedTicket);
  }
}
