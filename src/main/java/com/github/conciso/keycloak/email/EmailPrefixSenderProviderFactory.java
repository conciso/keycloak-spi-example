package com.github.conciso.keycloak.email;

import org.jboss.logging.Logger;
import org.keycloak.Config;
import org.keycloak.email.EmailSenderProvider;
import org.keycloak.email.EmailSenderProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ServerInfoAwareProviderFactory;

import java.util.Map;

public class EmailPrefixSenderProviderFactory implements EmailSenderProviderFactory, ServerInfoAwareProviderFactory {

    private static final Logger logger = Logger.getLogger(EmailPrefixSenderProviderFactory.class);
    private static final String CONFIG_SUBJECT_PREFIX = "subjectPrefix";

    private Config.Scope config;

    public EmailSenderProvider create(KeycloakSession session) {
        String subjectPrefix = config.get(CONFIG_SUBJECT_PREFIX);
        return new EmailPrefixSenderProvider(session, subjectPrefix);
    }

    public void init(Config.Scope config) {
        this.config = config;
    }

    public void postInit(KeycloakSessionFactory factory) {
        logger.infov("{0} initialzed", getClass().getSimpleName());
    }

    public void close() {
      logger.debugv("{0} initialzed", getClass().getSimpleName());
    }

    public String getId() {
        return "email-prefix";
    }

    public Map<String, String> getOperationalInfo() {
        return Map.of(CONFIG_SUBJECT_PREFIX, config.get(CONFIG_SUBJECT_PREFIX));
    }
}
