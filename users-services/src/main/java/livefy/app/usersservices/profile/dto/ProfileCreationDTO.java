package livefy.app.usersservices.profile.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfileCreationDTO {
    @NotBlank
    @JsonProperty("user_id")
    private String userId;

    @NotBlank
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank
    @JsonProperty("last_name")
    private String lastName;

    @NotBlank
    private String email;
}
