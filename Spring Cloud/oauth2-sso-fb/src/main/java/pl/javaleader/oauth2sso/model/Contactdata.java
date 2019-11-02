package pl.javaleader.oauth2sso.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
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
}
