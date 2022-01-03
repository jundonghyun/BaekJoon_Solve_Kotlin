import java.util.*

val pos_x = arrayOf(-1, 0, 1, 0) //왼쪽, 위, 오른쪽, 아래
val pos_y = arrayOf(0, -1, 0, 1) //왼쪽, 위, 오른쪽, 아래
lateinit var visited: Array<Array<Int>> //방문배열 생성

fun main(args:Array<String>) = with(Scanner(System.`in`)){

    var t: Int = nextInt() //testcase 개수

    repeat(t){
        var m: Int = nextInt() //가로길이
        var n: Int = nextInt() //세로길이
        var k: Int = nextInt() //배추위치 개수
        var arr = Array(m) { Array(n) { 0 } }  //배추밭 생성
        visited = Array(m) { Array(n) { 0 } }  //방문배열 생성

        for(i in 0 until k){ //배추위치 밭에 입력
            arr[nextInt()][nextInt()] = 1 //배추 심기
        }

        var count = 0

        for(i in arr.indices){ //배추밭 탐색
            for(j in arr[i].indices){
                if(arr[i][j] == 1 && visited[i][j] != 1){ //배추가 심어져있고 방문한곳이 아니면 dfs탐색함
                    visited[i][j] = 1 //방문한곳으로 변경
                    dfs(arr, i, j)
                    count++ //근처에있는 배추를 모두 탐색했으면 count+1
                }
            }
        }
        println(count)
    }
}

private fun dfs(arr: Array<Array<Int>>, i: Int, j: Int){
    visited[i][j] = 1
    var move = 0

    while(move != 4){ //4방향을 모두 탐색
        var x = i + pos_x[move] //탐색순서는 왼쪽, 위, 오른쪽, 아래 순서로 탐색
        var y = j + pos_y[move]

        if(x > -1 && x < arr.size && y > -1 && y < arr[i].size && visited[x][y] != 1){ //배열을 벗어나지 않고 방문한곳이 아니라면
            visited[x][y] = 1 //방문한것으로 표시
            if(arr[x][y] == 1){ //배추가 심어져있다면 다시 그 위치부터 dfs탐색 시작
                dfs(arr, x, y)
            }
        }
        move++ //배열을 벗어나거나 방문한곳이라면 다음 방향으로 이동하기위해 move++
    }
}