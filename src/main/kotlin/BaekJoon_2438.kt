import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    var t:Int = nextLine().toInt()

    for(i in 1..t){
        var s:String = ""
        for(j in 1..i){
            s += "*"
        }
        println(s)
    }
}