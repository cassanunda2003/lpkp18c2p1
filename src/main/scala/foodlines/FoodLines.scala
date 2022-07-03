package foodlines

object FoodLines {
  
    def linesEnteredValues(numberOfPeopleEntering: Int, foodLineLengths: List[Int]): List[Int] = {
        def innerLoop(personEntering: Int, currentList: List[Int], accumulatedList: List[Int]): List[Int] = {
            if (personEntering <= 0)
                accumulatedList
            else {
                val lowestValue = currentList.min
                innerLoop(personEntering - 1, updateList(currentList, lowestValue), lowestValue :: accumulatedList)
            }
        }
        def updateList(list: List[Int], lowestValue: Int): List[Int] = {
            val index = list.indexOf(lowestValue)
            val array = list.toArray
            array(index) = lowestValue + 1
            array.toList
        }
        innerLoop(numberOfPeopleEntering, foodLineLengths, Nil).reverse
    }
}

object FoodLineRunner extends App {
    println("Enter the number of lines and the number of people entering")
    import scala.io.StdIn.readf2
    val(lines, people) = readf2("{0, number} {1,number}")
    import scala.io.StdIn.readLine
    val lineLengths = readLine("Enter line lengths")
    val lengths = FoodLines.linesEnteredValues(people.toString().toInt ,lineLengths.split(" ").map(_.toInt).toList)
    lengths.foreach(println(_))
}