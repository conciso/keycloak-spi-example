package com.github.conciso.keycloak.email;

import org.keycloak.email.EmailSenderProvider;
import org.keycloak.models.UserModel;

import java.util.Map;

public class EmailPrefixSenderProvider implements EmailSenderProvider {

  EmailPrefixSenderProvider() {
  }

  public void send(Map<String, String> config, UserModel user, String subject, String textBody, String htmlBody) {
  }

  public void close() {
  }

}
