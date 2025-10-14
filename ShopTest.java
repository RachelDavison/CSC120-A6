import static org.junit.Assert.*;
import org.junit.Test;

public class ShopTest {

    @Test
    public void testBuy(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        assertTrue(shop.getInventory().contains(computer));
    }

    @Test (expected = Exception.class)
    public void testBuyException(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.buy(computer);
    }

    @Test
    public void testSell(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.sell(computer);
        assertFalse(shop.getInventory().contains(computer));
    }

    @Test (expected = Exception.class)
    public void testSellException(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        ResaleShop shop = new ResaleShop();
        shop.sell(computer);
    }

    @Test
    public void testSetPrice(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        computer.setPrice(100);
        assertEquals(100, computer.getPrice());
    }

    @Test
    public void testComputerConstructor_Description(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals("description", computer.getDescription());
    }

    @Test
    public void testComputerConstructor_ProcessorType(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals("processorType", computer.getProcessorType());
    }

    @Test
    public void testComputerConstructor_HardDriveCapacity(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals(5, computer.getHardDriveCapacity());
    }

    @Test
    public void testComputerConstructor_Memory(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals(10, computer.getMemory());
    }

    @Test
    public void testComputerConstructor_OperatingSystem(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals("operatingSystem", computer.getOS());
    }

    @Test
    public void testComputerConstructor_YearMade(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals(2000, computer.getYear());
    }

    @Test
    public void testComputerConstructor_Price(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        assertEquals(15, computer.getPrice());
    }

    @Test
    public void testSetOS(){
        Computer computer = new Computer("description", "processorType", 5, 10, "operatingSystem", 2000, 15);
        computer.setOS("newOS");
        assertEquals("newOS", computer.getOS());
    }

    @Test
    public void testComputerToString(){
        Computer computer = new Computer("description", "processorType", 5, 10, "operatingSystem", 2000, 15);
        assertEquals("Description: description, Processor Type: processorType, Hard Drive Capacity: 5, Memory: 10, Operating System: operatingSystem, Year Made: 2000, Price: 15", computer.toString());
    }

    @Test
    public void testRefurbishTooOld(){
        Computer computer = new Computer("description", "processorType", 5, 10, "operatingSystem", 1990, 15);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.refurbish(computer, "None");
        assertEquals(0, computer.getPrice());
    }

    @Test
    public void testRefurbishOld(){
        Computer computer =  new Computer("description", "processorType", 5, 10, "operatingSystem", 2010, 15);
        ResaleShop shop = new ResaleShop();
        shop.refurbish(computer, "None");
        assertEquals(250, computer.getPrice());
    }

    @Test
    public void testRefurbishRecent(){
        Computer computer = new Computer("description", "processorType", 5, 10, "operatingSystem", 2015, 15);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.refurbish(computer, "None");
        assertEquals(550, computer.getPrice());
    }

    @Test
    public void testRefurbishNew(){
        Computer computer = new Computer("description", "processorType", 5, 10, "operatingSystem", 2025, 15);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.refurbish(computer, "None");
        assertEquals(1000, computer.getPrice());
    }

    @Test
    public void testRefurbishOSNone(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.refurbish(computer, "None");
        assertEquals("operatingSystem", computer.getOS());
    }

    @Test
    public void testRefurbishNewOS(){
        Computer computer = new Computer("description", "processorType",5, 10, "operatingSystem",2000, 15);
        ResaleShop shop = new ResaleShop();
        shop.buy(computer);
        shop.refurbish(computer, "NewOS");
        assertEquals("NewOS", computer.getOS());
    }
        
    
}
