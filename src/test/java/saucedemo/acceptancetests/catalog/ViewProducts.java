package saucedemo.acceptancetests.catalog;

import net.serenitybdd.core.steps.WebDriverScenarios;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import saucedemo.domain.authetication.LoginForm;
import saucedemo.domain.catalog.ProductList;


import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class ViewProducts extends WebDriverScenarios {

    @Test
    void shouldCheckNumberOfDisplayedProducts(){
        openUrl("https://www.saucedemo.com/");
        $(LoginForm.USERNAME_FIELD).type("standard_user");
        $(LoginForm.PASSWORD_FIELD).type("secret_sauce");
        $(LoginForm.LOGIN_BUTTON).click();
        Assertions.assertThat(findAll(ProductList.INVENTORY_ITEM_NAME)).hasSize(6);
    }
}
