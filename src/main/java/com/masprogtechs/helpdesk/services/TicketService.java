package com.masprogtechs.helpdesk.services;

import com.masprogtechs.helpdesk.entities.ChangeStatus;
import com.masprogtechs.helpdesk.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface TicketService {

    Ticket createOrUpdate(Ticket ticket); // criar ou actualizar ticket

    Optional<Ticket> findById(String id); // encontrar ticket por id


    void delete(String id); // deletar ticket

    Page<Ticket> listTicket(int page, int count); // listar ticket por paginação


    ChangeStatus createChangeStatus(ChangeStatus change); // para alterar os estado do ticket e validar quem alterou


    Iterable<ChangeStatus> listChangeStatus(String ticketId); // validar as alterações feitas de um Ticket


    Page<Ticket> findByCurrentUser(int page, int count, String userId); // cliente pesquisar apenas os tickets dele


    Page<Ticket> findByParameters(int page, int count, String title, String status, String priority); // filtrar por parametro

    Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status, String priority, String userId); // cliente filtrar somente  por parametro os tickets dele


    Page<Ticket> findByNumber(int page, int count, Integer number); // filtrar pelo número

    Iterable<Ticket> findAll(); // encontrar todos os tickets

    Page<Ticket> findByParameterAndAssignedUser(int page, int count,  String title, String status, String priority, String assignedUser ); // técnico logado, quer listar somente ticket atribuidos a ele

}
