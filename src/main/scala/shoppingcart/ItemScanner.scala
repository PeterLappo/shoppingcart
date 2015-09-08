package shoppingcart

/**
 * @author peter
 */
class ItemScanner {
  def scanItem(itemName: String): Option[Item] = itemName match {
    case "Orange" => Some(Item("Orange", 25))
    case "Apple" => Some(Item("Apple", 60))
    case "Banana" => Some(Item("Banana", 50))
    case _ => None
  }
  
  def scanItems(itemNames: String*): Seq[Item] = {
    for {
      name <- itemNames
      item <- scanItem(name)
    } yield (item)
  }
}