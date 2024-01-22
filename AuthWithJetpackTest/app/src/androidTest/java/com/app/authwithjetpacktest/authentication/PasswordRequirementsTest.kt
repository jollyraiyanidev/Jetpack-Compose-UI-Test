package com.app.authwithjetpacktest.authentication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import com.app.authwithjetpacktest.ui.authentication.PasswordRequirements
import org.junit.Rule
import org.junit.Test
import com.app.authwithjetpacktest.R

class PasswordRequirementsTest {

    @get:Rule
    val composeTestRule = createComposeRule()



    @Test
    fun Password_Requirement_Displayed_As_Not_Satisfied() {

        val requirements = PasswordRequirements.entries
        val satisfiedRequirements = requirements[(0 until requirements.count()).random()]

        composeTestRule.setContent {
            PasswordRequirements(satisfiedRequirements = listOf(satisfiedRequirements))
        }

        PasswordRequirements.entries.forEach { requirement ->
            val requirement =
                InstrumentationRegistry.getInstrumentation()
                    .targetContext.getString(requirement.label)
            val satisfyRequirement =
                InstrumentationRegistry.getInstrumentation()
                    .targetContext.getString(satisfiedRequirements.label)

            val result = if (requirement == satisfyRequirement) {
                InstrumentationRegistry.getInstrumentation().targetContext.getString(
                    R.string.password_requirement_satisfied,requirement
                )
            } else {
                InstrumentationRegistry.getInstrumentation()
                    .targetContext.getString(
                        R.string.password_requirement_needed,requirement
                    )

            }

            composeTestRule
                .onNodeWithText(result)
                .assertIsDisplayed()
        }
    }

}