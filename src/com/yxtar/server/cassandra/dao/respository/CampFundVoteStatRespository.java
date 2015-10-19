package com.yxtar.server.cassandra.dao.respository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.cassandra.CampFundVoteStat;
import com.yxtar.server.dto.cassandra.PK_CampFundVoteStat;

@Repository
public interface CampFundVoteStatRespository extends CrudRepository<CampFundVoteStat, PK_CampFundVoteStat>{

	@Query(" select * from camp_fund_vote_stat where campid=?0 and periodnum=?1;")
	List<CampFundVoteStat> findByIdNum(Integer charityCampId, Integer periodNum);
}
