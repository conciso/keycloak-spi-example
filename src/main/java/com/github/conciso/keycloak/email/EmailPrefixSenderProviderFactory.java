package com.github.conciso.keycloak.email;

import org.keycloak.Config;
import org.keycloak.email.DefaultEmailSenderProviderFactory;
import org.keycloak.email.EmailSenderProvider;
import org.keycloak.email.EmailSenderProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ServerInfoAwareProviderFactory;

import java.util.Map;

public class EmailPrefixSenderProviderFactory implements EmailSenderProviderFactory, ServerInfoAwareProviderFactory {

  public EmailSenderProvider create(KeycloakSession session) {

    /*
    EmailSenderProvider defaultProvider = session.getProvider(EmailSenderProvider.class, "default");
    */

    EmailSenderProviderFactory factory = new DefaultEmailSenderProviderFactory();
    EmailSenderProvider defaultProvider = factory.create(session);
    return new EmailPrefixSenderProvider(defaultProvider);
  }

  public void init(Config.Scope config) {
  }

  public void postInit(KeycloakSessionFactory factory) {
  }

  public void close() {
  }

  public String getId() {
    return "email-prefix";
  }

  public Map<String, String> getOperationalInfo() {
    return Map.of();
  }
}
