package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println ("Exercise 1")

    println (pascal(0,2))
    println(pascal(1,2))
    println (pascal(1,3))

    println ("Exercise 2")

    var input_0  : String = "(if (zero? x) max (/ 1 x))"
    var  listChaine_0 : List[Char]   = input_0.toList
    println ("for the string :" + input_0+ " ===>"+balance(listChaine_0))

    var input  : String = "())("
    var  listChaine : List[Char]   = input.toList
    println ("for the string  :" + input+ " ===>"+balance(listChaine))

    var input_2  : String = ":-)"
    var listChaine_2 : List[Char]   = input_2.toList
    println ("for  the string:" + input_2+ "===>"+balance(listChaine_2))


    println ("Exercise 3")
    println ("Number of changes ",countChange(4, List(1,3)))


  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if ( c == 0|| r==0 || c==r) 1 else pascal (c-1,r-1) + pascal(c,r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def iterBalance (count : Int,chars: List[Char]) : Boolean  =

        if (count < 0) false
        else if (chars.isEmpty) count == 0
        else if (chars.head == '(')  iterBalance (count +1,chars.tail)
        else if (chars.head== ')')  iterBalance (count - 1,chars.tail)
        else   iterBalance (count ,chars.tail)

      iterBalance(0,chars)

    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int =   {

    if (money == 0) 1
    else if (coins.isEmpty || money  < 0) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)

    }



}
