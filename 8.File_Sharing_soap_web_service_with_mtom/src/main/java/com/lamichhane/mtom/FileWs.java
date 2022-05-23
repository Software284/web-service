package com.lamichhane.mtom;

import java.io.IOException;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FileWs 
{
	void upload(@WebParam(name="file") DataHandler attachment) throws IOException;
	DataHandler download();

}
