package NPB.utilities;


import javax.mail.*;
import javax.mail.search.SubjectTerm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public class TryCode {

    public static final String EMAIL = System.getenv("EMAIL_USERNAME");
    public static final String PASSWORD = System.getenv("EMAIL_PASSWORD");


    public static void check(String host, String storeType, String user,
                             String password) {
        try {
            //create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            System.out.println("Unread Message:"
                    + emailFolder.getUnreadMessageCount());

            Message[] messages = null;
            boolean isMailFound = false;
            Message mailFromItaxi = null;

            //Search unread message
            for (Message mail : messages) {
                if (!mail.isSet(Flags.Flag.SEEN)) {
                    mailFromItaxi = mail;
                    System.out.println("Message Count is: "
                            + mailFromItaxi.getMessageNumber());
                    isMailFound = true;
                }
            }

            //Test fails if no unread mail was found from God
            if (!isMailFound) {
                throw new Exception("Could not find new mail from God :-(");
                //Read the content of mail and launch registration URL
            } else {
                String line;
                StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(mailFromItaxi.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                System.out.println(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String username = EMAIL;// change accordingly
        String password = PASSWORD;// change accordingly

        check(host, mailStoreType, username, password);

    }
}
