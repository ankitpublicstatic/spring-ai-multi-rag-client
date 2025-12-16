package com.ankit.springai.controller.config;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringAIClient {
  private final OpenAiChatModel chatModel;

  // public SpringAIClient(@Value("${spring.ai.openai.api-key}") String apiKey) {
  // this.chatModel = new OpenAiChatModel(apiKey);
  // }
  //
  // public String summarize(String text) {
  // String prompt = "Summarize this answer in concise language:\n" + text;
  // return chatModel.call(prompt).getResult().getOutput().getText();
  // }

  public SpringAIClient(@Value("${spring.ai.openai.api-key}") String apiKey) {
    // ✅ create an API client first
    OpenAiApi openAiApi = new OpenAiApi(apiKey);
    this.chatModel = new OpenAiChatModel(openAiApi);
  }

  public String summarize(String text) {
    String prompt = "Summarize this answer in concise language:\n" + text;

    // ✅ Option 1: returns plain text
    String response = chatModel.call(prompt);
    // return response;

    // ✅ Option 2 (if you need structured response)
    ChatResponse chatResponse = chatModel.call(new Prompt(prompt));
    return chatResponse.getResult().getOutput().getContent().toString();
  }
}
