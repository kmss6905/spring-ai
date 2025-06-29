package ai.stream;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

  private final ChatClient chatClient;

  // Spring AI auto-configures a ChatMemoryRepository bean of type InMemoryChatMemoryRepository
  // that you can use directly in your application.
  public ChatController(
    ChatClient.Builder builder,
    ChatMemoryRepository chatMemoryRepository
  ) {
    var chatMemory = MessageWindowChatMemory.builder()
      .chatMemoryRepository(chatMemoryRepository)
      .maxMessages(100)
      .build();

    this.chatClient = builder
      .defaultAdvisors(
        MessageChatMemoryAdvisor
          .builder(chatMemory)
          .build()
      ).build();
  }

  @GetMapping("/chat")
  public String chat(@RequestParam String message) {
    return chatClient
      .prompt(message)
      .call()
      .content();
  }

  @GetMapping("/stream")
  public Flux<String> chatStream(@RequestParam String message) {
    return chatClient
      .prompt(message)
      .stream()
      .content();
  }

}
