package roi4cio;

import static loginData.Users.VALID_USER;
import static roi4cio.add.product.TestData.CategoryAndDeliveryAreEmpty;
import static roi4cio.add.product.TestData.CategoryIsEmpty;
import static roi4cio.add.product.TestData.EmptyMandatoryFields;
import static roi4cio.add.product.TestData.FilledAllMandatoryFields;
import static roi4cio.add.product.TestData.ProductWithNewTitle;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import roi4cio.add.product.ProductModel;
import roi4cio.login.AddProductPage;
import roi4cio.login.MyProductsPage;
import roi4cio.login.MyProfilePage;
import roi4cio.login.ROI4CIO;

public class TestAddProduct {

	private ROI4CIO roi = new ROI4CIO();

	private MyProfilePage myProfilePage;
	private MyProductsPage myProductsPage;
	private AddProductPage addProductPage;
	private ProductModel testProduct;

	private String someError = "Некоторые ошибки";
	private String productNameError = "\nПродукт с таким именем уже существует";
	private String categoryError = "\nКатегория продукта: Задано пустое значение.";
	private String deliveryError = "\nТип поставки: Задано пустое значение.";
	private String productEmptyError = "\nНазвание: Задано пустое значение.";
	private String countryError = "\nСтрана: Задано пустое значение.";

	@BeforeMethod
	private void setUp() {
		myProfilePage = roi.openHomePage().clickOnLoginIcon().loginAs(VALID_USER);
		testProduct = FilledAllMandatoryFields;
	}

	@Test(priority = 1)
	public void testAddProduct() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addProduct(FilledAllMandatoryFields);
		addProductPage.save();
		Assert.assertTrue(myProductsPage.productNameList().contains(testProduct));
	}

	@Test(priority = 2)
	public void testAddProductWithSameName() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addProduct(testProduct);
		addProductPage.save();
		Assert.assertEquals(addProductPage.textErrorMessage(), someError + productNameError,
				"Product with the same title couldn't be created");
	}

	@Test
	public void testAddProductWithEmptyCategory() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addProduct(CategoryIsEmpty);
		addProductPage.clickSaveButton();
		Assert.assertEquals(addProductPage.textErrorMessage(), someError + categoryError);

	}

	@Test
	public void testAddPdocutWithEmptyDeliveryAndCategory() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addProduct(CategoryAndDeliveryAreEmpty);
		addProductPage.clickSaveButton();
		Assert.assertEquals(addProductPage.textErrorMessage(), someError + deliveryError + categoryError);
	}

	@Test
	public void testAddProductWithEmptyMandatoryFields() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addProduct(EmptyMandatoryFields);
		addProductPage.clickSaveButton();
		Assert.assertEquals(addProductPage.textErrorMessage(),
				someError + productEmptyError + deliveryError + categoryError);
	}

	@Test
	public void testAddProductWithoutCountry() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addProduct(ProductWithNewTitle);
		addProductPage.selectCountry();
		addProductPage.save();
		Assert.assertEquals(addProductPage.textErrorMessage(), someError + countryError);
	}

	@Test
	public void testAddProductWithEmptyAllFields() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addProduct(EmptyMandatoryFields);
		addProductPage.selectCountry();
		addProductPage.clickSaveButton();
		Assert.assertEquals(addProductPage.textErrorMessage(),
				someError + productEmptyError + countryError + deliveryError + categoryError);
	}

	@Test
	public void testAddProductConfirmationPopup() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addProduct(testProduct);
		;
		addProductPage.selectCountry();
		addProductPage.clickOnFlag();
		Assert.assertTrue(addProductPage.Popup());
	}

	@Test
	public void testAddProductCickOnYesInConfirmationPopup() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addProduct(testProduct);
		addProductPage.selectCountry();
		addProductPage.clickOnFlag();
		addProductPage.clickOnYesButton();
		Assert.assertTrue(addProductPage.englishPageAddProduct());
	}

	@Test
	public void testAddProductClickOnYesInConfirmationPopupAfterErrors() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addProduct(testProduct);
		addProductPage.clickSaveButton();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addProductPage.selectDeliveryType();
		addProductPage.clickOnFlag();
		addProductPage.clickOnYesButton();
		Assert.assertTrue(addProductPage.englishPageAddProduct());
	}

	@Test
	public void testAddProductWithFilledAllFields() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
		addProductPage.addTitleForProduct(" ", " ");
		addProductPage.clickSaveButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		addProductPage.addProduct(ProductWithNewTitle);
		addProductPage.save();
		Assert.assertTrue(myProductsPage.productNameList().contains(ProductWithNewTitle));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		roi.close();
	}
}
