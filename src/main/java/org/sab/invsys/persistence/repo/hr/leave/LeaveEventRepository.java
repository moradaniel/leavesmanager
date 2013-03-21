package org.sab.invsys.persistence.repo.hr.leave;

import org.sab.invsys.persistence.model.hr.leave.LeaveEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface LeaveEventRepository extends JpaRepository<LeaveEvent, Long>,
		QueryDslPredicateExecutor<LeaveEvent> {

	//public LeaveEvent findByLeaveEventId(String leaveEventId);
}
