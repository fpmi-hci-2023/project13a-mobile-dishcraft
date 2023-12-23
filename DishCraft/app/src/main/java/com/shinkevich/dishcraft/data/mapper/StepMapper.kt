package com.shinkevich.dishcraft.data.mapper

import com.shinkevich.dishcraft.data.entity.Step
import com.shinkevich.dishcraft.data.networkstorage.entity.StepsResponse

class StepMapper {
    companion object {
        fun stepResponseToStep(stepResponse: StepsResponse): Step {
            return Step(
                stepResponse.stepId,
                stepResponse.stepDescription,
                stepResponse.numberInRecipe,
                ImageMapper.imageToBitmap(stepResponse.image)
            )
        }
    }
}