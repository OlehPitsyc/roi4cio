package Quantity;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ImplemantationsPage.PageWithAllImplementation;
import PageProduts.PageWithAllProducts;
import SolutionsPage.PageWithAllSolutions;
import SuppliersPage.PageWithAllSuppliers;
import VendorsPage.PageWithAllVendors;
import roi4cio.login.HomePage;
import roi4cio.login.ROI4CIO;

public class QuantityOfCardOnThePages {
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
		productsPage = homePage.goToProductsPage();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sizeOFProductCards = productsPage.sizeOfProductsCardsOnTheProductPage();
		System.out.println(sizeOFProductCards);
		productsPage.clickOnLoadMoreButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sizeOfProductCardsAfterClickLoadMore = productsPage.sizeOfProductsCardsOnTheProductPage();
		System.out.println(sizeOfProductCardsAfterClickLoadMore);
		Assert.assertTrue(sizeOFProductCards < sizeOfProductCardsAfterClickLoadMore);
	}

	@Test
	public void verifyQuantityOfSolutions() {
		solutionsPage = homePage.goToSolutionsPage();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sizeOFSolutionsCards = solutionsPage.sizeOfSoluttionsCardsOnTheSolutionsPage();
		System.out.println(sizeOFSolutionsCards);
		productsPage.clickOnLoadMoreButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sizeOfSolutionsCardsAfterClickLoadMore = productsPage.sizeOfProductsCardsOnTheProductPage();
		System.out.println(sizeOfSolutionsCardsAfterClickLoadMore);
		Assert.assertTrue(sizeOFSolutionsCards < sizeOfSolutionsCardsAfterClickLoadMore);
	}
}
