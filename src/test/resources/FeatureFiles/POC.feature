Feature: POC scenerios
 @demo
 Scenario: Verify Login with valid Credentials
  Given user is on Login Page
  Then login with username and Password
  Then verify user is on Home Page
  Then click on Logout button
  Then verify user is on Login Page

 Scenario: Verify Login with invalid Credentials
  Given user is on Login Page
  Then login with invalid username and Password
  Then verify and accept the alert with message Invalid username or password

 
 Scenario: Place Order by choosing product from Product Catalog
 Given user is on Login Page
 Then login with username and Password
 Then verify user is on Home Page
 Then select Ship To as "311 A ASHVILLE AVE, CARY, NC, 27511"
 Then select Order Type as "Standard-HME"
 Then add products by "Full Face Masks_Quattro FX for Her_Quattro™ FX Cushion (Large)_1" from Product Catalog
 Then click on View Cart button
 Then verify product with "Quattro™ FX Cushion (Large)_1" added to cart
 Then click on Logout button
 Then verify user is on Login Page


Scenario: Place Order by choosing product from Quick Entry
 Given user is on Login Page
 Then login with username and Password
 Then verify user is on Home Page
 Then select Ship To as "311 A ASHVILLE AVE, CARY, NC, 27511"
 Then select Order Type as "Standard-HME"
 Then add products by "61722_1" from Quick Entry
 Then verify product with "Quattro™ FX Cushion (Large)_1" added to cart
 Then click on Logout button
 Then verify user is on Login Page

 
Scenario: Place Order by choosing product from Search Tab
 Given user is on Login Page
 Then login with username and Password
 Then verify user is on Home Page
 Then select Ship To as "311 A ASHVILLE AVE, CARY, NC, 27511"
 Then select Order Type as "Standard-HME"
 Then add products by "61722_1" from Search Tab
 Then verify product with "Quattro™ FX Cushion (Large)_1" added to cart
 Then click on Logout button
 Then verify user is on Login Page
 

Scenario: Verify Save Cart functionality at Place Order tab
 Given user is on Login Page
 Then login with username and Password
 Then verify user is on Home Page
 Then select Ship To as "311 A ASHVILLE AVE, CARY, NC, 27511"
 Then select Order Type as "Standard-HME"
 Then add products by "Full Face Masks_Quattro FX for Her_Quattro™ FX Cushion (Large)_1" from Product Catalog
 Then click on View Cart button
 Then verify product with "Quattro™ FX Cushion (Large)_1" added to cart
 Then save cart with the name "Cart1" from SaveCart Tab
 Then verify cart name "Cart1" is visible in Saved Carts section
 Then click on Logout button
 Then verify user is on Login Page
 
 
 Scenario: End to end positive workflow of placing an order
 Given user is on Login Page
 Then login with username and Password
 Then verify user is on Home Page
 Then select Ship To as "311 A ASHVILLE AVE, CARY, NC, 27511"
 Then select Order Type as "Standard-HME"
 Then add products by "Full Face Masks_Quattro FX for Her_Quattro™ FX Cushion (Large)_1" from Product Catalog
 Then click on View Cart button
 Then verify product with "Quattro™ FX Cushion (Large)_1" added to cart
 Then click on CheckOut button
 Then verify user is on CheckOut Page
 Then select Ship To as "311 A ASHVILLE AVE, CARY, NC, 27511" on Checkout Page
 Then fill PO as "GreenVille"
 Then select Bill To as "PO BOX 1121, DUNN, NC, 28335" on Checkout Page
 Then select Shipping Method as "2 Day"
 Then click on SubmitOrder button and accept the alert
 Then fetch orderId
 Then click on Logout button
 Then verify user is on Login Page