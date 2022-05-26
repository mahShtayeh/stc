package com.stc.leaves.repositories;

import com.stc.leaves.entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
}
