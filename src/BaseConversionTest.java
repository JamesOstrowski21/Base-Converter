
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for BaseConversion.Java and BaseConversionDriver.java
 */
class BaseConversionTest {

    /**
     * Tests valid constructors
     */
    //Test constructor
    @Test
    void validConstructors(){
        BaseConversion B0 = new BaseConversion("3E8",16,10);
        BaseConversion B1 = new BaseConversion("1000",10,16);
        BaseConversion B2 = new BaseConversion("10",6,2);

    }

    /**
     * Tests the convert method
     */
    //Test Convert Method
    @Test
    void ConvertTest(){
        BaseConversion.Convert("1000",10,16);
        assertEquals("3E8",BaseConversion.Convert("1000",10,16));

    }

    /**
     * Tests the print method of BaseConversion
     * @throws Exception
     */
    //Test print method
    @Test
    public void PrintTest()throws Exception{
        BaseConversion T = new BaseConversion("1000",10,16);
        T.print();
    }

    /**
     * Tests the validate base method of BaseConversionDriver
     */
    //Test validate method for base
    @Test
    void ValidBaseTest(){
        BaseConversionDriver.CheckBase(2);
        assertEquals(true,BaseConversionDriver.CheckBase(2));
    }

    /**
     * Tests for non valid bases
     */
    //Test invalid base
    @Test
    void notValidBase(){
        BaseConversionDriver.CheckBase(1);
        assertEquals(false,BaseConversionDriver.CheckBase(1));
    }

    /**
     * Test for validate num method in BaseConversionDriver
     */
    //Test Validate num method
    @Test
    void ValidNuminBase(){
        BaseConversionDriver.CheckNum("1010",2);
        assertEquals(true,BaseConversionDriver.CheckNum("1010",2));
    }

    /**
     * Tests for invalid nums within a base.
     */
    //Test invalid num
    @Test
    void NotValidNuminBase(){
        BaseConversionDriver.CheckNum("EEE",4);
        assertEquals(false,BaseConversionDriver.CheckNum("EEE",4));
    }

}