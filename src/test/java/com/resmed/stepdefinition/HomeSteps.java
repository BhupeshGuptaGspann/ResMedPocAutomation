package com.resmed.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.resmed.pom.pages.BasePage;

import cucumber.api.java.en.Then;

public class HomeSteps extends BasePage {

	@Then("^select Ship To as \"(.*?)\"$")
	public void select_Ship_To(String address) {
		homePage.shipToAddress(address);
	}

	@Then("^select Order Type as \"(.*?)\"$")
	public void select_Order_Type_as(String orderType) {
		homePage.selectOrderType(orderType);
	}

	@Then("^add products by \"(.*?)\" from Product Catalog$")
	public void add_product_from_Product_Catalog(String productDetail) {
		String[] details = productDetail.split("_");
		System.out.println(details[0]);
		System.out.println(details[1]);
		System.out.println(details[2]);
		System.out.println(details[3]);
		homePage.add_product_from_productCart(details[0], details[1], details[2], details[3]);
	}

	@Then("^verify product with \"(.*?)\" added to cart$")
	public void verify_product_details(String productDetail) {
		String[] details = productDetail.split("_");
		boolean flag = homePage.verifyProductDetails(details[0], details[1]);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(flag);
	}
	
	@Then("^click on View Cart button$")
	public void click_on_view_cart_button()
	{
		homePage.click_on_view_cart();
	}
	
	@Then("^add products by \"(.*?)\" from Quick Entry$")
	public void add_product_by_quick_entry(String productDetail)
	{
		String[] details = productDetail.split("_");
		homePage.add_product_from_quickEntry(details[0], details[1]);
	}
	
	@Then("^add products by \"(.*?)\" from Search Tab$")
	public void add_product_by_search_tab(String productDetail)
	{
		String[] details = productDetail.split("_");
		homePage.add_product_from_searchTab(details[0], details[1]);
	}
	
	@Then("^save cart with the name \"(.*?)\" from SaveCart Tab$")
	public void save_cart_with_cart_name(String cartName)
	{
		homePage.save_cart_with_name(cartName);
	}
	
	@Then("^verify cart name \"(.*?)\" is visible in Saved Carts section$")
	public void verify_cart_name_in_Saved_cart(String cartName)
	{
		homePage.verify_cart_name(cartName);
		
	}
	
	@Then("^click on CheckOut button$")
	public void click_on_checkout_button() throws InterruptedException
	{
		homePage.click_on_checkout();
	}
	
	@Then("^verify user is on CheckOut Page$")
	public void verify_user_is_on_checkout_page()
	{
		homePage.verifyCheckOutPageText();
	}
	
	@Then("^select Ship To as \"(.*?)\" on Checkout Page$")
	public void select_Ship_To_as_on_checkout_page(String address) {
		homePage.shipToAddressOnCheckOutPage(address);
	}
	
	@Then("^fill PO as \"(.*?)\"$")
	public void fill_PO(String po)
	{
		homePage.fillOrderPO(po);
	}
	
	@Then("^select Bill To as \"(.*?)\" on Checkout Page$")
	public void select_Bill_To_as_on_checkout_page(String address) {
		homePage.billToAddress(address);
	}
	
	@Then("^select Shipping Method as \"(.*?)\"$")
	public void select_Shipping_Method(String method)
	{
		homePage.shippingMethod(method);
	}
	
	@Then("^click on SubmitOrder button and accept the alert$")
	public void click_on_submit_button() throws InterruptedException
	{
		homePage.submitOrderAndAcceptAlert();
	}
	
	@Then("^fetch orderId$")
	public void fetch_orderId()
	{
		homePage.fetchOrderId();
	}

}
