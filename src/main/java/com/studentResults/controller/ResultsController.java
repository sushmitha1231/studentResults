package com.studentResults.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.studentResults.entity.PojoForMarksheet;
import com.studentResults.entity.Results;
import com.studentResults.service.ResultsService;

@RestController
public class ResultsController {
	@Autowired
	RestTemplate rt;
	@Autowired
	ResultsService rs;

	@GetMapping("/getAllResults")
	public List<Results> getAllResults() {

		String url = "http://localhost:8081/getNamesById/";
		String url2 = "http://localhost:8080/getAllStudent";
		String url3 = "http://localhost:8080/getTotal/";
		ResponseEntity<List<PojoForMarksheet>> ms = rt.exchange(url2, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PojoForMarksheet>>() {
				});
		List<PojoForMarksheet> l = ms.getBody();
		
		List<Results> ub = new ArrayList<>();
		l.forEach(z -> {
			int rollNum = z.getRollNum();
			int id = z.getId();
			

			ResponseEntity<String> s = rt.exchange(url + id, HttpMethod.GET, null, String.class);
			String name = s.getBody();
			ResponseEntity<Integer> t = rt.exchange(url3 + id, HttpMethod.GET, null, Integer.class);
			Integer total = t.getBody();
			int percentage = total*100/100;
			
		

			ub.add(new Results(id, rollNum, name, total, percentage));
		});
		return ub;

	}
	@PostMapping("/setAllResults")
	public String setAllResults() {
		List <Results>x=getAllResults();
		return rs.setAllResults(x);
	}
@GetMapping("/getRangeOf70&90")
public List <Results>getRange(){
	
	return rs.getRange();
}
@GetMapping("/getTopper")
public Results getTopper() {
	return rs.getTopper();
}
@GetMapping("/getTop3")
public List <Results> getTop3() {
	return rs.getTop3();
}
}
