import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Question2 { 

	public static void main(String[] args) throws Exception {

		WebDriver driver = new FirefoxDriver();

		// Steps:

		// 1. Navigate to https://www.weightwatchers.com/us/

		driver.navigate().to("https://www.weightwatchers.com/us/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// 2. Verify loaded page title matches “Weight Loss Program, Recipes
		// &amp; Help | Weight Watchers”

		String title = driver.getTitle();

		System.out.println(title);

		if (title
				.equalsIgnoreCase("Weight Watchers: Weight Loss Program, Recipes & Help | WW America")) {

			System.out.println("Valdiation successful");

		} else {

			System.out.println("Failed Validation");

		}

		// Assert.assertEquals(title,
		// "Weight Loss Program, Recipes &amp; Help | Weight Watchers");

		// 3. On the right corner of the page, click on “Find a Meeting”

		Thread.sleep(500);

		driver.findElement(
				By.xpath("//*[@id='ela-menu-visitor-desktop-supplementa_find-a-meeting']"))
				.click();

		// 4. Verify loaded page title contains “Get Schedules & Times Near You”

		String pageTitle = driver.getTitle().substring(16, 46);

		System.out.println(pageTitle);

		if (pageTitle.equalsIgnoreCase("Get Schedules & Times Near You")) {

			System.out.println("Valdiation successful");

		} else {

			System.out.println("Failed Validation");

		}

		// 5. In the search field, search for meetings for zip code: 10011

		Thread.sleep(500);

		driver.findElement(By.xpath("//*[@id=\'meetingSearch\']")).sendKeys(
				"10011");

		driver.findElement(
				By.xpath(".//span[@class='input-group-btn']/button[@class='btn btn-default form-blue-pill__btn']"))
				.click();

		// 6. Print the title of the first result and the distance (located on
		// the right of location title/name)

		String heading_text1 = driver.findElement(
				By.xpath(".//*[@class='location__name']/span")).getText();

		System.out.println(heading_text1);

		String heading_text2 = driver
				.findElement(
						By.xpath(".//div[@class='location__top']//div[@class='location__distance']"))
				.getText();

		System.out.println(heading_text2);

		// 7. Click on the first search result and then, verify displayed
		// location name matches with the

		// name of the first searched result that was clicked.

		driver.findElement(By.xpath(".//*[@class='location__name']/span"))
				.click();

		String searchedResult = driver.findElement(
				By.xpath(".//div[@class='location__name']/span")).getText();

		if (heading_text1.equalsIgnoreCase(searchedResult)) {

			System.out
					.println("displayed location name matches with the name of the first searched result");

		} else {

			System.out
					.println("displayed location name does not match with the name of the first searched result");

		}

		// 8. From this location page, print TODAY’s hours of operation (located
		// towards the bottom of the page)

		String currentDayOperation1 = driver
				.findElement(
						By.xpath(".//div[@class='hours-list-item-wrapper hours-list--currentday']/div/div[1]"))
				.getText();

		String currentDayOperation2 = driver
				.findElement(
						By.xpath(".//div[@class='hours-list-item-wrapper hours-list--currentday']/div/div[1]"))
				.getText();

		System.out.println("TODAY’s hours of operation:" + "\n"
				+ currentDayOperation1 + "\n" + currentDayOperation2);

		driver.close();

	}

}
