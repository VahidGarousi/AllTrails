plugins {
    alias(libs.plugins.alltrails.android.library)
}

android {
    namespace = "ir.vahid.konsist"
}

dependencies {
    testImplementation(libs.bundles.kotest)
    testImplementation(libs.konsist)
}
