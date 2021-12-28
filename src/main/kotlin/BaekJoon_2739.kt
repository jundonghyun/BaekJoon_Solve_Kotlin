import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    var N:Int = nextInt()

    for(i in 1 until 10){
        println("$N * $i = ${N*i}")
    }
}