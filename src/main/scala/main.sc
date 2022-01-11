
def evenOrOdd(n: Int) =
  if (n % 2 == 0) println("even")
  else println("odd")

evenOrOdd(1)

evenOrOdd(1341342)

def count() = {
  var i = 1
  while (i <= 10) {
    println(i)
    i += 1
  }
}

count()

def detDiscount(price: Int): Double = 
  if (price < 50) price
  else if (price < 100) price * 0.9
  else price * 0.85

println(detDiscount(10))

println(detDiscount(60))

println(detDiscount(110))


def pow(exponent: Int, base: Int = 2): Int = {
  if (exponent == 0) 1 
  else base * pow(exponent - 1, base)
}

pow(3)

pow(3, 3)

abstract class Person(name: String, age: Int = 0) {
  def presentYourself(): String = s"Hi, I'm $name and I'm $age years old"
  
  def hello(name: String): String
}

class Teacher(val name: String, age: Int = 0) extends Person(name, age) {
  override def hello(name: String): String = s"Hi, I'm $name. Nice to meet you."
}

class Student(val name: String, studentId: String, age: Int = 0) extends Person(name, age) {
  override def presentYourself(): String = s"Hi, I'm $name and I'm $age years old. My student id number is $studentId"
  override def hello(name: String): String = s"Hi, I'm $name. Nice to meet you."
}

/*
val Martin = new Person("Martin", 18)
val Bob = new Person("Bob")
*/
val Nick = new Student("Nick", "5526719821", 21)
val Emma = new Teacher("Emma", 21)

/*
println(Martin.presentYourself())
println(Bob.presentYourself())
*/
println(Emma.presentYourself())
println(Nick.presentYourself())
println(Emma.hello(Emma.name))

abstract class Beverage(name: String) {
  def serve(): String
}

class hotBeverage(name: String) extends Beverage(name) {
  override def serve() = "Served"
  
  def reheat(): String = "Reheated"
}

class coldBeverage(name: String) extends Beverage(name) {
  override def serve() = "Served"
  
  def addIce(): String = "Added more ice cubes"
}

class VendingMachine {
  var chocolateBar = 0
  var granolaBar = 0
  
  var totalMoney = 0.0
  
  def buy(product: String, money: Double): String = {
    if (!isProductAvailable(product)) s"Sorry, product $product is not available now."
    else if (!isMoneyEnough(product, money)) s"Please insert more money"
    else completeRequest(product, money)
  }
  
  def isProductAvailable(product: String): Boolean = {
    val productQuantity = {
      if (product == "chocolate") chocolateBar
      else if (product == "granola") granolaBar
      else 0
    }
    productQuantity > 0
  }
  
  def isMoneyEnough(product: String, money: Double): Boolean = {
    val cost = if (product == "chocolate") 1.5 else 1
    money >= cost
  }
  
  def completeRequest(product: String, money: Double): String = {
    collectMoney(money)
    releaseProduct(product)
    s"There you go! Have a $product bar!"
  }
  
  def collectMoney(money: Double) = totalMoney += money
  
  def releaseProduct(product: String) = if (product == "chocolate") chocolateBar -= 1 else if (product == "granola") granolaBar -= 1
}

val machine = new VendingMachine

machine.buy("chocolate", 1.5)

machine.chocolateBar += 2
machine.granolaBar += 2

machine.buy("chocolate", 1.5)

machine.buy("chocolate", 1.25)

machine.buy("chocolate", 1.6)

machine.buy("chocolate", 1.6)

machine.totalMoney