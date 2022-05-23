package com.bharath.ws.soap.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler
{
	private Map<String,String> password=new HashMap<>();
	public UTPasswordCallback()
	{
		password.put("mahesh", "lamichhane");
		password.put("cxf", "cxf");
	}

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
	{
		for(Callback callback:callbacks)
		{
			WSPasswordCallback passwordCallBack=(WSPasswordCallback)callback;
			String passwords=password.get(passwordCallBack.getIdentifier());
			if(password!=null)
			{
				passwordCallBack.setPassword(passwords);
				return;
			}
		}
	}

}
