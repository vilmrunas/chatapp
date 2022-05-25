package lt.runas.chatapp.models;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conversationHash;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "messageSender_id", referencedColumnName = "id")
    private User messageSender;

    private String messageText;
    private String sentDateTime;

    public Message() {
    }

    public Message(Long id, String conversationHash, User messageSender, String messageText, String sentDateTime) {
        this.id = id;
        this.conversationHash = conversationHash;
        this.messageSender = messageSender;
        this.messageText = messageText;
        this.sentDateTime = sentDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(User messageSender) {
        this.messageSender = messageSender;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getSentDateTime() {
        return sentDateTime;
    }

    public void setSentDateTime(String sentDateTime) {
        this.sentDateTime = sentDateTime;
    }

    public String getConversationHash() {
        return conversationHash;
    }

    public void setConversationHash(String conversationHash) {
        this.conversationHash = conversationHash;
    }
}
