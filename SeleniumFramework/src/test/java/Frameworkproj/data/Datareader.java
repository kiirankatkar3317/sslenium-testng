
package Frameworkproj.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datareader {
	
	
public List<HashMap<String,String>> jsontoHashmap() throws IOException {

String jsondata =	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Frameworkproj\\data\\Submitorderdata.json"),StandardCharsets.UTF_8);
//jackson databind
ObjectMapper mapper = new ObjectMapper();
List<HashMap<String,String>> data = mapper.readValue(jsondata, new TypeReference<List<HashMap<String,String>>>(){});
return data;
}
}