object BuildVersions {
    const val buildTools = "32.0.0"
    const val compileSdk = 32
    const val minSdk = 24
    const val targetSdk = 32

    private const val majorVersion = 1
    private const val minorVersion = 0
    private const val patchVersion = 0

    const val versionCode = majorVersion * 10000 + minorVersion * 100 + patchVersion
    const val versionName = "$majorVersion.$minorVersion.$patchVersion"
}
