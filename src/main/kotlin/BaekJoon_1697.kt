import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)){
    var n = nextInt()
    var k = nextInt()
    var queue: Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    var visited = HashSet<Int>()
    var result = 0

    queue.add(Pair(n, 0)) //현재위치 입력 0초

    while(!queue.isEmpty()){
        var pos:Pair<Int,Int> = queue.poll()
        var times: Int = 0
        if(pos.first == k){
            result = pos.second
            break
        }

        if(pos.first + 1 in 0..100000){
            if(!visited.contains(pos.first + 1)){
                visited.add(pos.first + 1)
                times = pos.second
                queue.add(Pair(pos.first + 1, times+1))
            }
        }
        if(pos.first - 1 in 0..100000){
            if(!visited.contains(pos.first - 1)){
                visited.add(pos.first - 1)
                times = pos.second
                queue.add(Pair(pos.first - 1, times+1))
            }
        }
        if(pos.first * 2 in 0..100000){
            if(!visited.contains(pos.first * 2)){
                visited.add(pos.first * 2)
                times = pos.second
                queue.add(Pair(pos.first * 2, times+1))
            }
        }
    }
    print(result)
}