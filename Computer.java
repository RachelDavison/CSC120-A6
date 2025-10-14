public class Computer {
    
    /*
     * Attributes
     */
    String description;
    String processorType;
    int hardDriveCapacity;
    int memory;
    String operatingSystem;
    int yearMade;
    int price;

    /**
     * Computer constructor 
     * @param description description of computer
     * @param processorType type of processor
     * @param hardDriveCapacity capacity of hard drive
     * @param memory memory space
     * @param operatingSystem operating system
     * @param yearMade year made
     * @param price price 
     */
    public Computer(String description, String processorType, 
                    int hardDriveCapacity, int memory, String operatingSystem, 
                    int yearMade, int price) {
        this.description = description;
        this.processorType = processorType;
        this.hardDriveCapacity = hardDriveCapacity;
        this.memory = 16;
        this.operatingSystem = operatingSystem;
        this.yearMade = yearMade;
        this.price = 0;
    }

    /**
     * Sets price
     * @param newPrice new price 
     */
    public void setPrice(int newPrice) {
        this.price = newPrice; 
    } 

    /** 
     * Sets OS
     * @param newOS new OS
     */
    public void setOS(String newOS) {
        this.operatingSystem = "None"; 
    }

    /**
     * Get year computer was made 
     * @return year computer was made 
     */
    public int getYear() {
        return this.yearMade; 
    }

    /**
     * Get the operating system of the computer
     * @return OS
     */
    public String getOS() {
        return this.operatingSystem; 
    }

    /**
     * Get the price of the computer
     * @return price
     */
    public int getPrice() {
        return this.price; 
    }

    /**
     * Get the description of the computer
     * @return description
     */
    public String getDescription() {
        return this.description; 
    }

    /**
     * Get the processor type of the computer
     * @return processor type
     */
    public String getProcessorType(){
        return this.processorType;
    }

    /**
     * Get the hard drive capacity of the computer
     * @return hard drive capacity
     */
    public int getHardDriveCapacity(){
        return this.hardDriveCapacity;
    }

    /**
     * Get the memory of the computer
     * @return memory
     */
    public int getMemory(){
        return this.memory;
    }

    /**
     * String to print for a computer 
     */
    public String toString() {
        return this.description + "\n" + this.processorType  + "\n" + this.hardDriveCapacity  + "\n" + this.memory  + "\n" + this.operatingSystem  + "\n" + this.yearMade  + "\n" + this.price;  
    }

    public static void main(String[] args) {
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        System.out.println(myComputer);
    }

}
