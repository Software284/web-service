import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.lamichhane.restwsclient.model.Patient;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class MyMessageBodyReader implements MessageBodyReader<Patient>
{

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return type==Patient.class;
	}

	@Override
	public Patient readFrom(Class<Patient> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		 try {
		        JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
		        Patient myBean = (Patient) jaxbContext.createUnmarshaller()
		            .unmarshal(entityStream);
		        return myBean;
		    } catch (JAXBException jaxbException) {
		        throw new ProcessingException("Error deserializing a MyBean.",jaxbException);
		    }
	}



}
