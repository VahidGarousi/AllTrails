package ir.vahid.core.designsystem

import ir.vahid.core.design_system.R

object TrailImagesGenerator {
    private val images = listOf(
        R.drawable.core_design_system_trail,
        R.drawable.core_design_system_trailgroup,
        R.drawable.core_design_system_1,
        R.drawable.core_design_system_2,
        R.drawable.core_design_system_3,
    )

    fun generate(): List<Int> = images.shuffled()
}
