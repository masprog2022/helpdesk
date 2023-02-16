package com.masprogtechs.helpdesk.services.impl;

import com.masprogtechs.helpdesk.entities.ChangeStatus;
import com.masprogtechs.helpdesk.entities.Ticket;
import com.masprogtechs.helpdesk.repositories.ChangeStatusRepository;
import com.masprogtechs.helpdesk.repositories.TicketRepository;
import com.masprogtechs.helpdesk.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl  implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ChangeStatusRepository changeStatusRepository;

    @Override
    public Ticket createOrUpdate(Ticket ticket) {
        return this.ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> findById(String id) {
        return this.ticketRepository.findById(id);
    }

    @Override
    public void delete(String id) {
       this.ticketRepository.deleteById(id);
    }

    @Override
    public Page<Ticket> listTicket(int page, int count) {
        Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository.findAll(pages);
    }

    @Override
    public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
        return this.changeStatusRepository.save(changeStatus);
    }

    @Override
    public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
        return this.changeStatusRepository.findByTicketIdOrderByDateChangeStatusDesc(ticketId);
    }

    @Override
    public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
        Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository.findByUserIdOrderByDateDesc(pages,userId);
    }

    @Override
    public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
        Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository
                .findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(title, status, priority, pages);
    }

    @Override
    public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status, String priority, String userId) {
        Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository.
                findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
                        title,status,priority, userId, pages);
    }

    @Override
    public Page<Ticket> findByNumber(int page, int count, Integer number) {
        Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository.findByNumber(number, pages);
    }

    @Override
    public Iterable<Ticket> findAll() {
        return this.ticketRepository.findAll();
    }

    @Override
    public Page<Ticket> findByParameterAndAssignedUser(int page, int count, String title, String status, String priority, String assignedUser) {
        Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository.
                findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserOrderByDateDesc(title,status, priority, assignedUser, pages);
    }
}
