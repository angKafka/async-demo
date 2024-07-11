package org.rdutta.mailserver.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.rdutta.mailserver.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GraphEmailSender{

    @Value("${spring.security.oauth2.client.registration.azure.client-id}")
    private String CLIENT_ID;
    @Value("${spring.security.oauth2.client.registration.azure.client-secret}")
    private String CLIENT_SECRET;
    @Value("${microsoft.azure.tenant-id}")
    private String TENANT_ID;
    private final String AUTHORITY = "https://login.microsoftonline.com/consumers/oauth2/v2.0/authorize";
    private final String SCOPES = "https://graph.microsoft.com/.default";
    private UserClient userClient;

    public void sendMail() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"message\": {\n        \"subject\": \"Testing MSGraph API\",\n        \"body\": {\n            \"contentType\": \"Text\",\n            \"content\": \"Hello Raj, I am just testing the MSGraph API's.\"\n        },\n        \"toRecipients\": [\n            {\n                \"emailAddress\": {\n                    \"address\": \"ngtrainerdeveloper@gmail.com\"\n                }\n            }\n        ]\n    },\n        \"saveToSentItems\": \"false\"\n}");
        Request request = new Request.Builder()
                .url("https://graph.microsoft.com/v1.0/me/sendMail")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer EwBoA8l6BAAUbDba3x2OMJElkF7gJ4z/VbCPEz0AAWmAL1HXAXkgD0SlAp8wxAiJIdoxSeSw8KHlpIIoNkXwXyTWCXz2EKw70TETM7bZvx/erh3ka1nuxCRfL89M46ko3+LusLOGKmEfMyzX8YmawstpgK8YrVPxkAGNqFdxADsClIUDeRTGogvy7XnKrdnsDK0gJ7M4ubDNFC7hV8xSeBdDYW9Q0uQBRhiHbQuQ3ssLQ+8XoHLb62jL1RcfAUJ7tKygKSv6Y4cp7FaklW0NjvxccF3lNGkQkPPtF7/h0UvfSwaQYa+g/460NdwK/qA45lp44lOXzDklySWN3Ck2l5ykY3Bu2Y1otvOJhkgFwTBnHxUcVRe8QF6O377ynjUDZgAACEjwAE673a4cOAIPRsU3tKRkl5B2ClKjXM7djRtBrBzMd0lJjJavHPGtG0XcOFvUqbTcOVP0V9We9WOfPXv/laudvAK/sj7xT6FqQ+ywybe91t9Eucq6eQAabdXQnOnU+3zVDbbX0k2kJLlt2M8gzt3m300lliBDWtPkXkcsVhggQflCjxmSXKiycF3H2TDg3rVbhrltMetvTGMr4/kmEmt8sjJZ5nUFT584fxAyCJAydJ/Q7I/11IT1UA1rkbC8vBDAThY+YGNJ+POBdybs2IhD6v5wpPK0sMPSppjviCPaV/r6WiwO+UzjeK7QhkdF/FP+hu0Jm3/srsG9f+cwvGds/lnx2uDno8vkdbLkStlZ8wMbspFV7GbWpc0wxWjShaHN62kyOpGDp6cDfma950ciUcgqIfJ7qUVYoC1p+PtxcCEFQObTawTpO1tGSoPa4kvRNCLmA+ckGPM563PgjE5F5kwZschjie16QfS86rHH4733MRuBRlY8Gs4L76XzhsWg3SCnLxsLmfpwkafsPBfnQT7yGxVaAvKiALmsHlnsxu18IDl0Ew9m32FefBeEc6CdPblWgvSAb6H2kU6g2q518je9kcs+X3Wb5mMLBcqnqa2u646l2fsvuGcK4bVxd3Ib0irUddHD2DN4yvGAZ6gl6E/1P9ThXSK49lKUUr5wRxf6isefx5W/sIj6oxUKMOoD7IHIRZEY/VBrdc7GDd0oXbUDR5a97FHyIBF5EaDVJWzfV7tlz1HkPjqqTEEbJZWucgI=")
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        System.out.println(response.body().string());
    }
}

