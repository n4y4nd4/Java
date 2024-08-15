//fornecem funcionalidades essenciais para manipulação e envio de e-mails em Java.
import java.util.Properties; //usada para configurar detalhes do servidor de e-mail
import javax.mail.*; //oferecem uma API completa para criar, formatar e enviar mensagens de e-mail.
import javax.mail.internet.*;


//Classe responsável pelo envio de e-mails

public class EmailSender {
    public static void sendEmail(String to, String subject, String body) {
        // Credenciais de autenticação do remetente
        final String username = "nayanda.robers@gmail.com";
        final String password = "dooj tymj pdiv vewf";

        // Configurações do servidor SMTP (Gmail)
        String host = "smtp.gmail.com";
        String port = "587";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Estabelecimento da sessão para comunicação com o servidor
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Criação da mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Envio efetivo da mensagem ao destinatário
            Transport.send(message);

            // Indicação visual do sucesso do envio
            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            // Exceção lançada em caso de problemas durante o envio
            throw new RuntimeException(e);
        }
    }
}
