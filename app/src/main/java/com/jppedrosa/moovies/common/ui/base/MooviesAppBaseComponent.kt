package com.jppedrosa.moovies.common.ui.base

import androidx.compose.runtime.Composable
import com.jppedrosa.moovies.common.ui.theme.MooviesTheme

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 22/09/2022.
 */
@Composable
fun MooviesAppBaseComponent(content: @Composable () -> Unit) {
    MooviesTheme {
        content()
    }
}
