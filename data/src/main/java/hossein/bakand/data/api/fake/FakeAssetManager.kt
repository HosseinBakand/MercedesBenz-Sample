package hossein.bakand.data.api.fake

import java.io.InputStream

fun interface FakeAssetManager {
    fun open(fileName: String): InputStream
}
