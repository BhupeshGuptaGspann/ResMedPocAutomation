package com.resmed.pom.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.asserts.SoftAssert;

import com.resmed.automation.core.TestBase;
import com.resmed.automation.util.TestUtil;

import junit.framework.Assert;

public class HomePage extends TestBase {
	
	private final static Logger log = LogManager.getLogger(TestUtil.class);

	private By productQuantityTextField = By.xpath(".//*[@id='catalogAdd']");
	private By addToCartButton = By.xpath("//*[@class='dhxform_btn_txt dhxform_btn_txt_autowidth']/b[text()='Add to Cart']");
	private By productNameFrmTblText = By.xpath(".//*[@id='cart']/div[2]/table/tbody/tr[position()=2]/td[position()=3]");
	private By productQuantityFrmTblText = By.xpath(".//*[@id='cartQty']");
	private By productName_QuickEntryTextField = By.xpath(".//*[@id='QuickOrderTable']/tbody/tr[position()=1]/td[position()=2]/input");
	private By productQuantity_QuickEntryTextField = By.xpath(".//*[@id='QuickOrderTable']/tbody/tr[position()=1]/td[position()=3]/input");
	private By addToCart_QuickEntryButton = By.xpath(".//*[@id='quickEntryAddtoCart']");
	private By searachTab = By.xpath("//div[@class='dhxtabbar_tabs_cont_left']/div[@class='dhxtabbar_tab']/div[text()='Search']");
	private By productDetail_SearchTabTextField = By.xpath(".//*[@id='query']");
	private By productQuantity_SearchTabTextField = By.xpath(".//*[@id='search0']");
	private By addToCart__SearchTabBtn = By.xpath(".//*[@id='searchResults']/div[2]/table/tbody/tr[2]/td[3]/a/img");
	private By saveCartTab = By.xpath(".//*[@class='dhxtabbar_tab_text'][text()='Save Cart']");
	private By cartNameTextField = By.xpath(".//*[@id='cartName']");
	private By saveCartBtn = By.xpath("//*[@class='dhxform_btn_txt'][contains(text(),'Save Cart')]");
	private By shipToTextField = By.xpath(".//*[@id='inputCombo']");
	private By orderTypeDropDown = By.xpath(".//*[@id='selectOrderType']");
	private By viewCartBtn = By.xpath("//*[@class='dhxform_btn_txt dhxform_btn_txt_autowidth']/b[text()='View Cart']");
	private By checkOutBtn = By.xpath(".//*[@class='dhxform_item_label_left checkoutBtnGlobal action-redbtn ']/div[@role='link']/div[contains(text(),'Checkout')]");
	private By checkOutPageText = By.xpath("//*[@class='top-frame-border placeord-title']/b[text()='Place Order > Check Out']");
	private By shipToOnCheckoutPageTextField = By.xpath(".//*[@id='inputCombo2']");
	private By orderPOTextField = By.xpath(".//*[@id='orderPO']");
	private By billToTextField =  By.xpath(".//*[@id='inputCombo3']");
	private By shippingMethodDropDown = By.xpath(".//*[@id='shippingMethod']");
	private By submitOrderBtn = By.xpath(".//*[@class='dhxform_item_label_left action-redbtn']/div[@role='link']/div[contains(text(),'Submit Order')]");
	private By orderIdText = By.xpath(".//*[@id='order_nbr_confirm']");
	
	SoftAssert softAssert = new SoftAssert();
	
	@SuppressWarnings("finally")
	/**
	 * Verify Home Page of ResMed web application
	 * @param value
	 * @return
	 */
	public boolean verifyHomePage(String value) {
		try {
			handleAlert();
		} catch (NoAlertPresentException Ex) {
			System.out.println("No Alert appeared");
		} finally {
			return textEqual(getTitle(), value);
		}

	}

	public void shipToAddress(String address) {
		clear(shipToTextField);
		type(shipToTextField, address);
	}
	
	public void selectOrderType(String orderType) {
		getSelect(orderTypeDropDown, orderType);
	}
	
	public void select_Product_From_ProductCatalog(String catagory, String subcatagory, String product) {
		By productCatagoryMenuOption = By.xpath("//span[@class='standartTreeRow'][text()='" + catagory + "']");
		By productSubCatagoryMenuOption = By
				.xpath("//span[@class='standartTreeRow'][text()='" + subcatagory + "'][position()=1]");
		By productOption = By.xpath("(//span[@class='standartTreeRow'][text()='" + product + "'])[position()=2]");

		clickByJs(productCatagoryMenuOption);
		click(productSubCatagoryMenuOption);
		click(productOption);
	}

	public void add_product_to_cart(String quantity) {
		clear(productQuantityTextField);
		type(productQuantityTextField, quantity);
		clickByJs(addToCartButton);
	}

	public boolean verifyProductDetails(String product, String quantity) {
		String productDetail = getText(productNameFrmTblText);
		String productQuantity = getQuantVal(productQuantityFrmTblText);
		boolean flag1 = textEqual(product, productDetail);
		boolean flag2 = textEqual(quantity, productQuantity);
		if (flag1 == true && flag2 == true) {
			return true;
		} else {
			return false;
		}

	}

	public void add_product_from_productCart(String catagory, String subcatagory, String product, String quantity) {
		select_Product_From_ProductCatalog(catagory, subcatagory, product);
		add_product_to_cart(quantity);
	}

	public void add_product_from_quickEntry(String item, String quantity) {
		type(productName_QuickEntryTextField, item);
		type(productQuantity_QuickEntryTextField, quantity);
		click(addToCart_QuickEntryButton);

	}

	public void add_product_from_searchTab(String item, String quantity) {
		click(searachTab);
		type(productDetail_SearchTabTextField, item);
		type(productQuantity_SearchTabTextField, quantity);
		click(addToCart__SearchTabBtn);

	}

	public void save_cart_with_name(String cartName) {
		clickByJs(saveCartTab);
		type(cartNameTextField, cartName);
		clickByJs(saveCartBtn);
	}
	
	public void click_on_view_cart() {
		clickByJs(viewCartBtn);
	}
	
	public void verify_cart_name(String cartName) {
		By savedCartLink = By.xpath("//span[@class='standartTreeRow'][text()='"+cartName+"']");
		boolean flag = isElementPresent(savedCartLink);
		softAssert.assertTrue(flag);
	}
	
	public void click_on_checkout() throws InterruptedException {
		Thread.sleep(10000);
		clickByMouse(checkOutBtn);
	}
	
	public void verifyCheckOutPageText() {
		boolean flag = isElementPresent(checkOutPageText);
		Assert.assertTrue(flag);
	}
	
	public void shipToAddressOnCheckOutPage(String address) {
		clear(shipToOnCheckoutPageTextField);
		type(shipToOnCheckoutPageTextField, address);
	}
	
	public void fillOrderPO(String PO) {
		type(orderPOTextField, PO);
	}
	
	public void billToAddress(String address) {
		clear(billToTextField);
		type(billToTextField, address);
	}
	
	public void shippingMethod(String method) {
		getSelect(shippingMethodDropDown, method);
	}
	
	public void submitOrderAndAcceptAlert() throws InterruptedException {
		Thread.sleep(10000);
		clickByMouse(submitOrderBtn);
		handleAlert();
		Thread.sleep(10000);
	}
	
	public void fetchOrderId() {
		String OrderId = getText(orderIdText);
		log.info("Order ID is::" +OrderId);
		
	}
}
