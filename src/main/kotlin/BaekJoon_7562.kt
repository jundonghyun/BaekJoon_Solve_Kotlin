import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args:Array<String>){

    var br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    var testCase = token.nextToken().toInt()

    var pos: Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    var start: Pair<Int, Int>
    var finish: Pair<Int, Int>

    var moveX = arrayOf(-1, -2, -2, -1, 1, 2, 2, 1) //10시,11시,1시,2시,4시,5시,7시,8시
    var moveY = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)

    for(test in 0 until testCase){
        token = StringTokenizer(br.readLine())
        var size = token.nextToken().toInt()
        var arr = Array(size){Array(size){0}}

        token = StringTokenizer(br.readLine())
        start = Pair(token.nextToken().toInt(), token.nextToken().toInt())
        arr[start.first][start.second] = 1

        token = StringTokenizer(br.readLine())
        finish = Pair(token.nextToken().toInt(), token.nextToken().toInt())
        pos.add(start)

        if(start.first == finish.first && start.second == finish.second){ //현재위치와 도착위치가 같다면 0출력하고 continue
            println(0)
            pos.clear()
            continue
        }

        while(!pos.isEmpty()){
            var currentPos = pos.poll()

            var idx = 0
            while(idx != 8){
                var nextX = currentPos.first + moveX[idx]
                var nextY = currentPos.second + moveY[idx]
                if(nextX in 0 until size && nextY in 0 until size){ //배열을 벗어나지 않는다면
                    if(arr[nextX][nextY] == 0){ //현재 배열이 0 == 한번도 방문하지 않음
                        arr[nextX][nextY] = arr[currentPos.first][currentPos.second] + 1 //현재위치의 배열값 +1 한것을 다음배열에 넣어줌
                        pos.add(Pair(nextX, nextY)) //큐에 추가
                    }
                    else{
                        idx++
                        continue
                    }
                }
                idx++
            }
        }
        pos.clear()
        println(arr[finish.first][finish.second] - 1)
    }
}
/* visited배열을 사용할 필요 없는 이유
*  시작위치에서 나이트가 움직일 수 있는 모든 배열을 탐색하면서 값을 현재위치 값 +1 해서 넣기때문에
*  시작지점부터 최단거리로 넣을 수 있음
*  이때문에 만약에 배열이 0이 아니라면 고민할 필요없이 다음 방향으로 넘어가면됨*/