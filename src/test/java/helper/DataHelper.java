package helper;

import models.LoginUser;
import models.User;
import utils.configuration.ReadProperties;

public class DataHelper {

    public static LoginUser getUserToLogin() {
        LoginUser user = new LoginUser();
        user.setEmail(ReadProperties.email());
        user.setPassword(ReadProperties.password());
        return user;
    }

    public static User getUserToAdd() {
        User user = new User();
        user.setFirstName(FakerHelper.faker.name().firstName());
        user.setLastName(FakerHelper.faker.name().lastName());
        user.setEmail(FakerHelper.faker.internet().emailAddress());
        user.setPassword("Qwe123asd!");
        user.setConfirmPassword("Qwe123asd!");
        return user;
    }

}
