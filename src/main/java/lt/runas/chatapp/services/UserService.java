package lt.runas.chatapp.services;

import lt.runas.chatapp.dto.ConversationResponse;
import lt.runas.chatapp.models.Conversation;
import lt.runas.chatapp.models.User;
import lt.runas.chatapp.repositories.ConversationRepository;
import lt.runas.chatapp.repositories.UserRepository;
import lt.runas.chatapp.security.CustomUserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    private UserRepository userRepository;
    private ConversationRepository conversationRepository;
    private CustomUserDetailsService customUserDetailsService;

    public UserService(UserRepository userRepository, ConversationRepository conversationRepository, CustomUserDetailsService customUserDetailsService) {
        this.userRepository = userRepository;
        this.conversationRepository = conversationRepository;
        this.customUserDetailsService = customUserDetailsService;
    }

    public void registerUser(User user) {
        //TODO: check if user already is registered (if)
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public void startNewConversation(String contactUsername) {
        //TODO: check if user already is registered (if)
        String currentUsername = customUserDetailsService.getPrincipal();
        User currentUser = userRepository.findByUsername(currentUsername);
        User contactUser = userRepository.findByUsername(contactUsername);

        UUID uuid = UUID.randomUUID();
        String conversationHash = uuid.toString();

        Conversation conversationCurrentUser = new Conversation();
        conversationCurrentUser.setUserSender(currentUser);
        conversationCurrentUser.setUserReceiver(contactUser);
        conversationCurrentUser.setConversationHash(conversationHash);

        Conversation conversationContactUser = new Conversation();
        conversationContactUser.setUserSender(contactUser);
        conversationContactUser.setUserReceiver(currentUser);
        conversationContactUser.setConversationHash(conversationHash);

        conversationRepository.save(conversationCurrentUser);
        conversationRepository.save(conversationContactUser);
    }

    public List<ConversationResponse> getConversationsList() {
        String currentUsername = customUserDetailsService.getPrincipal();
        User currentUser = userRepository.findByUsername(currentUsername);

        return conversationRepository.findByUserSender(currentUser)
                .stream()
                .map(this::mapToConversationResponse)
                .collect(toList());
    }

    private ConversationResponse mapToConversationResponse (Conversation conversation) {
        ConversationResponse conversationResponse = new ConversationResponse();
        conversationResponse.setId(conversation.getId());
        conversationResponse.setReceiverFirstName(conversation.getUserReceiver().getFirstName());
        conversationResponse.setReceiverLastName(conversation.getUserReceiver().getLastName());
        conversationResponse.setConversationHash(conversation.getConversationHash());
        conversationResponse.setLastMessage(conversation.getLastMessage());
        return conversationResponse;
    }
}
