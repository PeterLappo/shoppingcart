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
  
  @Test
  def scanItemsTotalWithBuyOneGetOneFreeOdd: Unit = {
    val scanner = new ItemScanner
    // 60*3
    val items = scanner.scanItems("Apple", "Apple", "Apple", "Apple", "Apple")
    val shoppingCart = new ShoppingCart
    shoppingCart.addOffer(BuyOneGetOneFree("Apple"))
    shoppingCart.addItems(items)
    assertEquals(180, shoppingCart.totalInPence)
    assertEquals("1.80", shoppingCart.totalInPounds)
  }

  @Test
  def scanItemsTotalWithBuyOneGetOneFreeEven: Unit = {
    val scanner = new ItemScanner
    // 60*2
    val items = scanner.scanItems("Apple", "Apple", "Apple", "Apple")
    val shoppingCart = new ShoppingCart
    shoppingCart.addOffer(BuyOneGetOneFree("Apple"))
    shoppingCart.addItems(items)
    assertEquals(120, shoppingCart.totalInPence)
    assertEquals("1.20", shoppingCart.totalInPounds)
  }

  @Test
  def scanItemsTotalWithThreeForPriceOfTwoAll: Unit = {
    val scanner = new ItemScanner
    // 25 * 4
    val items = scanner.scanItems("Orange", "Orange", "Orange", "Orange", "Orange", "Orange")
    val shoppingCart = new ShoppingCart
    shoppingCart.addOffer(ThreeForPriceOfTwo("Orange"))
    shoppingCart.addItems(items)
    assertEquals(100, shoppingCart.totalInPence)
    assertEquals("1.00", shoppingCart.totalInPounds)
  }

  @Test
  def scanItemsTotalWithThreeForPriceOfTwoPlusOne: Unit = {
    val scanner = new ItemScanner
    // 25 * 5
    val items = scanner.scanItems("Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange")
    val shoppingCart = new ShoppingCart
    shoppingCart.addOffer(ThreeForPriceOfTwo("Orange"))
    shoppingCart.addItems(items)
    assertEquals(125, shoppingCart.totalInPence)
    assertEquals("1.25", shoppingCart.totalInPounds)
  }

  @Test
  def scanItemsTotalWithThreeForPriceOfTwoPlusTwo: Unit = {
    val scanner = new ItemScanner
    // 25 * 6
    val items = scanner.scanItems("Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange")
    val shoppingCart = new ShoppingCart
    shoppingCart.addOffer(ThreeForPriceOfTwo("Orange"))
    shoppingCart.addItems(items)
    assertEquals(150, shoppingCart.totalInPence)
    assertEquals("1.50", shoppingCart.totalInPounds)
  }

  @Test
  def scanItemsTotalWithOffers: Unit = {
    val scanner = new ItemScanner
    // 60 * 2 + 25 * 2
    val items = scanner.scanItems("Apple", "Apple", "Apple", "Orange", "Orange", "Orange")
    val shoppingCart = new ShoppingCart
    shoppingCart.addOffer(BuyOneGetOneFree("Apple"))
    shoppingCart.addOffer(ThreeForPriceOfTwo("Orange"))
    shoppingCart.addItems(items)
    assertEquals(170, shoppingCart.totalInPence)
    assertEquals("1.70", shoppingCart.totalInPounds)
  }

}