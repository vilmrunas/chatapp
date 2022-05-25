package lt.runas.chatapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "conversations")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //why generation type Identity???
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userSender_id", referencedColumnName = "id")
    private User userSender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userReceiver_id", referencedColumnName = "id")
    private User userReceiver;

    private String conversationHash;

    private String lastMessage;

    public Conversation() {
    }

    public Conversation(Long id, User userSender, User userReceiver, String lastMessage) {
        this.id = id;
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.lastMessage = lastMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public User getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(User userReceiver) {
        this.userReceiver = userReceiver;
    }

    public String getConversationHash() {
        return conversationHash;
    }

    public void setConversationHash(String conversationHash) {
        this.conversationHash = conversationHash;
    }
}
