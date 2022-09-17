package me.injin.javatokotlin.chapter03

class StringUtil {
    companion object {
        fun isDirectoryPath(path: String): Boolean {
            return path.endsWith("/")
        }
    }
}
