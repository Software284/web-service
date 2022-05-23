package com.lamichhane.mtom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {

	@Override
	public void upload(DataHandler attachment) 
	{
		try
		{
			InputStream inputStream=attachment.getInputStream();
			OutputStream outputStream=new FileOutputStream(new File("C:\\Users\\CAS\\Desktop\\output\\test.jpg"));
			byte[] b=new byte[100000];
			int bytesRead=0;
			while((bytesRead=inputStream.read(b))!=-1)
			{
				outputStream.write(b,0,bytesRead);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

	}

	@Override
	public DataHandler download() {
		
		return new DataHandler(new FileDataSource(new File("C:\\Users\\CAS\\Desktop\\heheh\\test.jpg")));
	}

}
