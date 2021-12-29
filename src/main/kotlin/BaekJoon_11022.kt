import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args:Array<String>){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    for(i in 1..br.readLine().toInt()){
        var token = StringTokenizer(br.readLine())
        var a:Int = token.nextToken().toInt()
        var b:Int = token.nextToken().toInt()

        bw.write("Case #${i}: $a + $b = " +
                "${a+b}\n")
    }

    bw.flush()
    bw.close()
}