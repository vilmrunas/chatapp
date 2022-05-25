package lt.runas.chatapp.repositories;

import lt.runas.chatapp.models.Conversation;
import lt.runas.chatapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByUserSender(User user);
}
