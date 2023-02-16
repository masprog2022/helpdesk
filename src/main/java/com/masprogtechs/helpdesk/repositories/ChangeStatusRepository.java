package com.masprogtechs.helpdesk.repositories;

import com.masprogtechs.helpdesk.entities.ChangeStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String > {

    Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);
}
