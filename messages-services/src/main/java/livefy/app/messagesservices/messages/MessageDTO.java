package livefy.app.messagesservices.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import lombok.Data;

@Data
public class MessageDTO {
    private Long id;

    @JsonProperty("sender_id")
    private String senderId;

    @JsonProperty("sender_name")
    private String senderName;

    @JsonProperty("recipient_id")
    private String recipientId;

    @JsonProperty("recipient_name")
    private String recipientName;

    private String subject;
    private String text;

    @JsonProperty("sent_timestamp")
    private Instant sentTimestamp;
}
