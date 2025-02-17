package org.rdutta.msoauth.config;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.requests.GraphServiceClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MailConfiguration {

    @Value("${spring.security.oauth2.client.registration.azure.client-id}")
    private String clientId;

    @Value("${microsoft.azure.tenant-id}")
    private String tenantId;

    @Value("${spring.security.oauth2.client.registration.azure.client-secret}")
    private String clientSecret;

    private GraphServiceClient<Request> initializeGraphForAppOnlyAuth() {

        ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder().clientId(clientId)
                .tenantId(tenantId)
                .clientSecret(clientSecret).build();

        // Use the .default scope when using app-only auth
        final TokenCredentialAuthProvider authProvider = new TokenCredentialAuthProvider(
                List.of("https://graph.microsoft.com/.default"), clientSecretCredential);

        return GraphServiceClient.builder().authenticationProvider(authProvider).buildClient();
    }

    @Bean
    public GraphServiceClient<Request> mailClient() {
        return initializeGraphForAppOnlyAuth();
    }

}
