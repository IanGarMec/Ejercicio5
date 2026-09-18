package com.mexiti.costogasolina

import android.icu.text.NumberFormat
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.mexiti.costogasolina.ui.theme.CostoGasolinaTheme
import org.junit.Rule
import org.junit.Test

class CostGasLayout40LitrosUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calcularMonto_40l_22_35() {
        composeTestRule.setContent {
            CostoGasolinaTheme {
                CostGasLayout()
            }
        }

        val campos = composeTestRule.onAllNodes(hasSetTextAction())
        campos[0].performTextInput("22.35")
        campos[1].performTextInput("40")

        val montoEsperado = NumberFormat.getCurrencyInstance().format(894.0)

        composeTestRule.onNodeWithText("Monto Total: $montoEsperado")
            .assertExists("No se encontró ningún nodo con este texto")
    }
}