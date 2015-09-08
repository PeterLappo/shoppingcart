package shoppingcart

/**
 * @author peter
 */
class ShoppingCart(val offers: Set[Offer] = Set.empty[Offer]) {
  private var items: Seq[Item] = Seq.empty[Item]
  
  def addItems(items: Seq[Item]): Unit = this.items = this.items ++ items

  /**
   * Using pence avoids double rounding issues and can be easily scaled to pounds
   */
  def totalInPence: Long = applyOffers2.foldLeft(0: Long)((acc, item) => acc + item.priceInPence)
  
  def totalInPounds: String = "%.2f".format(totalInPence/100.0)
  
  private def applyOffers(): Seq[Item] = {
    val bogof = items.filter(item => item.name == "Apple")
    val bogof2 = if (offers.contains(BuyOneGetOneFree("Apple"))) bogof.take(bogof.size/2 + bogof.size % 2) else bogof
    
    val threefortwo = items.filter { item => item.name == "Orange"}
    val threefortwo2 = if (offers.contains(ThreeForPriceOfTwo("Orange"))) threefortwo.take((threefortwo.size/3 * 2) + threefortwo.size % 3) else threefortwo 
    
    bogof2 ++ threefortwo2
  }
  
  private def applyOffers2(): Seq[Item] = {
    def applyOffers(name: String, items: Seq[Item]) : Seq[Item] = {
      val itemsForName = items.filter(_.name == name)
      val offersForItem = offers.filter(_.name == name)
      val res = offersForItem.map{ offer =>
        offer match {
          case itm:BuyOneGetOneFree => itemsForName.take(itemsForName.size/2 + itemsForName.size % 2)
          case itm:ThreeForPriceOfTwo => itemsForName.take((itemsForName.size/3 * 2) + itemsForName.size % 3)
        }
      }
      // returned the items for the applied offers or the items without offers applied
      // assumes only one offer per item type
      if (res.size > 0) res.head else itemsForName
    }
    
    val uniqueItems = items.foldLeft(Set[String]())((acc, item) => acc + item.name).toSeq
    val itemsWithAppliedOffers = for {
      itemName <- uniqueItems
      item <- applyOffers(itemName, items)
    } yield (item)
     
    itemsWithAppliedOffers
  }
}