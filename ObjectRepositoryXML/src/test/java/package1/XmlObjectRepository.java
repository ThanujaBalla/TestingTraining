package package1;

import java.io.File;
 
import org.dom4j.io.SAXReader;
import org.dom4j.Document;
import org.dom4j.Node;
public class XmlObjectRepository {
	public static String getlocator(String locatorName)
	{
		try
		{
			File file=new File("objectrepository.xml");
			SAXReader reader=new SAXReader();
			Document doc=reader.read(file);
			Node node = doc.selectSingleNode("//" + locatorName);
			if (node == null) {
                throw new RuntimeException(
                    "Locator not found in XML: " + locatorName
                );
            }
 
            return node.getText();
 
        } catch (Exception e) {
 
            e.printStackTrace();
 
            return null;
        }
    }
}