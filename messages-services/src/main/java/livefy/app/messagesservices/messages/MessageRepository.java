package livefy.app.messagesservices.messages;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByRecipientIdOrderBySentTimestampDesc(String recipientId);
    List<Message> findAllBySenderIdOrderBySentTimestampDesc(String senderId);
}
