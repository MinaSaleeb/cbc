/**
 * 
 */
package com.cbc.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.repository.CBCNewsRepository;
import com.cbc.repository.NewsCategoryRepository;

/**
 * @author Mina Saleeb
 *
 */
@Service
public class CBCNewsService 
{
	private static final Logger LOGGER = Logger.getLogger(CBCNewsService.class);
	
	@Autowired
	private CBCNewsRepository cBCNewsRepo;
	
	@Autowired
	private NewsCategoryRepository newsCategoryRepo;
	
	
	
}
