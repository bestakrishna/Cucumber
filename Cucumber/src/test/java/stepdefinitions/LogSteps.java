//package stepdefinitions;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.cucumber.java.eo.Se;
//import io.cucumber.java.en.Then;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class LogSteps {
//
//    private WebDriver driver;
//
////  @Before
//    public void setUp() {
//        // Requires webdrivermanager dependency and correct import
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//
//    @After
//    public void tearDown() throws InterruptedException {
//        if (driver != null) {
//            Thread.sleep(6000);
//           //driver.quit();
//        }
//    }
//    
//    
//    
//    // this is test one handling the drop downs and 
//    
//    
//
//
//    @Given("i am on the home page")//
//    public void i_am_on_the_home_page() {
//        driver.get("https://testautomationpractice.blogspot.com/");
//    }
//
//    @When("I enter the details name:{string}, Email:{string}, Phone:{string}, Address:{string}")
//    public void i_enter_the_details_name_email_phone_address(String name, String email, String phone, String address) {
//        driver.findElement(By.id("name")).sendKeys(name);
//        driver.findElement(By.id("email")).sendKeys(email);
//        driver.findElement(By.id("phone")).sendKeys(phone);
//        driver.findElement(By.id("textarea")).sendKeys(address);
//    }
//
//    @When("I click on gender button select {string} button")
//    public void i_click_on_gender_button_select_button(String gender) {
//        if (gender.equalsIgnoreCase("female")) {
//            driver.findElement(By.id("female")).click();
//        } else if (gender.equalsIgnoreCase("male")) {
//            driver.findElement(By.id("male")).click();
//        } else {
//            WebElement elem = driver.findElement(By.xpath("//input[@name='gender' and @value='" + gender + "']"));
//            elem.click();
//        }
//    }
//
//    @When("I click the check box")
//    public void i_click_the_check_box() {
//        driver.findElement(By.id("sunday")).click();
//        driver.findElement(By.id("tuesday")).click();
//    }
//
//    @When("click the dropDown boxes")
//    public void click_the_drop_down_boxes() {
//        Select my = new Select(driver.findElement(By.id("country")));
//        my.selectByIndex(5);
//    }
//
//    @Then("details are entered into the form")
//    public void details_are_entered_into_the_form() {
//        // Add assertions if needed
//    }
//
//
//
//    // This is  test 2 handleing the windows and dynamic links clicking  and handling the table 
//
//    
//    @Given("user is on search box")
//    public void user_is_on_search_box() {
//        driver.get("https://testautomationpractice.blogspot.com/"); // use the page that contains the widget
//
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//       driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("se");
//    }
//
//    @When("I search for text then suggestiions will apper")
//    public void i_search_for_text_then_suggestiions_will_apper() {
//        driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-form\"]/div/span[2]/span[2]/input")).click();
//    }
//
//    @When("list the links and click")
//    public void list_the_links_and_click() {
//        List<WebElement> sugg = driver.findElements(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-results\"]//a"));
//        System.out.println(sugg.size());
//    for(WebElement my:sugg){
//        System.out.println(my.getText());
//        my.click();
//    }
//    }
//
//    @When("moving the window and verifying the text")
//    public void moving_the_window_and_verifying_the_text() {
//        List<String> mywin=new ArrayList<>(driver.getWindowHandles());
//        for(String win:mywin){
//            System.out.print(win);
//            //driver.switchTo().window(win.get(1));
//        }
//        String ti=driver.switchTo().window(mywin.get(0)).getTitle();
//         System.out.println(ti);
//        // implement scrolling/switching and verification
//    }
//
//
//
//    @Then("user get text")
//    public void user_get_text() throws InterruptedException {
//
//    //testing table data
//    // count the table rows
//   int ro=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
//   System.out.print("this is no of rows"+ro);
//
//   //count the number of columns
//   int col=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();// this column and we can use for headers
//   System.out.println("This is column::::"+col);
//
//
//   //now printing the particular name in the table
//   Thread.sleep(5000);
//   String res=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[3]")).getText();
//        // verify expected text
//       System.out.println("This is get text from the table::"+res);
//
//       // to print the table data from table
//       for(int r=2; r<=ro;r++){
//        
//        for(int c=1;c<=col;c++){
//           String valu=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
//           System.out.println("This is table value:::"+valu);
//        
//        
//        }
//    }
//
//         //read the data print book name whose author is mukesh
//
//        // for(int r=2;r<=ro;r++){
//        //     {
//        //         String authnum=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
//        //         System.out.println(authnum);
//        //         if(authnum.equals("Animesh")){
//        //             String booknm=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
//        //             System.out.println(authnum+":::::::::===________"+booknm);
//        //         }
//
//        //     }
//
//            int total=0;
//            for(int r=2;r<=ro;r++){
//                String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
//                total=total+Integer.parseInt(price);
//            }
//            System.out.println("total price of books"+total);
//        
//
//          driver.findElement(By.id("name")).sendKeys("Praveeen");
//         System.out.println("This the inner text"+driver.findElement(By.id("name")).getAttribute("placeholder"));
//             driver.findElement(By.id("name")).clear();
//             driver.findElement(By.id("name")).sendKeys("Krishna");
//
//        
//        }
//
//
//// this is for selecting the less price  nd fight booking 
//
//
//@Given("user is on booking webpage")
//public void user_is_on_booking_webpage() {
//    driver.get("https://blazedemo.com/");
//		driver.manage().window().maximize();
//
//
//
//}
//
//
//@When("user select departure city and destination city, click find flights")
//public void user_select_departure_city_and_destination_city_click_find_flights() {
//   driver.findElement(By.xpath("//select[@name='fromPort']")).sendKeys("Boston");
//	//3	
//		driver.findElement(By.xpath("//select[@name='toPort']")).sendKeys("London");
//	//4	
//		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
//
//}
//
//
//@When("choose less price flight and click on choose this flight")
//public void choose_less_price_flight_and_click_on_choose_this_flight() {
//
//
//    int rows=driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
//		System.out.println("number of rows in table:"+rows); //5
//	
//	//6 - capture prices then store in array
//		
//		String pricesArr[]=new String[rows];   //0-4
//		
//		for(int r=1;r<=rows;r++)
//		{
//			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
//			pricesArr[r-1]=price; //adding price into array
//		}
//		
//	//7- Sort prices then find lower price value
//		
//		for(String arrvalue:pricesArr)
//		{
//			System.out.println(arrvalue);
//		}
//		
//		Arrays.sort(pricesArr); // this will able to sort strings. so no need to convert to number
//		String lowestPrice=pricesArr[0];
//		System.out.println("Lower price:"+lowestPrice);
//		
//	//8- Find record in table having lower price
//		
//		for(int r=1;r<=rows;r++)
//		{
//			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
//			
//			if(price.equals(lowestPrice))
//			{
//				driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[1]//input")).click();
//				break;
//            }
//        }
//
//    
//}
//
//
//@When("Enter user details and click on purchace flight")
//public void enter_user_details_and_click_on_purchace_flight() {
//
//
//    driver.findElement(By.id("inputName")).sendKeys("John");
//		driver.findElement(By.id("address")).sendKeys("1403 American Beauty Ln");
//		driver.findElement(By.id("city")).sendKeys("Columbus");
//		driver.findElement(By.id("state")).sendKeys("OH");
//		driver.findElement(By.id("zipCode")).sendKeys("43240");
//		driver.findElement(By.id("creditCardNumber")).sendKeys("6789067345231267");
//		driver.findElement(By.id("creditCardYear")).clear();
//		driver.findElement(By.id("creditCardYear")).sendKeys("2023");
//		driver.findElement(By.id("nameOnCard")).sendKeys("John Canedy");
//		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
//
//    
//}
//
//
//@Then("verify the thank you message")
//public void verify_the_thank_you_message() {
//    String msg=driver.findElement(By.xpath("//h1")).getText();
//		
//		if(msg.contains("Thank you for your puchase"))
//		{
//			System.out.println("Success !! Passed");
//		}
//		else
//		{
//			System.out.println("Failed");	
//		}
//	
//		driver.quit();
//
//    
//}
//
//
//
//// Handling the date pickers and checing the dates the is the regression test 
//
//
//
//@Given("user is on the login page")
//public void user_is_on_the_login_page() {
//    driver.get("https://testautomationpractice.blogspot.com/");
//    driver.manage().window().maximize();
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//}
//
//
//
//
//@When("user try to enter date in the date file")
//public void user_try_to_enter_date_in_the_date_file() {
//   // driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).sendKeys("10/07/1999");// this is for mm/dd/yyyy
//    // in date birth field we can only select the previous dates 
//    // in the travel calenders we can only select the future date only 
//    //driver.findElement(By.xpath("//*[@id=\"txtDate\"]")).sendKeys("10/07/1999");// this for the dd/mm/yyyy
//
//   
//}
//
//
//
//
//@When("user select the date month and year and enter the date")
//public void user_select_the_date_month_and_year_and_enter_the_date() {
//    String date="10";
//    
//driver.findElement(By.xpath("//*[@id=\"txtDate\"]")).click();
//  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]/option[7]")).click();
//  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]/option[8]")).click();
//
//  List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
//  for(WebElement dt:alldates){
//    if(dt.getText().equals(date)){
//        dt.click();
//        break;
//    }
//  }
//    
//    
//
// 
//
//
//
//  
//
//
//}
//
//
//
//
//@Then("The selcted date will be apear in the date field")
//public void the_selcted_date_will_be_apear_in_the_date_field() {
//    
//}
//
//
//
//
//
//
//
// //Selecting country dropdown
// @Given("user is on mai9n page of website")
//public void user_is_on_mai9n_page_of_website() {
//    driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
//    driver.manage().window().maximize();
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//}
//@When("user click the dropdown and select the country and state")
//public void user_click_the_dropdown_and_select_the_country_and_state() {
//
//    //driver.findElement(By.xpath("//*[@id=\"country-list\"]/option[5]")).click();
//    //driver.findElement(By.xpath("//*[@id=\"state-list\"]/option[3]")).click();
//   Select akka=new Select(driver.findElement(By.xpath("//*[@id=\"country-list\"]")));
//   akka.selectByIndex(4);
//   Select akka2=new Select(driver.findElement(By.xpath("//*[@id=\"state-list\"]")));
//   akka2.selectByValue("22");
//   
//}
//@Then("the drop downs should be selected")
//public void the_drop_downs_should_be_selected() {
//    //bSystem.out.print("Test passed");
//}
//
//
//    }
//
//    