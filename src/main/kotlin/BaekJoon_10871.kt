import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args:Array<String>){
    var br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())

    var n = token.nextToken().toInt()
    var x = token.nextToken().toInt()

    token = StringTokenizer(br.readLine())

    var result:String = ""

    while (token.hasMoreTokens()){
        var temp = token.nextToken()
        if(x > temp.toInt()){
            result += "$temp "
        }
    }
    print(result)

}