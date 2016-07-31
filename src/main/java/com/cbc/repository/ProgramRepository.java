/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.Program;

/**
 * @author Mina Saleeb
 *
 */
public interface ProgramRepository extends CrudRepository<Program, Integer> 
{
	List<Program> findByHubSelectedOrderByOrderingFactorAsc(boolean hubSelected);
	
	List<Program> findByOnAirAndTypeOrderByOrderingFactorAsc(boolean onAir, String type);
	
	List<Program> findByOnAirOrderByOrderingFactorAsc(boolean onAir);
	
	List<Program> findByTypeOrderByOrderingFactorAsc(String type);
	
	@Query(value="SELECT * "+
			 "FROM programs p INNER JOIN programs_channels pc ON p.id = pc.program "+
			 "WHERE pc.channel = :channelId AND p.program_type = :type ORDER BY p.ordering_factor" ,nativeQuery =true)
	List<Program> findByChannelIdAndType(@Param("channelId") int channelId, @Param("type") String type);
	
	@Query(value="SELECT * "+
				 "FROM programs p INNER JOIN programs_channels pc ON p.id = pc.program "+
				 "WHERE pc.channel = :channelId AND p.on_air = :onAir AND p.program_type = :type ORDER BY p.ordering_factor" ,nativeQuery =true)
	List<Program> findByChannelIdAndOnAirAndType(@Param("channelId") int channelId, @Param("onAir") byte onAir, @Param("type") String type);
	
	@Query(value="SELECT * "+
			 "FROM programs p INNER JOIN programs_channels pc ON p.id = pc.program "+
			 "WHERE pc.channel = :channelId ORDER BY p.ordering_factor" ,nativeQuery =true)
	List<Program> findByChannelId(@Param("channelId") int channelId);
	
	@Query(value="SELECT * "+
				 "FROM programs p INNER JOIN programs_channels pc ON p.id = pc.program "+
				 "WHERE pc.channel = :channelId AND p.on_air = :onAir ORDER BY p.ordering_factor" ,nativeQuery =true)
	List<Program> findByChannelIdAndOnAir(@Param("channelId") int channelId, @Param("onAir") byte onAir);
}
