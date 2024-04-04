package dmacc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Bird;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Apr 2, 2024
 */

@Configuration
public class BirdBeanConfig {
	
	@Bean
	public Bird bird() {
		
		Bird bird = new Bird();
		return bird;
		
	}

}
