import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    var t:Int = nextLine().toInt()

    for(i in 1..t){
        for(j in t downTo 1){
            print(
                if(i >= j){
                    "*"
                }
                else{
                    " "
                }
            )
        }
        println()
    }
}