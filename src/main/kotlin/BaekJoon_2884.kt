import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    var hour:Int = nextInt()
    var minute:Int = nextInt()

    minute -= 45

    if(minute < 0){
        hour--

        if(hour < 0){
            hour = 24 - 1
            minute = 60 + minute
        }
        else{
            minute = 60 + minute
        }
    }

    print("$hour $minute")
}