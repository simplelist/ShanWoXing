package com.yxtar.server.cassandra.dao.respository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.cassandra.PaymentRecord;

@Repository
public interface PaymentRecordRespository extends CrudRepository<PaymentRecord, UUID>{

	@Query("select * from payment_record where id=?0 ;")
	PaymentRecord findById(UUID recordId);
}
