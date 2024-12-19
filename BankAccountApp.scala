import scala.io.StdIn

// BankAccount Class
class BankAccount(private var balance: Double) {
  // Deposit method
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $$${amount}. New balance: $$${balance}")
    } else {
      println("Deposit amount must be positive!")
    }
  }

  // Withdraw method
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. New balance: $$${balance}")
    } else if (amount > balance) {
      println("Insufficient funds!")
    } else {
      println("Withdrawal amount must be positive!")
    }
  }

  // Display balance method
  def displayBalance(): Unit = {
    println(s"Current balance: $$${balance}")
  }
}

// Main Object
object BankAccountApp {
  def main(args: Array[String]): Unit = {
    println("Enter the initial balance: ")
    val initialBalance = StdIn.readDouble()
    val account = new BankAccount(initialBalance)

    var continue = true
    while (continue) {
      println("\nChoose an option:")
      println("1. Deposit")
      println("2. Withdraw")
      println("3. Check Balance")
      println("4. Exit")
      val choice = StdIn.readInt()

      choice match {
        case 1 =>
          println("Enter the amount to deposit: ")
          val amount = StdIn.readDouble()
          account.deposit(amount)
        case 2 =>
          println("Enter the amount to withdraw: ")
          val amount = StdIn.readDouble()
          account.withdraw(amount)
        case 3 =>
          account.displayBalance()
        case 4 =>
          continue = false
          println("Thank you for using the bank account system!")
        case _ =>
          println("Invalid choice. Please try again.")
      }
    }
  }
}
