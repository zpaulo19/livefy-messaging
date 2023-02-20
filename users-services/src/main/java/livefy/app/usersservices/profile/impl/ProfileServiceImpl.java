package livefy.app.usersservices.profile.impl;

import java.util.function.UnaryOperator;
import livefy.app.usersservices.profile.Profile;
import livefy.app.usersservices.profile.ProfileRepository;
import livefy.app.usersservices.profile.ProfileService;
import livefy.app.usersservices.profile.bus.ProfileCreatedEvent;
import livefy.app.usersservices.profile.bus.ProfileUpdatedEvent;
import livefy.app.usersservices.profile.exception.ProfileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
public class ProfileServiceImpl implements ProfileService {
    private final String busId;
    private final ApplicationContext applicationContext;
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(
            @Value("${spring.cloud.bus.id}") String busId,
            ApplicationContext applicationContext,
            ProfileRepository profileRepository
    ) {
        this.busId = busId;
        this.applicationContext = applicationContext;
        this.profileRepository = profileRepository;
    }

    @Cacheable("profile-by-userid")
    @Override
    public Profile getProfile(String userId) {
        return profileRepository.findByUserId(userId);
    }

    @CachePut(cacheNames = "profile-by-userid", key = "#result.userId")
    @Override
    public Profile createProfile(Profile profile) {
        Profile newProfile = profileRepository.save(profile);

        applicationContext.publishEvent(new ProfileCreatedEvent(busId, null, newProfile.getId(),
                newProfile.getUserId()));
        return newProfile;
    }

    @CachePut(cacheNames = "profile-by-userid", key = "#result.userId")
    @Override
    public Profile updateProfile(long profileId, UnaryOperator<Profile> updater) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException(profileId));

        log.info("Updating profile {}", profileId);

        Profile updatedProfile = updater.apply(profile);

        applicationContext.publishEvent(new ProfileUpdatedEvent(busId, null, updatedProfile.getId(),
                updatedProfile.getUserId()));
        return updatedProfile;
    }
}
