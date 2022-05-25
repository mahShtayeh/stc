package com.stc.leaves.repositories;

import com.stc.leaves.entities.Leave;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends CrudRepository<Leave, Integer> {
}
