//import org.junit.Assert;
//import org.junit.Test;
//
//public class MainClassTest extends MainClass
//{
//    MainClass Main = new MainClass ();
//
//    @Test
//    public void testGetLocalNumber()
//    {
//        int a = 14;
//        int b = Main.getLocalNumber();
//
//          if (a == b) {
//        System.out.println("The numerical value is 14.");
//          } else {
//              System.out.println("Numeric value is not 14");
//          }
//    }
//
//    @Test
//    public void testGetClassNumber()
//    {
//        int a = Main.getClassNumber();
//        int b = 45;
//
//        if (a > b) {
//            System.out.println("The getClassNumber method returns a value greater than 45.");
//        } else {
//            System.out.println("The getClassNumber method returns a value less than 45.");
//        }
//    }
//
//    @Test
//    public void testGetClassString()
//    {
//        String a = this.getClassString();
//        if (a.contains("Hello") || a.contains("hello"))
//        {
//            System.out.println("There is a substring \"hello\" or \"Hello\" in the getClassString method");
//        } else {
//            Assert.fail("There is not a substring \"hello\" or \"Hello\" in the getClassString method");
//        }
//    }
//}