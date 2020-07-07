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

  private static final String CONFIG_SUBJECT_PREFIX = "subjectPrefix";

  private Config.Scope config;

  public EmailSenderProvider create(KeycloakSession session) {

    /*
    EmailSenderProvider defaultProvider = session.getProvider(EmailSenderProvider.class, "default");
    */

    EmailSenderProviderFactory factory = new DefaultEmailSenderProviderFactory();
    EmailSenderProvider defaultProvider = factory.create(session);

    String subjectPrefix = config.get(CONFIG_SUBJECT_PREFIX, "");

    return new EmailPrefixSenderProvider(defaultProvider, subjectPrefix);
  }

  public void init(Config.Scope config) {
    this.config = config;
  }

  public void postInit(KeycloakSessionFactory factory) {
  }

  public void close() {
  }

  public String getId() {
    return "email-prefix";
  }

  public Map<String, String> getOperationalInfo() {
    String prefix = config.get(CONFIG_SUBJECT_PREFIX, "");
    return Map.of(CONFIG_SUBJECT_PREFIX, prefix);
  }
}
