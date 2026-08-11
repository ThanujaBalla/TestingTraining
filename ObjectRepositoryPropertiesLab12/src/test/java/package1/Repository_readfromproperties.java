package package1;

import java.io.FileInputStream;
import java.util.Properties;

public class Repository_readfromproperties {
	static Properties prob = new Properties();

	static String projectpath = System.getProperty("user.dir");
    static {
    	try {
			String path = projectpath + "\\objectRepository.properties";

			FileInputStream fis = new FileInputStream(path);

			prob.load(fis);
			fis.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
    }
	public static String getlocator(String key)

	{

		return prob.getProperty(key);
	}

}
