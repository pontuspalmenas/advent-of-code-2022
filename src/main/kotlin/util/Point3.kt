package util

data class Point3(val x: Int, val y: Int, val z: Int) {
    fun allNeighs(): Set<Point3> {
        val ns = mutableSetOf<Point3>()
        for (x2 in x-1..x+1) {
            for (y2 in y-1..y+1) {
                for (z2 in z-1..z+1) {
                    ns.add(Point3(x2,y2,z2))
                }
            }
        }

        return ns
    }
}