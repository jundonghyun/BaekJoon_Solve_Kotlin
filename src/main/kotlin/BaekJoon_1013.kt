fun main(args:Array<String>){
    var t = 0

    t = readLine()!!.toInt()

    var arr1013 =  Array<String>(t){""}
    var regex = "(100+1+|01)+".toRegex()

    for(i in 0 until t){
        var temp = readLine()

        var result = temp?.let { regex.matches(it) }

        if(result == true){
            println("YES")
        }else{
            println("NO")
        }
    }
}