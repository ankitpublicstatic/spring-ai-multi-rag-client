package com.ankit.springai.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ankit.springai.controller.config.SpringAIClient;
import com.ankit.springai.controller.request.QueryRequest;
import com.ankit.springai.controller.response.RagResponse;

@Service
public class RagService {
  @Autowired
  private SpringAIClient aiClient;

  private final RestTemplate restTemplate = new RestTemplate();
  private final String PYTHON_RAG_URL = "http://localhost:8000/rag/query";

  public RagResponse queryRag(String query) {
    var request = new QueryRequest(query);
    var response = restTemplate.postForObject(PYTHON_RAG_URL, request, RagResponse.class);
    // Optional post-processing via Spring AI summarizer
    String summarized = aiClient.summarize(response.getAnswer());
    response.setAnswer(summarized);
    return response;

  }
}
