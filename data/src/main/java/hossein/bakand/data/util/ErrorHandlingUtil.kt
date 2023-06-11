package hossein.bakand.data.util

import android.util.Log
import kotlin.coroutines.cancellation.CancellationException

suspend fun networkRequest(
    request: suspend () -> Unit,
) = suspendRunCatching {
    request()
}.isSuccess

private suspend fun <T> suspendRunCatching(block: suspend () -> T): Result<T> = try {
    Result.success(block())
} catch (cancellationException: CancellationException) {
    throw cancellationException
} catch (exception: Exception) {
    Log.i(
        "suspendRunCatching",
        "Failed to evaluate a suspendRunCatchingBlock. Returning failure Result",
        exception,
    )
    Result.failure(exception)
}