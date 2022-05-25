package com.stc.leaves.repositories;

import com.stc.leaves.dtos.EmployeeLeaveResponse;
import com.stc.leaves.entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT e.id as employeeId, e.name as employeeName, COUNT(l.id) as submittedLeavesNum " +
                    "FROM employee e, leave l " +
                    "WHERE e.id = l.employee_id " +
                    "GROUP BY e.id")
    List<EmployeeLeaveResponse> fetch();
}
