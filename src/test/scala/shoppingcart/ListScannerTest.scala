package shoppingcart

import org.junit.Test
import org.junit.Assert._

/**
 * @author peter
 */
class ListScannerTest  {
  
  @Test
  def scanItem: Unit = {
    val scanner = new ItemScanner
    val item1 = scanner.scanItem("Orange")
    assertEquals(item1, Some(Item("Orange", 25)))
    val item2 = scanner.scanItem("Apple")
    assertEquals(item2, Some(Item("Apple", 60)))
    val item3 = scanner.scanItem("Pear")
    assertEquals(item3, None)
  }
  
    @Test
  def scanItems: Unit = {
    val scanner = new ItemScanner
    val item1 = scanner.scanItems("Orange", "Apple", "Apple", "Orange")
    assertEquals(item1, Seq(Item("Orange", 25), Item("Apple", 60), Item("Apple", 60), (Item("Orange", 25))))
  }

}