import java.util.Scanner

/**
 * Aquesta funció s'utilitza per a llegir un nombre enter
 * @author gallardo4
 * @since 19/12/23
 */
fun llegirInt(missatge:String,intMin:Int,intMax:Int):Int{
    val scan=Scanner(System.`in`)
    var valorInt=0
    var valorCorrecte:Boolean
    do {
        print("$missatge ")
        valorCorrecte=scan.hasNextInt()
        if (!valorCorrecte){
            println(RED_BACKGROUND_BRIGHT+"ERROR: introdueix un nombre enter"+RESET)
        }else{
            valorInt=scan.nextInt()
            if (valorInt<intMin || valorInt>intMax){
                valorCorrecte=false
                println(RED_BACKGROUND_BRIGHT+"ERROR: introdueix un nombre entre els valors requerits"+RESET)
            }
        }
        scan.nextLine()
    }while (!valorCorrecte)
    return valorInt
}

/**
 * Aquesta funció s'utilitza per a llegir un valor booleà
 * @author gallardo4
 * @since 10/01/23
 */
fun llegirBoolean(missatge:String):Boolean{
    val scan=Scanner(System.`in`)
    var valorBoolean=false
    var valorCorrecte=false
    do {
        print("$missatge ")
        valorCorrecte=scan.hasNextBoolean()
        if (!valorCorrecte){
            println(RED_BACKGROUND_BRIGHT+"ERROR: introdueix un valor correcte"+RESET)
        } else {
            valorBoolean=scan.nextBoolean()
        }
        scan.nextLine()
    }while (!valorCorrecte)
    return valorBoolean
}