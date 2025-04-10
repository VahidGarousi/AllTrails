import org.gradle.api.Plugin
import org.gradle.api.Project
import ir.vahid.alltrails.libs
import ir.vahid.alltrails.detektGradle
import ir.vahid.alltrails.configureDetekt

class AndroidDetektConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.run {
            applyPlugins()
            detektGradle {
                configureDetekt(this)
            }
        }
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply(libs.findLibrary("detekt-gradlePlugin").get().get().group.toString())
        }
    }
}
