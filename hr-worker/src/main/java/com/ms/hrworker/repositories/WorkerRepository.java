package com.ms.hrworker.repositories;

import com.ms.hrworker.entities.Worker;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}