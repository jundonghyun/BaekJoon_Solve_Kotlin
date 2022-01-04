import java.util.*
import kotlin.math.min

fun main(args:Array<String>) = with(Scanner(System.`in`)){
    val pos_x: Array<Int> = arrayOf(-1, 0, 1, 0)
    val pos_y: Array<Int> = arrayOf(0, -1, 0, 1)

    var queue: Queue<Pos> = LinkedList<Pos>()

    var n = nextInt()
    var m = nextInt()

    var maze = Array(n){ Array(m) { 0 } }
    var visited = Array(n){ Array(m) { 0 } }
    var currentPos: Pos = Pos(0,0)

    nextLine()
    for(i in 0 until n){
        var token: String = nextLine()
        for(j in 0 until m){
            maze[i][j] = (token[j]+"").toInt()
        }
    }
    queue.add(currentPos) //큐에 0,0 추가

    while(!queue.isEmpty()){ //큐가 빌때까지 반복
        var dir = 0
        currentPos = queue.remove() //큐에서 한개빼서 현재위치로 둠
        visited[currentPos.tx][currentPos.ty] = 1 //현재위치를 방문
        while(dir != 4){ //4방향을 확인할 수 있도록 하는 반복문(왼쪽, 위, 아래, 오른쪽)
            val cx = currentPos.tx + pos_x[dir]
            val cy = currentPos.ty + pos_y[dir]

            if(cx > -1 && cx < n && cy > -1 && cy < m && visited[cx][cy] != 1){ //다음칸으로 이동할때 미로를 벗어나지 않고 방문하지 않았다면
                if(maze[cx][cy] == 1){ //그 미로의 길이 벽이아니라면
                    if(maze[cx][cy] > 1){ //현재위치의 가중치가 1이아니면 길이 여러갈래로 나눠진곳이므로 최단경로인 최소 가중치를 넣어야함
                        maze[cx][cy] = min(maze[cx][cy] + maze[currentPos.tx][currentPos.ty],
                            maze[cx][cy]) //다음칸 미로의 가중치와 현재미로의 가중치를 비교해서 작은 것을 다음칸 미로에 넣음
                        queue.add(Pos(cx, cy)) //큐에 추가해줌
                    }
                    else{ //현재위치의 가중치가 1이라면 처음방문한 곳이므로 이전경로의 가중치더한값으로 변경
                        maze[cx][cy] = maze[cx][cy] + maze[currentPos.tx][currentPos.ty]
                        queue.add(Pos(cx, cy))
                    }
                }
            }
            dir++ //방향변경
        }
    }
    print(maze[n-1][m-1])
}
class Pos(x: Int, y :Int){
    val tx: Int
    val ty: Int
    init {
        tx = x
        ty = y
    }
}
//문제푸는 방법
//모든범위를 다 찾아야 하기 때문에 bfs사용(코틀린에는 큐가 없어서 LinkedList로 사용해야함)
//이전위치 가중치 + 현재위치 가중치
//더해진 가중치가 현재 가중치보다 작으면 작은 가중치로 변경

