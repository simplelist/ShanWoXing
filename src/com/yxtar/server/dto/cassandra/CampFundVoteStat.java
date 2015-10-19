package com.yxtar.server.dto.cassandra;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("camp_fund_vote_stat")
public class CampFundVoteStat extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private PK_CampFundVoteStat pk;
	@CassandraType(type = Name.COUNTER)
	private Long numOfVote;

	public PK_CampFundVoteStat getPk() {
		return pk;
	}

	public void setPk(PK_CampFundVoteStat pk) {
		this.pk = pk;
	}

	public Long getNumOfVote() {
		return numOfVote;
	}

	public void setNumOfVote(Long numOfVote) {
		this.numOfVote = numOfVote;
	}

}
