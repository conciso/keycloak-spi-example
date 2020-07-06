package com.github.conciso.keycloak.email;

import org.jboss.logging.Logger;
import org.keycloak.email.EmailException;
import org.keycloak.email.EmailSenderProvider;
import org.keycloak.models.UserModel;

import java.util.Map;

public class EmailPrefixSenderProvider implements EmailSenderProvider {

  private static final Logger logger = Logger.getLogger(EmailPrefixSenderProvider.class);

  private final EmailSenderProvider defaultProvider;

  EmailPrefixSenderProvider(EmailSenderProvider defaultProvider) {
    this.defaultProvider = defaultProvider;
  }

  public void send(Map<String, String> config, UserModel user, String subject, String textBody, String htmlBody) throws EmailException {
    logger.infov("Sending email");
    defaultProvider.send(config, user, subject, textBody, htmlBody);
  }

  public void close() {
  }

}
