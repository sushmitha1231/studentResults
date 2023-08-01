package com.studentResults.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentResults.dao.ResultsDao;
import com.studentResults.entity.Results;

@Service
public class ResultsService {
@Autowired
ResultsDao rd;

public String setAllResults(List<Results> x) {
	
	return rd.setAllResults(x);
}

public List<Results> getRange() {
	
	return rd.getRange();
}

public Results getTopper() {
	
	return rd.getTopper();
}

public List<Results> getTop3() {
	
	return rd.getTop3();
}
}
