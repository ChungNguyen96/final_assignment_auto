package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.common.GlobalConstants;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.ListBookPageUI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    public List<String> getBookByRate(int number){
        List<String> listRate = getListBookRated();
        List<String> listBook = new ArrayList<>();
        for (int i = 0;i<number; i++){
            listBook.add(getWebElement( driver,ListBookPageUI.BOOK_BY_RATE,listRate.get(i)).getText());
        }
        return  listBook;
    }

    public List<String> getListBookRated() {
        List<WebElement> listWebElement = getListWebElements(driver, ListBookPageUI.LISTBOOK_RATE);
        List<String> listRate = new ArrayList<>();
        for (WebElement element : listWebElement) {
            String style = element.getAttribute("style");
            style.substring(style.indexOf(":") + 1, style.length()-2);
            if (haveButtonAddToCart(style)){
                listRate.add(style.substring(style.indexOf(":") + 1, style.length()-2));
            }
        }
        Collections.sort(listRate);
        return listRate;
    }

    public List<String> getListBookTitle() {
        List<WebElement> listWebElement = getListWebElements(driver, ListBookPageUI.LISTBOOKS_TITLE);
        List<String> listBook = new ArrayList<>();
        for (WebElement element : listWebElement) {
            listBook.add(element.getText());
        }
        return listBook;
    }

    public Map getMapTitleWithRate() {
        List<String> listBookTitle = getListBookTitle();
        List<String> listBookRated = getListBookRated();
        Map<String, String> listBookRateUnSort = new HashMap<>();
        for (int i = 0; i < listBookTitle.size(); i++) {
            if (haveButtonAddToCart(listBookTitle.get(i))) {
                listBookRateUnSort.put(listBookTitle.get(i), listBookRated.get(i));
            }

        }
        //LinkedHashMap preserve the ordering of elements in which they are inserted
        LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>();

        listBookRateUnSort.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }

    private boolean haveButtonAddToCart(String rate) {
        List<WebElement> listBtn = getListWebElements(driver, ListBookPageUI.BTN_ADD_TO_CART_BY_RATE, rate);
        if (listBtn.size() != 0) return true;
        else return false;
    }

    public List<String> getTwoBookHigestRate() {
        List<String> listBookHighestRate = new ArrayList<>();
        Map<String, String> mapBookRate = getMapTitleWithRate();
        for (String key : mapBookRate.keySet()) {
            listBookHighestRate.add(key);
        }
        Collections.reverse(listBookHighestRate);
        return listBookHighestRate;
    }

    public void clickBookHighestRate(int index, List<String> list) {
        clickToElement(driver, ListBookPageUI.BTN_ADD_TO_CART, list.get(index - 1));
        Log.allure("Click book: %s", list.get(index - 1));
        listBookInCart.add( list.get(index - 1));
    }

    public boolean isDisplayMsgAddToCart() {

        waitForElementVisible(driver, ListBookPageUI.BAR_NOTIFICATION);
        return isElementDisplay(driver, ListBookPageUI.BAR_NOTIFICATION);
    }

    public void hoverOnCart() {
        hoverMouseToElement(driver, ListBookPageUI.CART);
    }

    public int getQuantityIncart() {
        overrideImplicitTimeOut(driver,GlobalConstants.LONG_TIMEOUT);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, ListBookPageUI.CART_QUANTITY));
        String quantity = getWebElement(driver, ListBookPageUI.CART_QUANTITY).getText();
        System.out.println(quantity.indexOf("(") + 1);
        System.out.println(quantity);
        return Integer.parseInt(quantity.substring(quantity.indexOf("(") + 1, quantity.indexOf(")")));
    }

    public boolean increaseNumberIncart(int before, int after) {
        if (after == (before+1)) return true;
        else return false;
    }
    public List<String> getListBookDisplayInCart(){
        List<WebElement> webElementList = getListWebElements(driver,ListBookPageUI.BOOK_NAME_IN_MINI_CART);
        List<String> listBookName = new ArrayList<>();
        for (WebElement element:webElementList) {
            listBookName.add(element.getText());
        }
        return listBookName;
    }
    public boolean compareListBookDisplayInCart(List<String> listExpect, List<String> listActual){
        return listExpect.equals(listActual);
    }
}
