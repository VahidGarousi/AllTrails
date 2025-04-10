package ir.vahid.alltrails


import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create


internal fun Project.configureAndroidModulePublishing() {
    extensions.configure<LibraryExtension> {
        publishing {
            singleVariant("release") {
                withSourcesJar()
                withJavadocJar()
            }
        }
    }
    extensions.create("alltrailsPublisher", ModuleInfoExtension::class)
}



internal fun Project.configureJvmModulePublishing() {
    extensions.create("alltrailsPublisher", ModuleInfoExtension::class)
}

