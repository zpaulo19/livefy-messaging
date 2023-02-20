package livefy.app.usersservices.config;

import livefy.app.usersservices.profile.bus.ProfileCreatedEvent;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@RemoteApplicationEventScan(basePackageClasses = ProfileCreatedEvent.class)
public class BusConfig {
}
