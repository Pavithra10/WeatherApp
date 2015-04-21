package net.hft.dbproject.weatherapp.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import net.hft.dbproject.weatherapp.helper.PropertiesHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Jan
 */
public class PropertiesService extends PropertiesHelper {

    private static Properties properties;
    private static final File INIFILE = new File(getShortIniPath());
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesService.class);

    public PropertiesService() {
        loadProperties();
    }

    public void storeCityAndZip(String name, String zip) {
        if (isPropertiesFileExisting()) {
            properties.setProperty("name", name);
            properties.setProperty("zip", zip);
            try {
                properties.store(new FileOutputStream(INIFILE), "WEATHERAPP- PROPERTIESFILE");
                LOGGER.info("New values stored: {}, {}", name, zip);
            } catch (FileNotFoundException ex) {
                LOGGER.error(ex.toString());
            } catch (IOException ex) {
                LOGGER.error(ex.toString());
            }
        }
    }

    private void loadProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(new FileInputStream(INIFILE));
            } catch (IOException ex) {
                LOGGER.error(ex.toString());
            }
        }
    }

    public String getName() {
        return properties.getProperty("name");
    }

    public String getZipCode() {
        return properties.getProperty("zip");
    }

}
