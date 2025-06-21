package com.EventVault.tickets.mappers;

import com.EventVault.tickets.domain.CreateEventRequest;
import com.EventVault.tickets.domain.CreateTicketTypeRequest;
import com.EventVault.tickets.domain.UpdateEventRequest;
import com.EventVault.tickets.domain.UpdateTicketTypeRequest;
import com.EventVault.tickets.domain.dtos.CreateEventRequestDto;
import com.EventVault.tickets.domain.dtos.CreateEventResponseDto;
import com.EventVault.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.EventVault.tickets.domain.dtos.GetEventDetailsResponseDto;
import com.EventVault.tickets.domain.dtos.GetEventDetailsTicketTypesResponseDto;
import com.EventVault.tickets.domain.dtos.GetPublishedEventDetailsResponseDto;
import com.EventVault.tickets.domain.dtos.GetPublishedEventDetailsTicketTypesResponseDto;
import com.EventVault.tickets.domain.dtos.ListEventResponseDto;
import com.EventVault.tickets.domain.dtos.ListEventTicketTypeResponseDto;
import com.EventVault.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.EventVault.tickets.domain.dtos.UpdateEventRequestDto;
import com.EventVault.tickets.domain.dtos.UpdateEventResponseDto;
import com.EventVault.tickets.domain.dtos.UpdateTicketTypeRequestDto;
import com.EventVault.tickets.domain.dtos.UpdateTicketTypeResponseDto;
import com.EventVault.tickets.domain.entities.Event;
import com.EventVault.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

  CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

  CreateEventRequest fromDto(CreateEventRequestDto dto);

  CreateEventResponseDto toDto(Event event);

  ListEventTicketTypeResponseDto toDto(TicketType ticketType);

  ListEventResponseDto toListEventResponseDto(Event event);

  GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(
      TicketType ticketType);

  GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

  UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);

  UpdateEventRequest fromDto(UpdateEventRequestDto dto);

  UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

  UpdateEventResponseDto toUpdateEventResponseDto(Event event);

  ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);

  GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(
      TicketType ticketType);

  GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event);
}
