package com.lamichhane.soapwebservice.handlers;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context)
	{
		System.out.println("handle Message");
		Boolean isResponse=(Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(!isResponse)
		{
			SOAPMessage soapMsg=context.getMessage();
			try
			{
				SOAPEnvelope envelope=soapMsg.getSOAPPart().getEnvelope();
				SOAPHeader header=envelope.getHeader();
				Iterator childElements=header.getChildElements();
				while(childElements.hasNext())
				{
					Node eachNode=(Node)childElements.next();
					String name=eachNode.getLocalName();
					if(name!=null && name.equals("SiteName"))
					{
						System.out.println("Site Name Is===>"+eachNode.getValue());
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Response on the way");
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		System.out.println("handle Fault");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated meth
		System.out.println("handle close");
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		System.out.println("get Headers");
		return null;
	}

}
