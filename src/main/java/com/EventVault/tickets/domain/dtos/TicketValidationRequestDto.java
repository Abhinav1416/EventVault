package com.EventVault.tickets.domain.dtos;

import com.EventVault.tickets.domain.entities.TicketValidationMethod;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketValidationRequestDto {
  private UUID id;
  private TicketValidationMethod method;
}
