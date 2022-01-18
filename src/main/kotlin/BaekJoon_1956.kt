import java.util.*
import kotlin.math.min

fun main(args:Array<String>){

    var v = 0
    var e = 0

    readLine()!!.split(" ").let {
        v = it[0].toInt()
        e = it[1].toInt()
    }

    var arr = Array(v){Array(v){100000}}

    for(i in 0 until e){
        readLine()!!.split(" ").let {
            arr[it[0].toInt()-1][it[1].toInt()-1] = it[2].toInt()

        }
    }

    for(k in 0 until v){
        for(i in 0 until v){
            for(j in 0 until v){
                arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])
            }
        }
    } //플로이드 알고리즘 사용

    var start = Int.MAX_VALUE

    for(i in 0 until v){
        for(j in 0 until v){
            if(i == j){
                if(arr[i][j] != 100000){
                    start = min(start, arr[i][j])
                }
            }
        }
    }
    if(start == Int.MAX_VALUE){
        println(-1)
    }
    else{
        println(start)
    }
}
