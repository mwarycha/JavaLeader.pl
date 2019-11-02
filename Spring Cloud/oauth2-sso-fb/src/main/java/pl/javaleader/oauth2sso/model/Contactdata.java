package pl.javaleader.oauth2sso.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Entity;

@Entity
public class Contactdata extends AbstractBaseEntity {

    @Length(min = 3, max = 100, message = "długość nicku powinna być z zakresu od 3 do 100 znaków")
    private String nick;

    @Length(min = 3, max = 100,message = "długość tematu powinna być z zakresu od 3 do 100 znaków")
    private String topic;

    @Email
    @NotEmpty(message = "nie podałeś/aś adresu email")
    private String email;

    @Length(min = 50, max = 500, message = "długość wiadomości powinna być z zakresu od 50 do 500 znaków")
    private String message;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
