package de.codecentric.vue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication
// @EnableScheduling
@ComponentScan(basePackages = { "de.codecentric.vue.api", "de.codecentric.vue", "de.codecentric.generated", "de.codecentric.generated.api" , "de.codecentric.generated.configuration" },
	nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
public class VueDemoWithSpringBootApplication {

	// start with --spring.profiles.active=ide to activate additional property file application-ide.yaml
	public static void main(String[] args) {
		SpringApplication.run(VueDemoWithSpringBootApplication.class, args);
	}

}
