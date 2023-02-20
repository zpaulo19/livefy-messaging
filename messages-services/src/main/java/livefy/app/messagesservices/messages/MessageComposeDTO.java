package livefy.app.messagesservices.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MessageComposeDTO {
    @NotBlank
    @JsonProperty("recipient_id")
    private String recipientId;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;
}
