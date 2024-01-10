fun main(){
    menu()
    val litres = litresConsumits()
    var quotaFixaAPagar = quotaFixa()
    var quotaVariableAPagar = quotaVariable(litres)
    val esFNOM = familiaNombrosaOMonomarental()
    var descompteFNOM=0.0
    if (esFNOM) {
        val membres = membresFamilia()
        descompteFNOM = descompteFamiliaNombrosaOMonomarental(esFNOM, membres)
    }
    val teBo = boSocial()
    var descompteBo=0.0
    if (teBo){
        descompteBo = descompteBoSocial(teBo)
        quotaFixaAPagar-=3
    }
    if (descompteBo>descompteFNOM){
        quotaVariableAPagar -= quotaVariableAPagar * descompteBo
    } else {
        quotaVariableAPagar -= quotaVariableAPagar * descompteFNOM
    }
    val quotaVariableAPagarAmbElsLitres = quotaVariableAPagar*litres
    val totalAPagar = quotaFixaAPagar+quotaVariableAPagarAmbElsLitres
    println()
    println(CYAN+"El consum de litres d'aigua total és de: "+CYAN_BOLD_BRIGHT+"${litres}L"+RESET)
    println(CYAN+"El cost de la quota fixa és de: "+CYAN_BOLD_BRIGHT+"$quotaFixaAPagar€"+RESET)
    println(CYAN+"El cost de la quota variable és de: "+CYAN_BOLD_BRIGHT+"$quotaVariableAPagarAmbElsLitres€"+RESET)
    println(CYAN+"El total a pagar és: "+CYAN_BOLD_BRIGHT+"$totalAPagar€"+RESET)
    println()
    if (descompteBo>descompteFNOM) {
        if (descompteBo==0.0){
            println(BLUE_BOLD_BRIGHT+"No t'has beneficiat de cap descompte"+RESET)
        } else if (quotaVariableAPagar!=0.0){
            println(BLUE_BOLD_BRIGHT+"T'has beneficiat d'un descompte del ${descompteBo*100}% en la quota variable i d'un descompte del 50.0% en la fixa"+RESET)
        } else {
            println(BLUE_BOLD_BRIGHT+"T'has beneficiat d'un descompte del 50.0% en la quota fixa"+RESET)
        }
    } else {
        if (descompteFNOM==0.0){
            println(BLUE_BOLD_BRIGHT+"No t'has beneficiat de cap descompte"+RESET)
        } else {
            println(BLUE_BOLD_BRIGHT+"T'has beneficiat d'un descompte del ${descompteFNOM*100}% en la quota variable"+RESET)
        }
    }
}

/**
 * Aquesta funció serveix per preguntar a l'usuari els litres consumits en el mes actual
 * @author gallardo4
 * @since 10/01/23
 */
fun litresConsumits():Int{
    return llegirInt(YELLOW+"Quants litres has consumit aquest mes (min -"+YELLOW_BOLD_BRIGHT+" 0,"+YELLOW+" max - "+YELLOW_BOLD_BRIGHT+"1000000"+YELLOW+")?:"+RESET,0,1000000)
}

/**
 * Aquesta funció retorna un valor fix
 * @author gallardo4
 * @since 10/01/23
 */
fun quotaFixa():Int{
    return 6
}

/**
 * Aquesta funció assigna uno quota variable segons els litres consumits
 * @author gallardo4
 * @since 10/01/23
 */
fun quotaVariable(litresConsumits:Int):Double{
    var quotaVariable=0.0
    if (litresConsumits<50) {
        quotaVariable=0.0
    } else if (litresConsumits in 50..200) {
        quotaVariable=0.15
    } else {
        quotaVariable=0.30
    }
    return quotaVariable
}

/**
 * Aquesta funció retorna un booleà segons si la familia de l'usuari és nombrosa o monomarental
 * @author gallardo4
 * @since 10/01/23
 */
fun familiaNombrosaOMonomarental():Boolean{
    return llegirBoolean(PURPLE+"La teva familia és nombrosa o monomarental ("+PURPLE_BOLD_BRIGHT+"true"+PURPLE+" o "+PURPLE_BOLD_BRIGHT+"false"+PURPLE+")?:"+RESET)
}

/**
 * Aquesta funció serveix per preguntar a l'usuari el nombre de membres de la familia
 * @author gallardo4
 * @since 10/01/23
 */
fun membresFamilia():Int{
    return llegirInt(PURPLE+"Quants membres sou a la familia (min -"+PURPLE_BOLD_BRIGHT+" 1,"+PURPLE+" max - "+PURPLE_BOLD_BRIGHT+"30"+PURPLE+")?:"+RESET,1,30)
}

/**
 * Aquesta funció retorna una quantitat de descompte depenent d'unes condicions en la familia de l'usuari
 * @author gallardo4
 * @since 10/01/23
 */
fun descompteFamiliaNombrosaOMonomarental(esNombrosaOMonomarental:Boolean,membresFamilia:Int):Double{
    var descompteFNOM=0.0
    if (esNombrosaOMonomarental) descompteFNOM=0.1*membresFamilia
    if (descompteFNOM>0.5) descompteFNOM=0.5
    return descompteFNOM
}

/**
 * Aquesta funció serveix per preguntar a l'usuari si té o no bo social
 * @author gallardo4
 * @since 10/01/23
 */
fun boSocial():Boolean{
    return llegirBoolean(PURPLE+"Tens bo social ("+PURPLE_BOLD_BRIGHT+"true"+PURPLE+" o "+PURPLE_BOLD_BRIGHT+"false"+PURPLE+")?:"+RESET)
}

/**
 * Aquesta funció serveix per aplicar un descompte segons si l'usuari té o no bo social
 * @author gallardo4
 * @since 10/01/23
 */
fun descompteBoSocial(teBoSocial:Boolean):Double{
    var descompteBo=0.0
    if (teBoSocial) descompteBo=0.8
    return descompteBo
}

/**
 * Aquesta funció introdueix a l'usuari a les preguntes
 * @author gallardo4
 * @since 10/01/23
 */
fun menu(){
    println(GREEN_BOLD_BRIGHT+"FACTURA DE L'AIGUA"+RESET)
    println()
}