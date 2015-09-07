package shoppingcart

/**
 * @author peter
 */
class ShoppingCart {
  private var items: Seq[Item] = Seq.empty[Item]
  
  def addItems(items: Seq[Item]): Unit = this.items = this.items ++ items
  
  /**
   * Using pence avoids double rounding issues and can be easily scaled to pounds
   */
  def totalInPence: Long = items.foldLeft(0: Long)((acc, item) => acc + item.priceInPence)
  
  def totalInPounds: String = "%.2f".format(totalInPence/100.0)
}