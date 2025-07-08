package com.deepcoder.supportflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepcoder.supportflow.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
/*
 * JpaRepository
 * save(T)
 * findAll() : List<T>
 * findById(long id) : T
 * deleteById(long id): void
 */