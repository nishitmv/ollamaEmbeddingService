package com.nitron.ollamaEmbeddingService.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class EmbeddingService {
    private final EmbeddingModel embeddingModel;
    private final VectorStore vectorStore;

    public EmbeddingService(EmbeddingModel embeddingModel, VectorStore vectorStore) {
        this.embeddingModel = embeddingModel;
        this.vectorStore = vectorStore;
    }

    public void generateCodeEmbeddingsAndStore()
    {
        try {
            String code1 = Files.readString(Paths.get("/home/nishit/Documents/JavaWorkspace/TransSearchService/src/main/java/com/nitron/TransSearchService/service/TranslationService.java"));
            String code2 = Files.readString(Paths.get("/home/nishit/Documents/JavaWorkspace/TransSearchService/src/main/java/com/nitron/TransSearchService/repository/TranslationsRepository.java"));
           // String code3 = Files.readString(Paths.get("/home/nishit/Documents/JavaWorkspace/TransSearchService/src/main/java/com/nitron/TransSearchService/controller/TranslationsController.java"));
            var cleanString = code1.replaceAll("\n", "");
            var cleanString2 = code2.replaceAll("\n", "");

            List <Document> documents = List.of(
                    new Document(cleanString),
                    new Document(cleanString2)
                 //   new Document(code3.replaceAll("\n", ""), Map.of("TranslationsController", "TranslationsController"))
            );
            vectorStore.add(documents);
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    public List<Document> searchByQuery(String query)
    {
        return vectorStore.similaritySearch(query);
    }

}