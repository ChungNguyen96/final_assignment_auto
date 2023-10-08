package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.common.GlobalConstants;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.ListBookPageUI;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ListBookPageObject extends BasePage {
    private WebDriver driver;
    public int quantity;
    private List<String> listBookInCart = new ArrayList<>();

    public List<String> getListBookInCart() {
        return listBookInCart;
    }

    public ListBookPageObject(WebDriver driver) {
        this.driver = driver;

    }

    public boolean isDisplayBooksScreen() {
        waitForElementVisible(driver, ListBookPageUI.TITLE_BOOK_PAGE);
        return isElementDisplay(driver, ListBookPageUI.TITLE_BOOK_PAGE);
    }

    public List<String> getBookByRate(int number) {
        List<String> listRate = getListRated();
        List<String> listBook = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            listBook.add(getWebElement(driver, ListBookPageUI.BOOK_BY_RATE, listRate.get(i)).getText());
        }
        return listBook;
    }

    public List<String> getListRated() {
        List<WebElement> listWebElementRate = getListWebElements(driver, ListBookPageUI.LISTBOOK_RATE);
        List<String> listRate = new ArrayList<>();
        for (WebElement element : listWebElementRate) {
            String style = element.getAttribute("style");
            String rate = style.substring(style.indexOf(":") + 1, style.length() - 2);
            if (haveButtonAddToCart(rate)) {
                listRate.add(rate);
            }
        }
        Collections.sort(listRate,Collections.reverseOrder());
        return listRate;
    }

    private boolean haveButtonAddToCart(String rate) {
        overrideImplicitTimeOut(driver, 1);
        List<WebElement> listBtn = getListWebElements(driver, ListBookPageUI.BTN_ADD_TO_CART_BY_RATE, rate);
        if (listBtn.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void clickBookHighestRate(int index, List<String> list) {
        clickToElement(driver, ListBookPageUI.BTN_ADD_TO_CART, list.get(index - 1));
        Log.allure("Click book: %s", list.get(index - 1));
        listBookInCart.add(list.get(index - 1));
    }

    public boolean isDisplayMsgAddToCart() {
        waitForElementVisible(driver, ListBookPageUI.BAR_NOTIFICATION);
        return isElementDisplay(driver, ListBookPageUI.BAR_NOTIFICATION);
    }

    public void hoverOnCart() {
        hoverMouseToElement(driver, ListBookPageUI.CART);
    }

    public int getQuantityIncart() {
        overrideImplicitTimeOut(driver, GlobalConstants.LONG_TIMEOUT);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, ListBookPageUI.CART_QUANTITY));
        String quantity = getWebElement(driver, ListBookPageUI.CART_QUANTITY).getText();
        return Integer.parseInt(quantity.substring(quantity.indexOf("(") + 1, quantity.indexOf(")")));
    }

    public boolean increaseNumberIncart(int before, int after) {
        if (after == (before + 1)) return true;
        else return false;
    }

    public List<String> getListBookDisplayInCart() {

        List<WebElement> webElementList = getListWebElements(driver, ListBookPageUI.BOOK_NAME_IN_CART);
        List<String> listBookName = new ArrayList<>();
        for (WebElement element : webElementList) {
            System.out.println(element);
            listBookName.add(element.getText());
            System.out.println("Name" +element.getText());
        }

       // Collections.reverseOrder();
        return listBookName;
    }

    public boolean compareListBookDisplayInCart(List<String> listExpect, List<String> listActual) {
        return listExpect.equals(listActual);
    }
}
