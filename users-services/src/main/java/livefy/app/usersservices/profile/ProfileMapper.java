package livefy.app.usersservices.profile;

import livefy.app.usersservices.config.ModelMapperConfig;
import livefy.app.usersservices.profile.dto.ProfileCreationDTO;
import livefy.app.usersservices.profile.dto.ProfileDTO;
import livefy.app.usersservices.profile.dto.ProfileUpdatingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = ModelMapperConfig.class)
public interface ProfileMapper {
    ProfileDTO convertToDTO(Profile profile);

    @Mapping(target = "id", ignore = true)
    Profile convertToModel(ProfileCreationDTO profileCreationDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Profile updateModelFromDTO(@MappingTarget Profile profile, ProfileUpdatingDTO profileUpdatingDTO);
}
