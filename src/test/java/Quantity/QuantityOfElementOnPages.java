package Quantity;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ImplemantationsPage.PageWithAllImplementation;
import PageProduts.PageWithAllProducts;
import SolutionsPage.PageWithAllSolutions;
import SuppliersPage.PageWithAllSuppliers;
import VendorsPage.PageWithAllVendors;
import roi4cio.login.HomePage;
import roi4cio.login.ROI4CIO;

public class QuantityOfElementOnPages {
	private ROI4CIO roi = new ROI4CIO();
	private HomePage homePage;
	private PageWithAllProducts productsPage;
	private PageWithAllSolutions solutionsPage;
	private PageWithAllImplementation implementationsPage;
	private PageWithAllSuppliers suppliersPage;
	private PageWithAllVendors vendorsPage;

	@BeforeMethod
	private void setUp() {
		homePage = roi.openHomePage();
	}

	@Test
	public void verifyQuantityOfProducts() {
		String a = homePage.numberOfProduct();
		productsPage = homePage.goToProductsPage();
		String b = productsPage.quantityOfProducts();
		Assert.assertEquals(b, a, "Expected result" + a + "not equals" + b);
	}
	@Test
	public void verifyQuantityOfSolutions() {
		String a = homePage.numberOfSolutions();
		solutionsPage = homePage.goToSolutionsPage();
		String b = solutionsPage.quantityOfSolutions();
		Assert.assertEquals(b, a, "Expected result" + a + "not equals" + b);
	}
	@Test
	public void verifyQuantityOfImplementations() {
		String a = homePage.numberOfImplementations();
		implementationsPage = homePage.goToImplementationsPage();
		String b = implementationsPage.quantityOfImplementations();
		Assert.assertEquals(b, a, "Expected result" + a + "not equals" + b);
	}
	@Test
	public void verifyQuantityOfSuppliers() {
		String a = homePage.numberOfSuppliers();
		suppliersPage = homePage.goToSuppliersPage();
		String b = suppliersPage.quantityOfPSuppliers();
		Assert.assertEquals(b, a, "Expected result" + a + "not equals" + b);
	}
	@Test
	public void verifyQuantityOfVendors() {
		String a = homePage.numberOfVendors();
		vendorsPage = homePage.goToVendorsPage();
		String b = vendorsPage.quantityOfVendors();
		Assert.assertEquals(b, a, "Expected result" + a + "not equals" + b);
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		roi.close();
	}
}
