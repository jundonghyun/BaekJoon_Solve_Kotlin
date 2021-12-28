import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var A = nextInt();
    var B = nextInt();

    if(A > B){
        print(">")
    }
    else if(A < B){
        print("<")
    }
    else{
        print("==")
    }
}