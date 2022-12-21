package day07

//class Dir(val name: String, val parent: Dir? = null, var dirs: List<Dir> = mutableListOf(), val files: List<File> = mutableListOf())
class File(public val name: String, val size: Int)

class Dir(val name: String, val parent: Dir? = null) {
    val dirs = mutableListOf<Dir>()
    val files = mutableListOf<File>()
}

class VFS {
    var root = Dir("/")
    var cwd = root
    var sumOfDirsLessThan10kTotal = 0

    fun cd(s: String) {
        cwd = when (s) {
            ".." -> {
                if (cwd.parent == null) throw IllegalStateException("cd .. failed: already at root")
                cwd.parent!!
            }
            "/" -> {
                root
            }
            else -> {
                cwd.dirs.first { it.name == s }
            }
        }
    }

    fun mkdir(s: String) {
        if (cwd.dirs.any { it.name == s}) {
            throw IllegalStateException("mkdir failed: name already exists: $s")
        }
        cwd.dirs.add(Dir(s, cwd))
    }

    fun mkfile(s: String, size: Int) {
        if (cwd.files.any { it.name == s }) {
            throw IllegalStateException("mkfile failed: name already exists: $s")
        }
        cwd.files.add(File(s, size))
    }

    fun used(): Int {
        return used(root)
    }

    private fun used(dir: Dir): Int {
        var sum = 0

        sum += dir.files.sumOf { it.size }
        sum += dir.dirs.sumOf { sumForPart1(it) }

        return sum
    }
}