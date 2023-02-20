package livefy.app.usersservices.profile.bus;

import lombok.Getter;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

@Getter
public class ProfileUpdatedEvent extends RemoteApplicationEvent {
    private static final Object TRANSIENT_SOURCE = new Object();

    private final long profileId;
    private final String userId;

    public ProfileUpdatedEvent(String originService, String destination, long profileId, String userId) {
        super(TRANSIENT_SOURCE, originService, DEFAULT_DESTINATION_FACTORY.getDestination(destination));
        this.profileId = profileId;
        this.userId = userId;
    }
}
