package helper;

import models.LoginUser;
import models.User;
import utils.configuration.ReadProperties;

public class DataHelper {

    public static LoginUser getUserToLogin() {
        LoginUser user = LoginUser.builder()
                .email(ReadProperties.email())
                .password(ReadProperties.password())
                .build();
        return user;
    }

    public static User getUserToAdd() {
        User user = User.builder()
                .firstName(FakerHelper.faker.name().firstName())
                .lastName(FakerHelper.faker.name().lastName())
                .email(FakerHelper.faker.internet().emailAddress())
                .password("Qwe123asd!")
                .confirmPassword("Qwe123asd!")
                .build();

        return user;
    }

}
