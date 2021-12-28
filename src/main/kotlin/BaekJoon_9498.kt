import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    var testScore = nextInt()

    when(testScore){
        in 90..100 -> {
            print("A")
        }
        in 80..89 -> {
            print("B")
        }
        in 70..79 -> {
            print("C")
        }
        in 60..69 -> {
            print("D")
        }
        in 0..59 -> {
            print("F")
        }
    }
}