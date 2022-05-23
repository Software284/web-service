import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import com.lamichhane.restwsclient.model.Patient;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class MessageBodyWriter implements javax.ws.rs.ext.MessageBodyWriter<Patient>
{

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return type==Patient.class;
	}

	@Override
	public void writeTo(Patient t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		    try
		    {
		    	JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
	            jaxbContext.createMarshaller().marshal(Patient.class, entityStream);
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		
	}

}
