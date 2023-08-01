
package com.studentResults.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentResults.entity.Results;

public interface ResultsRepository extends JpaRepository<Results, Integer> {
	@Query(value = "select * from results where total>=70 and total<=90 ", nativeQuery = true)
	List<Results> getRange();

	@Query(value = "select * from results where total=(select max(total)from results)", nativeQuery = true)
	Results getTopper();

	@Query(value = "select * from results order by  total desc limit 3", nativeQuery = true)
	List<Results> getTop3();

}
