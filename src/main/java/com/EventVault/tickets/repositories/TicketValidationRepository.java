package com.EventVault.tickets.repositories;

import com.EventVault.tickets.domain.entities.TicketValidation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketValidationRepository extends JpaRepository<TicketValidation, UUID> {
}
