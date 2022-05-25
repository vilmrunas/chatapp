package lt.runas.chatapp.dto;

public class ConversationResponse {
    private Long id;
    private String receiverFirstName;
    private String receiverLastName;
    private String conversationHash;
    private String lastMessage;

    public ConversationResponse() {
    }

    public ConversationResponse(Long id, String receiverFirstName, String receiverLastName, String conversationHash, String lastMessage) {
        this.id = id;
        this.receiverFirstName = receiverFirstName;
        this.receiverLastName = receiverLastName;
        this.conversationHash = conversationHash;
        this.lastMessage = lastMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getConversationHash() {
        return conversationHash;
    }

    public void setConversationHash(String conversationHash) {
        this.conversationHash = conversationHash;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
