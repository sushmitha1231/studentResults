package com.studentResults.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentResults.entity.Results;
import com.studentResults.repository.ResultsRepository;

@Repository
public class ResultsDao {
	@Autowired
	ResultsRepository rr;

	public String setAllResults(List<Results> x) {
		rr.saveAll(x);
		return "SUCCESS";
	}

	public List<Results> getRange() {
		
		return rr.getRange();
	}

	public Results getTopper() {// TODO Auto-generated method stub
		return rr.getTopper();
	}

	public List<Results> getTop3() {
		
		return rr.getTop3();
	}
}
