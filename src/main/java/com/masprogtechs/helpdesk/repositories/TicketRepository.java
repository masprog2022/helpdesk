package com.masprogtechs.helpdesk.repositories;

import com.masprogtechs.helpdesk.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface TicketRepository extends MongoRepository<Ticket, String> {

    Page<Ticket> findByUserIdOrderByDateDesc(Pageable pageable, String userId);

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
            String title, String status, String priority, Pageable pages
    );

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
            String title, String status, String priority, String userId, Pageable pages
    );

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserOrderByDateDesc(
            String title, String status, String priority, String assignedUser, Pageable pages
    );

    Page<Ticket> findByNumber(Integer number, Pageable pages);



}
