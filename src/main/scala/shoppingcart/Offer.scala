package shoppingcart

/**
 * @author peter
 */

trait Offer {
  def name:String
}

case class BuyOneGetOneFree(name:String) extends Offer

case class ThreeForPriceOfTwo(name:String) extends Offer

object Offers {
  def todaysOffers: Set[Offer] = Set(BuyOneGetOneFree("Apple"), ThreeForPriceOfTwo("Orange"))
}