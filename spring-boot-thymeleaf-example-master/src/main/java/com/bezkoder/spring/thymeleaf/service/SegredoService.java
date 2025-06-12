package com.bezkoder.spring.thymeleaf.service;

import com.google.cloud.secretmanager.v1.*;
import org.springframework.stereotype.Service;

@Service
public class SegredoService {

    public String obterSegredo() {
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            String projectId = "teste-de-projeto-a3";
            String secretId = "senha-api";
            String versionId = "latest";

            SecretVersionName secretVersionName = SecretVersionName.of(projectId, secretId, versionId);
            AccessSecretVersionResponse response = client.accessSecretVersion(secretVersionName);

            return response.getPayload().getData().toStringUtf8();
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}
