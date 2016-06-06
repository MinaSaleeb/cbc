/**
 * 
 */
package com.cbc.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @author Mina Saleeb
 *
 */
public class CommonUtils 
{
	public static Pageable getPageableObj(int n, int s)
	{
		
		int pageSize = 99;//for infinity
		if(s > 0)
		{
			pageSize = s;
		}
		
		Pageable page = new PageRequest(n, pageSize);
		
		return page;
	}
}
