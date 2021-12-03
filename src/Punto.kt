import kotlin.math.pow
import kotlin.math.sqrt

fun main(){
    //Programa1
    //var p1 = Punto("pA",3,2)
    //var p2 = Punto("pB",1,3)
    //println(Punto.componenteDeVector(p1,p2))
    //Programa2
    var pArray = arrayOf(Punto("p1",-1,0),Punto("p2",3,-1),Punto("p3",-4,4),
        Punto("p4",-3,2), Punto("p5",6,-4),Punto("p6",-5,6),
        Punto("p7",10,-8),Punto("p8",1,5),Punto("p9",6,-7))
    
    println("Norte: ${Punto.localizacionGeograficaNS(pArray)["Norte"]}")
    println("Sur: ${Punto.localizacionGeograficaNS(pArray)["Sur"]}")
}

class Punto (id:String) {

    val id: String = id
    var x: Int = 0
    var y: Int = 0

    constructor(id: String, x: Int, y: Int) : this(id) {
        this.x = x
        this.y = y
    }

    fun obtenerCoordenadas(): Pair<Int, Int> {
        return Pair(x, y)
    }

    override fun toString(): String {
        return "Punto <$id> ->[$x,$y]"
    }

    companion object {
        fun componenteDeVector(p1: Punto, p2: Punto): Punto {
            return Punto(p1.id + p2.id, p2.x - p1.x, p2.y - p1.y)
        }
        fun localizacionGeograficaNS(pArray:Array<Punto>):Map<String,List<Punto>>{
            var norte = arrayListOf<Punto>()
            var sur = arrayListOf<Punto>()

            var aMap = mutableMapOf<String,List<Punto>>()
            pArray.forEach {if(it.y>=0){norte.add(it)}else{sur.add(it)}}

            aMap.put("Norte",norte.toList())
            aMap.put("Sur",sur.toList())

            return aMap
        }
        fun distancia(p1: Punto, p2: Punto): Double {return sqrt((p2.x-p1.x).toDouble().pow(2)+(p2.y-p1.y).toDouble().pow(2))}
    }
}