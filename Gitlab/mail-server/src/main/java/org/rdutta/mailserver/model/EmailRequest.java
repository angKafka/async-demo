package org.rdutta.mailserver.model;

public record EmailRequest(
         String from,
         String to,
         String subject,
         String body) {
}
