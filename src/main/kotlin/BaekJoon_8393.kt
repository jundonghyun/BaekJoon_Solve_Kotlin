import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    var n:Int = nextInt()
    var result = 0

    for(i in 1..n){
        result += i
    }

    print(result)
}