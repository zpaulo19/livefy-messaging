package livefy.app.messagesservices.config;

import livefy.app.messagesservices.integration.profilesservice.bus.ProfileCreatedEvent;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@RemoteApplicationEventScan(basePackageClasses = ProfileCreatedEvent.class)
public class BusConfig {
}
