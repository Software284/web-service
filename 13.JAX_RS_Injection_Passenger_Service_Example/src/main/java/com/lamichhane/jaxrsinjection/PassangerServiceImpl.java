package com.lamichhane.jaxrsinjection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.lamichhane.jaxrsinjection.model.Passanger;

@Service
public class PassangerServiceImpl implements PassengerService {
	
	List<Passanger> passengers=new ArrayList<>();
	int currentId=123;

	@Override
	public List<Passanger> getPassangers(int start,int size) {
		System.out.println(start);
		System.out.println(size);
		
		return passengers;
	}


	@Override
	public void addPassanger(String firstName,String lastName,String agent,HttpHeaders headers) 
	{
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(agent);
		
		MultivaluedMap<String, String> allHeaders = headers.getRequestHeaders();
		Set<String> headersKeys = allHeaders.keySet();
		for(String key:headersKeys)
		{
			System.out.println(key);
			System.out.println(headers.getHeaderString(key));
		}
		
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> cookiekeys = cookies.keySet();
		for(String eachCookieKey:cookiekeys)
		{
			System.out.println("----------------Cookies----------------------");
			System.out.println(eachCookieKey);
			System.out.println(cookies.get(eachCookieKey));
		}
	}




}
