import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args:Array<String>){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.`out`))

    for(i in 1..br.readLine()!!.toInt()){
        bw.write("$i\n")
    }

    bw.flush()
    bw.close()
}