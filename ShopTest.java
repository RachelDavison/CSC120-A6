import static org.junit.Assert.*;
import org.junit.Test;

/**
 *  Tests methods in the ResaleShop and Computer classes
 */
public class ShopTest {

    /**
     * Tests to see if buy() adds the correct computer to the inventory
     * @throws Exception
     */
    @Test
    public void testBuy() throws Exception{
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        assertTrue(shop.inventory.contains(computer));
    }

    /**
     * Tests to see if buy() throws an exception when expected
     * @throws Exception
     */
    @Test (expected = RuntimeException.class)
    public void testBuyException() throws Exception{
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.buy(computer);
    }

    /**
     * Tests to see if sell() removes the correct computer from the inventory
     * @throws Exception
     */
    @Test
    public void testSell() throws Exception{
        Computer computer = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.sell(computer);
        assertFalse(shop.inventory.contains(computer));
    }

    /**
     * Tests to see if sell() throws an exception when expected
     * @throws Exception
     */
    @Test (expected = RuntimeException.class)
    public void testSellException() throws Exception{
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        ResaleShop shop = new ResaleShop();
        shop.sell(computer);
    }

    /**
     * Tests to see if setPrice() sets the price correctly
     */
    @Test
    public void testSetPrice(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        computer.setPrice(100);
        assertEquals(100, computer.price);
    }

    /**
     * Tests to see if the Computer constructor sets the description correctly
     */
    @Test
    public void testComputerConstructor_Description(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals("description", computer.description);
    }

    /**
     * Tests to see if the Computer constructor sets the processorType correctly
     */
    @Test
    public void testComputerConstructor_ProcessorType(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals("processorType", computer.processorType);
    }

    /**
     * Tests to see if the Computer constructor sets the hardDriveCapacity correctly
     */
    @Test
    public void testComputerConstructor_HardDriveCapacity(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals(5, computer.hardDriveCapacity);
    }

    /**
     * Tests to see if the Computer constructor sets the memory correctly
     */
    @Test
    public void testComputerConstructor_Memory(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals(10, computer.memory);
    }

    /**
     * Tests to see if the Computer constructor sets the operatingSystem correctly
     */
    @Test
    public void testComputerConstructor_OperatingSystem(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals("operatingSystem", computer.operatingSystem);
    }

    /**
     * Tests to see if the Computer constructor sets the yearMade correctly
     */
    @Test
    public void testComputerConstructor_YearMade(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals(2000, computer.getYear());
    }

    /**
     * Tests to see if the Computer constructor sets the price correctly
     */
    @Test
    public void testComputerConstructor_Price(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals(15, computer.price);
    }

    /**
     * Tests to see if setOS() sets the OS correctly
     */
    @Test
    public void testSetOS(){
        Computer computer = new Computer("description", "processorType", 5, 10, "operatingSystem", 2000, 15);
        computer.setOS("newOS");
        assertEquals("newOS", computer.operatingSystem);
    }

    /**
     * Tests to see if toString() returns the correct string
     */
    @Test
    public void testComputerToString(){
        Computer computer = new Computer("description", "processorType", 5, 10, "operatingSystem", 2000, 15);
        assertEquals("Description: description, Processor Type: processorType, Hard Drive Capacity: 5, Memory: 10, Operating System: operatingSystem, Year Made: 2000, Price: 15", computer.toString());
    }

    /**
     * Tests to see if refurbish() sets the price correctly for a computer made before 2000
     * @throws Exception
     */
    @Test
    public void testRefurbishTooOld() throws Exception{
        Computer computer = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 1999, 1000);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.refurbish(shop.inventory.get(0), "None");
        assertEquals(0, shop.inventory.get(0).price);
    }

    /**
     * Tests to see if refurbish() sets the price correctly for a computer made between 2000 and 2011
     * @throws Exception
     */
    @Test
    public void testRefurbishOld() throws Exception {
        Computer computer =  new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2011, 1000);
        ResaleShop shop = new ResaleShop();
        shop.refurbish(shop.inventory.get(0), "None");
        assertEquals(250, shop.inventory.get(0).price);
    }

    /**
     * Tests to see if refurbish() sets the price correctly for a computer made between 2012 and 2017
     * @throws Exception
     */
    @Test
    public void testRefurbishRecent() throws Exception{
        Computer computer = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2017, 1000);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.refurbish(shop.inventory.get(0), "None");
        assertEquals(550, shop.inventory.get(0).price);
    }

    /**
     * Tests to see if refurbish() sets the price correctly for a computer made in 2018 or later
     * @throws Exception
     */
    @Test
    public void testRefurbishNew() throws Exception{
        Computer computer = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.refurbish(shop.inventory.get(0), "None");
        assertEquals(1000, shop.inventory.get(0).price);
    }

    /**
     * Tests to see if refurbish() leaves the OS unchanged when "None" is passed as newOS
     * @throws Exception
     */
    @Test
    public void testRefurbishOSNone() throws Exception{
        Computer computer = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.refurbish(shop.inventory.get(0), "None");
        assertEquals("High Sierra", shop.inventory.get(0).operatingSystem);
    }

    /**
     * Tests to see if refurbish() sets the OS correctly when a new OS is passed as newOS
     * @throws Exception
     */
    @Test
    public void testRefurbishNewOS() throws Exception{
        Computer computer = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.refurbish(shop.inventory.get(0), "NewOS");
        assertEquals("NewOS", shop.inventory.get(0).operatingSystem);
    }

    /**
     * Tests to see if refurbish() throws an exception when expected
     * @throws Exception
     */
    @Test (expected = Exception.class)
    public void testRefurbishException() throws Exception{
        Computer computer = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        ResaleShop shop = new ResaleShop();
        shop.refurbish(computer, "NewOS");
    }

    /**
     * Tests to see if the ResaleShop constructor initializes an empty inventory
     */
    @Test
    public void testResaleShopConstructor(){
        ResaleShop shop = new ResaleShop();
        assertEquals(0, shop.inventory.size());
    }
        
    public static void main(String[] args) throws Exception {
        ShopTest test = new ShopTest();
        test.testBuy();
        test.testBuyException();
        test.testSell();
        test.testSellException();
        test.testSetPrice();
        test.testComputerConstructor_Description();
        test.testComputerConstructor_ProcessorType();
        test.testComputerConstructor_HardDriveCapacity();
        test.testComputerConstructor_Memory();
        test.testComputerConstructor_OperatingSystem();
        test.testComputerConstructor_YearMade();
        test.testComputerConstructor_Price();
        test.testSetOS();
        test.testComputerToString();
        test.testRefurbishTooOld();
        test.testRefurbishOld();
        test.testRefurbishRecent();
        test.testRefurbishNew();
        test.testRefurbishOSNone();
        test.testRefurbishNewOS();


    }
    
}
