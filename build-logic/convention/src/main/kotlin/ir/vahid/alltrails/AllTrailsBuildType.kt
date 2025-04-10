package ir.vahid.alltrails

/**
 * This is shared between :app and :benchmarks module to provide configurations type safety.
 */
enum class AllTrailsBuildType(val versionNameSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}
