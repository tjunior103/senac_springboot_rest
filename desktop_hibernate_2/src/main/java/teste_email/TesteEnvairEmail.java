package teste_email;

//import br.com.utilitario.UtilGerador;
import entidade.Usuario;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Silvio
 */
public class TesteEnvairEmail {

    private Session session;

    private void abrirSessaoEmail() {
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("senacsilviojunior@gmail.com",
                        "sp_junior");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);
    }

    public boolean enviaEmailTeste(Usuario usuario) {
        boolean enviado = false;
        try {
            abrirSessaoEmail();
            StringBuilder mensagemEmail = new StringBuilder();
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("senacsilviojunior@gmail.com"));
            //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(usuario.getLogin());

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Sistema XYZ - Dados de acesso!");//Assunto
            
            
            mensagemEmail.append("Olá ").append(usuario.getNome()).append("!");
            mensagemEmail.append("\n\n");
            mensagemEmail.append("Segue os dados de cesso do sistema XYZ Ltda!");
            mensagemEmail.append("\n\n");
            mensagemEmail.append("Seu login é seu e-mail ").append(usuario.getLogin());
            mensagemEmail.append("\n");
            mensagemEmail.append("Sua senha é ").append(usuario.getSenha());
            mensagemEmail.append("\n\n");
            mensagemEmail.append("Atenciosamente RH XYZ Ltda.");
            
            
            message.setText(mensagemEmail.toString());
            
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
            enviado = true;
            System.out.println("E-mail enviado!!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return enviado;
    }
    
    public static void main(String[] args) {
        TesteEnvairEmail teste = new TesteEnvairEmail();
        Usuario usuario = new Usuario("Silvio Junior", "tjunior103@gmail.com", "12345");
        boolean foi = teste.enviaEmailTeste(usuario);
        if(foi){
            System.out.println("Foiiii");
        }
    }
}
