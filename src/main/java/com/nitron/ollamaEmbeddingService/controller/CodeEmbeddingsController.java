package com.nitron.ollamaEmbeddingService.controller;

import com.nitron.ollamaEmbeddingService.service.EmbeddingService;
import com.nitron.ollamaEmbeddingService.service.QueryRequest;
import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CodeEmbeddingsController {

    private final EmbeddingService embeddingService;

    public CodeEmbeddingsController(EmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
    }

    @PostMapping("/generate")
    public void generateEmbeddings()
    {
        embeddingService.generateCodeEmbeddingsAndStore();
    }

    @PostMapping("/query")
    public List<Document> query(QueryRequest query)
    {
        return embeddingService.searchByQuery(query.getQuery());
    }
}