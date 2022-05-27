import org.testng.annotations.Test;

public class RunnerForTest1AndTest2 {

  // NOTE *** IF you have multiple test cases, and you would like to run them all in the same time...
    //         you can create a @Test method inside where you will call all your test cases methods using object of testCase classes

    @Test

    public void testAll () throws InterruptedException {

        TestCase1 testMain = new TestCase1();
        TestCase2 testProducts = new TestCase2();

        testMain.indexTest();
        testProducts.testProduct();
    }
}
