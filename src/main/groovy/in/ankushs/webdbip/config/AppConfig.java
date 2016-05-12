package in.ankushs.webdbip.config;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

import in.ankushs.dbip.api.DbIpClient;

@Configuration
public class AppConfig {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Bean(name="dbIpClient")
	public DbIpClient getDbIpClient() throws IOException{
		final File file = resourceLoader.getResource("classpath:dbip-city-latest.csv.gz").getFile();
		Assert.isTrue(file.exists(),"file does not exist.Make sure the file is placed in src/main/resources with name 'dbip-city-latest.csv.gz'");
		return new DbIpClient(file);
	}
	
}
