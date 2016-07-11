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
	List<Program> findByHubSelected(boolean hubSelected);
	
	List<Program> findByOnAirAndType(boolean onAir, String type);
	
	List<Program> findByOnAir(boolean onAir);
	
	List<Program> findByType(String type);
	
	@Query(value="SELECT * "+
			 "FROM programs p INNER JOIN programs_channels pc ON p.id = pc.program "+
			 "WHERE pc.channel = :channelId AND p.program_type = :type" ,nativeQuery =true)
	List<Program> findByChannelIdAndType(@Param("channelId") int channelId, @Param("type") String type);
	
	@Query(value="SELECT * "+
				 "FROM programs p INNER JOIN programs_channels pc ON p.id = pc.program "+
				 "WHERE pc.channel = :channelId AND p.on_air = :onAir AND p.program_type = :type" ,nativeQuery =true)
	List<Program> findByChannelIdAndOnAirAndType(@Param("channelId") int channelId, @Param("onAir") byte onAir, @Param("type") String type);
	
	@Query(value="SELECT * "+
			 "FROM programs p INNER JOIN programs_channels pc ON p.id = pc.program "+
			 "WHERE pc.channel = :channelId" ,nativeQuery =true)
	List<Program> findByChannelId(@Param("channelId") int channelId);
	
	@Query(value="SELECT * "+
				 "FROM programs p INNER JOIN programs_channels pc ON p.id = pc.program "+
				 "WHERE pc.channel = :channelId AND p.on_air = :onAir" ,nativeQuery =true)
	List<Program> findByChannelIdAndOnAir(@Param("channelId") int channelId, @Param("onAir") byte onAir);
}
