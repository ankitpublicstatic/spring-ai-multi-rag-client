package com.ankit.springai.controller.config;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringAIClient {
  private final OpenAiChatModel chatModel;

  public SpringAIClient(@Value("${spring.ai.openai.api-key}") String apiKey) {
    this.chatModel = new OpenAiChatModel(apiKey);
  }

  public String summarize(String text) {
    String prompt = "Summarize this answer in concise language:\n" + text;
    return chatModel.call(prompt).getResult().getOutput().getText();
  }
}
