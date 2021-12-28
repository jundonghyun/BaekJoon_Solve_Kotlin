import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    var x:Int = nextInt()
    var y:Int = nextInt()

    if(x > 0 && y > 0){
        print(1)
    }
    else if(x > 0 && y < 0){
        print(4)
    }
    else if(x < 0 && y < 0){
        print(3)
    }
    else{
        print(2)
    }
}