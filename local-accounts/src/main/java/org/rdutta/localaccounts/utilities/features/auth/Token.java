package org.rdutta.localaccounts.utilities.features.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.rdutta.localaccounts.utilities.features.secrets.Secrets;
import org.rdutta.localaccounts.utilities.features.time.TimeExpirationScheduler;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Service
public class Token {

    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails, TimeExpirationScheduler.VALIDITY);
    }

    public String generateToken(UserDetails userDetails, long validityTime) {

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + validityTime))
                .signWith(generateSecretKey(), Jwts.SIG.HS384)
                .compact();
    }

    private SecretKey generateSecretKey() {
        byte[] keyBytes = Base64.getDecoder().decode(Secrets.TOKEN_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        Claims claims = getClaimsFromToken(token);

        return claims.getSubject();
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(generateSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(generateSecretKey())
                .build().parseSignedClaims(token).getPayload();
    }
}

