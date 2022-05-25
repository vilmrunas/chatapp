package lt.runas.chatapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;

    @OneToMany(mappedBy = "userSender")
    private Set<Conversation> conversationsSender = new HashSet<>();

    @OneToMany(mappedBy = "userReceiver")
    private Set<Conversation> conversationsReceiver = new HashSet<>();

    @OneToMany(mappedBy = "messageSender")
    private Set<Message> messagesSent = new HashSet<>();


    public User() {
    }

    public User(Long id, String firstName, String lastName, String username, String password, String role, Set<Conversation> conversationsSender, Set<Conversation> conversationsReceiver, Set<Message> messagesSent) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.conversationsSender = conversationsSender;
        this.conversationsReceiver = conversationsReceiver;
        this.messagesSent = messagesSent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Conversation> getConversationsSender() {
        return conversationsSender;
    }

    public void setConversationsSender(Set<Conversation> conversationsSender) {
        this.conversationsSender = conversationsSender;
    }

    public Set<Conversation> getConversationsReceiver() {
        return conversationsReceiver;
    }

    public void setConversationsReceiver(Set<Conversation> conversationsReceiver) {
        this.conversationsReceiver = conversationsReceiver;
    }

    public Set<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(Set<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }
}
