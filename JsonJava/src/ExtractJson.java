
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractJson {
public static void main(String str[]) throws JsonParseException,JsonMappingException,IOException {
		ObjectMapper om = new ObjectMapper();
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		CustomDetailAppium c=om.readValue(new File("D:\\Workspace_NRDA\\JsonJava\\customerInfo0.json"),CustomDetailAppium.class);
		System.out.println(c.getCourseName());
		System.out.println(c.getAmount());
		System.out.println(c.getLocation());
		System.out.println(c.getPurchaseDate());
		System.out.println(c.getStudentName());
		
	}

}
