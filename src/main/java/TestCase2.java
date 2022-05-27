import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;

public class TestCase2 {

    @Test
    public void testProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        List<WebElement> priceElements =
                driver.findElements(By.xpath("//ul[@id='homefeatured']//div[@class='right-block']//span[@class='price product-price']"));
        List<WebElement> nameElements =
                driver.findElements(By.xpath("//ul[@id='homefeatured']//a[@class='product-name']"));
        double maxPrice = new Double(priceElements.get(0).getText().trim().substring(1));
        int index = 0;
        for (int i =0;i<priceElements.size();i++)
        {
            String priceText = priceElements.get(i).getText().trim().substring(1);

            double value =new Double(priceText);
            if (maxPrice<value){
                maxPrice=value;
                index = i;
            }
          // NOW... I know the highest price, and I know it's name
        }
        String nameOfHighestProduct = nameElements.get(index).getText().trim();
        System.out.println(nameElements.get(index).getText()+" $"+maxPrice);


        Actions mouse = new Actions(driver);
        mouse.moveToElement(nameElements.get(index)).build().perform();

        WebElement moreButton =
                driver.findElement(By.xpath("//a[@data-id-product='4']//..//span[.='More']"));
        moreButton.click();
        Thread.sleep(3000);

        WebElement priceInProductDescriptionPage = driver.findElement(By.xpath("//span[@id='our_price_display']"));
        WebElement nameInProductDescriptionPage = driver.findElement(By.tagName("h1"));

        assertEquals(nameInProductDescriptionPage.getText().trim() , nameOfHighestProduct);

        assertEquals(new Double(priceInProductDescriptionPage.getText().trim().substring(1)) , maxPrice);


    }











}
