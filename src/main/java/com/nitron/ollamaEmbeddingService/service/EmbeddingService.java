package com.nitron.ollamaEmbeddingService.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class EmbeddingService {
    private final EmbeddingModel embeddingModel;
    private final VectorStore vectorStore;

    public EmbeddingService(EmbeddingModel embeddingModel, VectorStore vectorStore) {
        this.embeddingModel = embeddingModel;
        this.vectorStore = vectorStore;
    }

    public void generateCodeEmbeddingsAndStore() {
        try {
            //String code1 = Files.readString(Paths.get("/home/nishit/Documents/JavaWorkspace/TransSearchService/src/main/java/com/nitron/TransSearchService/service/TranslationService.java"));
            // String code2 = Files.readString(Paths.get("/home/nishit/Documents/JavaWorkspace/TransSearchService/src/main/java/com/nitron/TransSearchService/repository/TranslationsRepository.java"));
            // String code3 = Files.readString(Paths.get("/home/nishit/Documents/JavaWorkspace/TransSearchService/src/main/java/com/nitron/TransSearchService/controller/TranslationsController.java"));
            // var cleanString = code1.replaceAll("\n", "");
            // var cleanString2 = code2.replaceAll("\n", "");
            String doc1 = Files.readString(Paths.get("/home/nishit/Documents/JavaWorkspace/ollamaEmbeddingService/src/main/resources/doc1.txt"));
            String doc2 = Files.readString(Paths.get("/home/nishit/Documents/JavaWorkspace/ollamaEmbeddingService/src/main/resources/doc2.txt"));
            var len1 = doc1.length();
            var len2 = doc2.length();
            createEmbeddingAndWriteToDB(doc1, len1);

             createEmbeddingAndWriteToDB(doc2, len2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmbeddingAndWriteToDB(String doc1, int len) {
        System.out.println("Started ");
        var start = 0;
        var end = 0;
        while (len > 0) {
            if (len > 1000) {
                len -= 1000;
                end+= 1000;
            } else {
                end+= len;
                len = 0;
            }
            var str = doc1.substring(start, end);
            List<Document> documents = List.of(
                    new Document(str)
            );
            vectorStore.add(documents);
            System.out.println("Completed Range "+start+" : "+end);

            start+=1000;
        }

    }

    public List<Document> searchByQuery(String query) {
        return vectorStore.similaritySearch(query);
    }

}