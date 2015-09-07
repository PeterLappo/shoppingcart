package shoppingcart

/**
 * @author peter
 */
class ShoppingCart {
  private var items: Seq[Item] = Seq.empty[Item]
  private var offers: Set[Offer] = Set.empty[Offer]
  
  def addItems(items: Seq[Item]): Unit = this.items = this.items ++ items
  def addOffer(offer:Offer): Unit = offers = offers + offer
  
  /**
   * Using pence avoids double rounding issues and can be easily scaled to pounds
   */
  def totalInPence: Long = applyOffers.foldLeft(0: Long)((acc, item) => acc + item.priceInPence)
  
  def totalInPounds: String = "%.2f".format(totalInPence/100.0)
  
  private def applyOffers(): Seq[Item] = {
    val bogof = items.filter(item => item.name == "Apple")
    val bogof2 = if (offers.contains(BuyOneGetOneFree("Apple"))) bogof.take(bogof.size/2 + bogof.size % 2) else bogof
    
    val threefortwo = items.filter { item => item.name == "Orange"}
    val threefortwo2 = if (offers.contains(ThreeForPriceOfTwo("Orange"))) threefortwo.take((threefortwo.size/3 * 2) + threefortwo.size % 3) else threefortwo 
    
    bogof2 ++ threefortwo2
  }
}