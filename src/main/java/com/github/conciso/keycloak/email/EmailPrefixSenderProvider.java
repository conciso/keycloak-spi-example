package com.github.conciso.keycloak.email;

import org.jboss.logging.Logger;
import org.keycloak.email.EmailSenderProvider;
import org.keycloak.models.UserModel;

import java.util.Map;

public class EmailPrefixSenderProvider implements EmailSenderProvider {

  private static final Logger logger = Logger.getLogger(EmailPrefixSenderProvider.class);

  EmailPrefixSenderProvider() {
  }

  public void send(Map<String, String> config, UserModel user, String subject, String textBody, String htmlBody) {
    logger.infov("Sending email");
  }

  public void close() {
  }

}
