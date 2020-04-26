package com.github.conciso.keycloak.email;

import org.jboss.logging.Logger;
import org.keycloak.email.DefaultEmailSenderProvider;
import org.keycloak.email.EmailException;
import org.keycloak.email.EmailSenderProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserModel;

import java.util.Map;

public class EmailPrefixSenderProvider implements EmailSenderProvider {

  private static final Logger logger = Logger.getLogger(EmailPrefixSenderProvider.class);

  private final KeycloakSession session;
  private final String subjectPrefix;

  EmailPrefixSenderProvider(KeycloakSession session, String subjectPrefix) {
    this.session = session;
    this.subjectPrefix = subjectPrefix;
  }

  public void send(Map<String, String> config, UserModel user, String subject, String textBody, String htmlBody) throws EmailException {
    String prefixedSubject = subjectPrefix + subject;
    logger.infov("Sending email with prefixed subject: {0}", prefixedSubject);
    EmailSenderProvider defaultProvider = new DefaultEmailSenderProvider(session);
    /*
      You can also lookup other providers from the session.

      ATTENTION: Looking up the default provider does not seem to work as of time writing this example.
      For details see: https://groups.google.com/forum/#!searchin/keycloak-dev/sven-torben%7Csort:date/keycloak-dev/HBJZCwdMsMk/phDSonVvAgAJ

    EmailSenderProvider defaultProvider = session.getProvider(EmailSenderProvider.class, "default");
     */
    defaultProvider.send(config, user, prefixedSubject, textBody, htmlBody);
  }

  public void close() {
  }

}
