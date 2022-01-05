import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args:Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    var posX = arrayOf(0, -1, 0, 1) //왼쪽, 위, 오른쪽, 아래
    var posY = arrayOf(-1, 0, 1, 0)
    var queue: Queue<pos> = LinkedList<pos>()

    var n: Int
    var m: Int
    var max: Int = 0

    var token = StringTokenizer(readLine())
    n = token.nextToken().toInt()
    m = token.nextToken().toInt()

    var arr = Array(m){ Array(n) { 0 }}
    var currentPos = pos(0, 0) //현재위치 생성

    for(i in arr.indices){ //토마토 입력
        token = StringTokenizer((readLine()))
        for(j in arr[i].indices){
            arr[i][j] = token.nextToken().toInt()
            if(arr[i][j] == 1){
                currentPos = pos(i, j) //현재위치를 토마토있는곳을 정함
                queue.add(currentPos) //큐에 토마토있는곳 좌표를 넣음
            }
        }
    }

    while(!queue.isEmpty()){
        currentPos = queue.remove()
        max = arr[currentPos.x][currentPos.y] //max값을 현재좌표의 배열값으로 넣음
        var idx: Int = 0

        while(idx != 4){
            var x: Int = currentPos.x + posX[idx]
            var y: Int = currentPos.y + posY[idx]

            if(x > -1 && x < arr.size && y > -1 && y < arr[0].size){ //배열의 크기를 벗어나지 않고
                if(arr[x][y] == 0){ //토마토가 심어져있다면
                    if(max < arr[x][y]){ //max보다 현재 이동할 배열값이 더 크면 갱신해줌
                        max = arr[x][y]
                    }
                    arr[x][y] = arr[currentPos.x][currentPos.y] + 1 //날짜가 지나는것처럼 이동할 위치에 현재좌표의 값 +1 한값을 넣어줌
                    queue.add(pos(x,y)) //큐에 이동할 좌표값 넣음
                }
            }
            idx++
        }
    }

    for(i in arr.indices){
        for(j in arr[i].indices){
            if(arr[i][j] == 0) {
                print(-1)
                return
            }
        }
    }
    if(max == 1){
        print(0)
    }
    else{
        print(max - 1)
    }
}
class pos(var x: Int, var y: Int){
}
/*문제설명 : 밭에서 토마토가 1인곳에 심어져있고 이 토마토는 상하좌우 4방향으로
* 바로옆에 인접한 토마토를 익게 할 수 있음, 밭에 있는 모든 토마토가 익는데 걸리는 시간을 구하는것
* 1. 배열을 입력받을때 값이 1인 좌표값을 큐에 집어넣음
* 2. 큐가 빌때까지 큐에서 빼서 현재좌표에 넣고 상하좌우의 값을 변경함
* 3. 변경할때는 현재좌표의 위치와 토마토가 심어져있는 위치인 0값을 만나면 현재좌표의 값 +1 한것을 0인 값에 넣음
* 4. 값을 변경할때 max값을 갱신시켜줌 = 이 값이 출력값이 됨
* 5. 큐가 비어서 빠져나오면 배열을 한번더 검사해서 0값이 있는지 확인
* 6. 0값이 있다면 더이상 그 토마토는 -1안에 있는것 이므로 익게할 수 없기때문에 -1 출력
* 7. 0값은 없지만 max값이 1이라면 배열에 토마토가 한개이므로 0 출력
* 8. 나머지경우엔 max값 출력*/