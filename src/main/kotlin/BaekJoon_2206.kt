import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    var n = nextInt()
    var m = nextInt()
    var arr = Array(n){Array(m){0}}

    var posX = arrayOf(0, -1, 0, 1) //왼쪽,위,오른쪽,아래
    var posY = arrayOf(-1, 0, 1, 0)
    var queue: Queue<Pos2206> = LinkedList<Pos2206>()
    var visited = Array(n){Array(m){Array(2){0}}}
    var finish: Boolean = false

    nextLine()

    for(i in 0 until n){
        var input: String = nextLine()
        for(j in 0 until m){
            arr[i][j] = (input[j]+"").toInt()
        }
    }
    arr[0][0] = 1
    queue.add(Pos2206(0,0, 0, 1))

    while(!queue.isEmpty()){
        var currentPos = queue.poll()
        visited[currentPos.x][currentPos.y][currentPos.block] = 1
        var idx = 0

        while(idx != 4){
            var move_x = currentPos.x + posX[idx]
            var move_y = currentPos.y + posY[idx]
            var check = currentPos.block
            var cnt = currentPos.count

            if(currentPos.x == n-1 && currentPos.y == m-1){
                print(cnt)
                return
            }

            if(move_x in 0 until n
                && move_y in 0 until m){ //움직일 위치가 배열을 벗어나지 않을 경우
                if(arr[move_x][move_y] == 1 && check == 0 && visited[move_x][move_y][check] != 1){ // 1. 벽에 막혔지만 벽을 뚫을 수 있는경우
                    cnt++
                    check++
                    queue.add(Pos2206(move_x, move_y, check, cnt))
                    visited[move_x][move_y][check] = 1
                }
                else if(arr[move_x][move_y] == 0 && visited[move_x][move_y][check] != 1){
                    cnt++
                    queue.add(Pos2206(move_x, move_y, check, cnt))
                    visited[move_x][move_y][check] = 1
                }
            }
            idx++
        }
    }
    if(!finish){
        print(-1)
    }
}

class Pos2206(var x:Int, var y:Int, var block:Int, var count: Int){
}
/*문제푸는 방법
1. 첫번째 큐에는 x,y = 0, block,count = 0인 값을 넣음
2. 그다음 큐에서 뺀다음 갈수있는 4방향을 탐색
3. 이때 4방향중 0인곳은 길이있는곳이므로 그에 해당하는 위치의 x,y값과 벽을 뚫지 않았으므로 block = 0, count = +1 한값을 다시 큐에 넣음
4. 만약 1인곳은 벽이있으므로 block이 1이 아니라면 아직 한번 기회가 있는것이므로 block을 1로 바꾸고 벽을 뚫은 위치의 x,y값과 count + 1한값을 다시 큐에 넣음
5. 핵심은 큐에 넣을때 x,y값은 바뀌지만 count값을 계속 유지해서 가는 것과 visit배열에서 벽을뚫었을때와 아닐때 방문을 각각 저장해줘야함*/

/*문제발생함
* visit배열을 뚫은것과 안뚫은것 모두 한곳을 접근하니
* 안뚫은노드가 뚫은노드가 접근해버려서 접근을 안함
* visit배열을[][][] 3차원으로해서 뚫은것과 안뚫은것 각각 넣어야할거같음*/