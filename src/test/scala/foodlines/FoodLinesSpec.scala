package foodlines

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers


class FoodLinesSpec extends AnyFreeSpec  with Matchers {
    "linesEnteredValues" - {
        "must return smallest line for each person entering" in {
            FoodLines.linesEnteredValues(3, List(2,2,3,3,3)) mustBe List(2,2,3)
        }
    }

}
