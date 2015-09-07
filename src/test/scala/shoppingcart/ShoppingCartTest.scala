package shoppingcart

import org.junit.Test
import org.junit.Assert._

/**
 * @author peter
 */
class ShoppingCartTest {
  @Test
  def scanItemsTotal: Unit = {
    val scanner = new ItemScanner
    val items = scanner.scanItems("Apple", "Apple", "Apple", "Orange")
    val shoppingCart = new ShoppingCart
    shoppingCart.addItems(items)
    assertEquals(205, shoppingCart.totalInPence)
    assertEquals("2.05", shoppingCart.totalInPounds)
  }
}