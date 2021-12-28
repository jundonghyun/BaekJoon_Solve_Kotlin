import java.io.*
import java.util.*

fun main(args:Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    repeat(br.readLine()!!.toInt()){
        val token = StringTokenizer(br.readLine())

        val sum = (token.nextToken().toInt() + token.nextToken().toInt()).toString()

        bw.write(sum + "\n")
    }

    bw.flush()
    bw.close()
}