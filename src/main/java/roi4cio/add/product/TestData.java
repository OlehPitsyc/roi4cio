package roi4cio.add.product;

import java.util.Arrays;
import java.util.List;

public class TestData {

	private static List<String> deliveyType = Arrays.asList("Оборудование", "Услуга");
	private static List<String> emptyDeliveyType = Arrays.asList();

	private static List<String> category = Arrays.asList("ИТ - аутсорсинг", "Web фильтрация");
	private static List<String> emptyCategory = Arrays.asList();

	
	
	public static final ProductModel FilledAllMandatoryFields = new ProductModel("Test11", deliveyType, category);

	public static final ProductModel ProductWithNewTitle = new ProductModel("Test1",deliveyType ,category);

	public static final ProductModel TitleIsEmpty = new ProductModel(" ", deliveyType ,category);

	public static final ProductModel DeliveryTypeIsEmpty = new ProductModel("Test21", emptyDeliveyType, category);

	public static final ProductModel CategoryIsEmpty = new ProductModel("Test21", deliveyType, emptyCategory);

	public static final ProductModel CategoryAndDeliveryAreEmpty = new ProductModel("Test2", emptyDeliveyType,emptyCategory);

	public static final ProductModel EmptyMandatoryFields = new ProductModel(" ", emptyDeliveyType,emptyCategory);

}
