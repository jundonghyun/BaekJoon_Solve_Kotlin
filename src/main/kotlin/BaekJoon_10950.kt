import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    var T:Int = nextInt()
    var arr:IntArray = IntArray(T)

    for(i in 0 until T){
        var A:Int = nextInt()
        var B:Int = nextInt()
        arr[i] = A+B
    }

    for(i in 0 until arr.size){
        println(arr[i])
    }
}