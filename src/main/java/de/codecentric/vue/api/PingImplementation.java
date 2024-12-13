package de.codecentric.vue.api;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.codecentric.generated.api.PingApiDelegate;
import de.codecentric.generated.model.PingResponse;


@Service
public class PingImplementation implements PingApiDelegate {
	private static final Logger logger = LoggerFactory.getLogger(PingImplementation.class);
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

	@Autowired
	BuildProperties build;
	
    @Autowired
    private Environment environment;
    
    @PostConstruct
    public void init() {
    	logger.info("Version: {}", build.getVersion());
    	logger.info("Build Time: {}", formatter.format(build.getTime()));
    	StringBuilder profiles = new StringBuilder();
    	for (String profile : environment.getActiveProfiles()) {
    		if (!profiles.isEmpty()) {
    			profiles.append(", ");
    		}
			profiles.append(profile);
		}
    }
    	@Override
	public ResponseEntity<PingResponse> getPing() {
		logger.info("ping called");
		PingResponse ping = new PingResponse();
		ping.setName(build.getName());
		ping.setVersion(build.getVersion());
		ping.setBuildTime(formatter.format(build.getTime()));
		ping.setServerTime(formatter.format(Instant.now()));
		ping.setActiveProfiles(Arrays.asList(environment.getActiveProfiles()));
		return ResponseEntity.ok(ping);
	}
}
