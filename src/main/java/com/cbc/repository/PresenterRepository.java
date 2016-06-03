/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.Presenter;

/**
 * @author Mina Saleeb
 *
 */
public interface PresenterRepository extends CrudRepository<Presenter, Integer> 
{
	@Query("SELECT p FROM Presenter p INNER JOIN p.programs prgm INNER JOIN prgm.channels chnl WHERE chnl.id = :channelId")
	List<Presenter> findByChannelId(@Param("channelId") int channelId);
}
