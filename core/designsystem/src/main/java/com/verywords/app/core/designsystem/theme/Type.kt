package com.verywords.app.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.verywords.app.core.designsystem.R

private val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
)

private val pretendardFontFamily = FontFamily(
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
)


private val PretendardStyle = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight.Normal
)

private val PoppinsStyle = TextStyle(
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Normal
)

fun localeTextStyle(language: String): TextStyle {
    return when (language) {
        "ko" -> PretendardStyle
        "en" -> PoppinsStyle
        else -> PoppinsStyle
    }
}


@Composable
internal fun getTypography(language: String): POPLETypography {
    val localeTextStyle = localeTextStyle(language = language)
    return when (language) {
        "ko" -> {
            POPLETypography(
                headingL = localeTextStyle.copy(
                    fontSize = 32.sp,
                    lineHeight = (32 * 1.3).sp,
                    fontWeight = FontWeight.Bold,
                ),
                headingS = localeTextStyle.copy(
                    fontSize = 24.sp,
                    lineHeight = (24 * 1.5).sp,
                    fontWeight = FontWeight.Bold
                ),
                bodyLb = localeTextStyle.copy(
                    fontSize = 16.sp,
                    lineHeight = (16 * 1.6).sp,
                    fontWeight = FontWeight.Bold
                ),
                bodyLr = localeTextStyle.copy(
                    fontSize = 16.sp,
                    lineHeight = (16 * 1.6).sp,
                    fontWeight = FontWeight.Normal
                ),
                bodyMb = localeTextStyle.copy(
                    fontSize = 14.8.sp,
                    lineHeight = (14.8 * 1.6).sp,
                    fontWeight = FontWeight.Bold
                ),
                bodyMr = localeTextStyle.copy(
                    fontSize = 14.8.sp,
                    lineHeight = (14.8 * 1.6).sp,
                    fontWeight = FontWeight.Normal
                ),
                bodySb = localeTextStyle.copy(
                    fontSize = 13.5.sp,
                    lineHeight = (13.5 * 1.5).sp,
                    fontWeight = FontWeight.Bold
                ),
                bodySr = localeTextStyle.copy(
                    fontSize = 13.5.sp,
                    lineHeight = (13.5 * 1.5).sp,
                    fontWeight = FontWeight.Normal
                ),
                titleS = localeTextStyle.copy(
                    fontSize = 13.sp,
                    lineHeight = (13 * 1.5).sp,
                    fontWeight = FontWeight.Bold
                ),
                titleM = localeTextStyle.copy(
                    fontSize = 14.sp,
                    lineHeight = (14 * 1.6).sp,
                    fontWeight = FontWeight.Bold
                ),
                titleL = localeTextStyle.copy(
                    fontSize = 15.5.sp,
                    lineHeight = (15.5 * 1.6).sp,
                    fontWeight = FontWeight.Bold
                ),
                subTitleS = localeTextStyle.copy(
                    fontSize = 13.sp,
                    lineHeight = (13 * 1.5).sp,
                    fontWeight = FontWeight.Medium
                ),
                subTitleM = localeTextStyle.copy(
                    fontSize = 14.sp,
                    lineHeight = (14 * 1.6).sp,
                    fontWeight = FontWeight.SemiBold
                ),
                subTitleL = localeTextStyle.copy(
                    fontSize = 15.5.sp,
                    lineHeight = (15.5 * 1.6).sp,
                    fontWeight = FontWeight.Medium
                ),
            )
        }

        else -> {
            POPLETypography(
                headingL = localeTextStyle.copy(
                    fontSize = 32.sp,
                    lineHeight = (32 * 1.3).sp,
                    letterSpacing = (-0.2).sp,
                ),
                headingS = localeTextStyle.copy(
                    fontSize = 22.sp,
                    lineHeight = (22 * 1.5).sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (-0.2).sp,
                ),
                bodyLb = localeTextStyle.copy(
                    fontSize = 15.5.sp,
                    lineHeight = (15.5 * 1.6).sp,
                    letterSpacing = (-0.2).sp,
                    fontWeight = FontWeight.SemiBold
                ),
                bodyLr = localeTextStyle.copy(
                    fontSize = 15.5.sp,
                    lineHeight = (15.5 * 1.6).sp,
                    letterSpacing = (-0.2).sp,
                    fontWeight = FontWeight.Normal
                ),
                bodyMb = localeTextStyle.copy(
                    fontSize = 14.sp,
                    lineHeight = (14 * 1.6).sp,
                    letterSpacing = (-0.2).sp,
                    fontWeight = FontWeight.SemiBold
                ),
                bodyMr = localeTextStyle.copy(
                    fontSize = 14.sp,
                    lineHeight = (14 * 1.6).sp,
                    letterSpacing = (-0.2).sp,
                    fontWeight = FontWeight.Normal
                ),
                bodySb = localeTextStyle.copy(
                    fontSize = 13.sp,
                    lineHeight = (13 * 1.4).sp,
                    letterSpacing = (-0.5).sp,
                    fontWeight = FontWeight.SemiBold
                ),
                bodySr = localeTextStyle.copy(
                    fontSize = 13.sp,
                    lineHeight = (13 * 1.4).sp,
                    letterSpacing = (-0.5).sp,
                    fontWeight = FontWeight.Normal
                ),
                titleS = localeTextStyle.copy(
                    fontSize = 13.sp,
                    lineHeight = (13 * 1.5).sp,
                    letterSpacing = (-0.3).sp,
                    fontWeight = FontWeight.SemiBold
                ),
                titleM = localeTextStyle.copy(
                    fontSize = 14.sp,
                    lineHeight = (14 * 1.6).sp,
                    letterSpacing = (-0.2).sp,
                    fontWeight = FontWeight.SemiBold
                ),
                titleL = localeTextStyle.copy(
                    fontSize = 15.5.sp,
                    lineHeight = (15.5 * 1.6).sp,
                    letterSpacing = (-0.2).sp,
                    fontWeight = FontWeight.SemiBold
                ),
                subTitleS = localeTextStyle.copy(
                    fontSize = 13.sp,
                    lineHeight = (13 * 1.5).sp,
                    letterSpacing = (-0.3).sp,
                    fontWeight = FontWeight.Medium
                ),
                subTitleM = localeTextStyle.copy(
                    fontSize = 14.sp,
                    lineHeight = (14 * 1.6).sp,
                    letterSpacing = (-0.2).sp,
                    fontWeight = FontWeight.SemiBold
                ),
                subTitleL = localeTextStyle.copy(
                    fontSize = 15.5.sp,
                    lineHeight = (15.5 * 1.6).sp,
                    letterSpacing = (-0.2).sp,
                    fontWeight = FontWeight.Medium
                ),
            )
        }
    }
}

@Immutable
data class POPLETypography(
    val headingL: TextStyle,
    val headingS: TextStyle,
    val bodyLb: TextStyle,
    val bodyLr: TextStyle,
    val bodyMb: TextStyle,
    val bodyMr: TextStyle,
    val bodySb: TextStyle,
    val bodySr: TextStyle,
    val titleS: TextStyle,
    val titleM: TextStyle,
    val titleL: TextStyle,
    val subTitleS: TextStyle,
    val subTitleM: TextStyle,
    val subTitleL: TextStyle,
)

@Composable
fun getLocalTypography(): ProvidableCompositionLocal<POPLETypography> {
    val context = LocalContext.current
    return staticCompositionLocalOf {
        val locale = context.resources.configuration.locales[0]
        val localeTextStyle = localeTextStyle(language = locale.language)
        POPLETypography(
            headingL = localeTextStyle,
            headingS = localeTextStyle,
            bodyLr = localeTextStyle,
            bodyLb = localeTextStyle,
            bodyMb = localeTextStyle,
            bodyMr = localeTextStyle,
            bodySb = localeTextStyle,
            bodySr = localeTextStyle,
            titleS = localeTextStyle,
            titleM = localeTextStyle,
            titleL = localeTextStyle,
            subTitleS = localeTextStyle,
            subTitleM = localeTextStyle,
            subTitleL = localeTextStyle,
        )
    }
}

val LocalTypography = staticCompositionLocalOf {
    val defaultStyle = PoppinsStyle
    POPLETypography(
        headingL = defaultStyle,
        headingS = defaultStyle,
        bodyLr = defaultStyle,
        bodyLb = defaultStyle,
        bodyMb = defaultStyle,
        bodyMr = defaultStyle,
        bodySb = defaultStyle,
        bodySr = defaultStyle,
        titleS = defaultStyle,
        titleM = defaultStyle,
        titleL = defaultStyle,
        subTitleS = defaultStyle,
        subTitleM = defaultStyle,
        subTitleL = defaultStyle,
    )
}