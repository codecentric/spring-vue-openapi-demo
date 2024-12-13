package de.codecentric.vue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Autowired
	VueIndexHtmlController indexController;

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("*", "**")
                .addResourceLocations("classpath:/static/")
                .setUseLastModified(true)
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new ChainedPathResourceResolver())
                .addResolver(new VueResourceResolver(indexController));
    }
}
