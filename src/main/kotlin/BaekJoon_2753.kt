import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    var year:Int = nextInt()

    if(year % 4 == 0)
    {
        if(year % 100 != 0 || year % 400 == 0){
            print(1)

            return
        }
    }
    print(0)

}