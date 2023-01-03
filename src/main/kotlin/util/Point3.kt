package util

data class Point3(val x: Int, val y: Int, val z: Int) {
    fun nonDiagonalNeighs(): Set<Point3> {
        val ns = mutableSetOf<Point3>()
        val dx = arrayListOf(
            Point3(1,0,0), Point3(-1,0,0), Point3(0,1,0),
            Point3(0,-1,0), Point3(0,0,1),Point3(0,0,-1))

        dx.forEach {
            ns.add(Point3(x+it.x,y+it.y,z+it.z))
        }

        return ns
    }

    fun plus(p: Point3): Point3 {
        return Point3(x+p.x, y+p.y, z+p.z)
    }
}