import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args:Array<String>){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.`out`))

    for(i in 1..br.readLine().toInt()){
        var token = StringTokenizer(br.readLine())
        bw.write("Case #$i: ${token.nextToken().toInt() + token
            .nextToken().toInt()} \n")
    }
    bw.flush()
    bw.close()
}