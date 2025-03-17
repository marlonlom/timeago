/*
 * Copyright (c) 2016, marlonlom
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.github.marlonlom.timeago.sample.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Branded color contrasts enum class.
 *
 * @author marlonlom
 *
 * @property light Light color scheme.
 * @property dark Dark color scheme.
 *
 */
enum class TimeagoSampleColorContrasts(val light: ColorScheme, val dark: ColorScheme) {

  /** Default branded color contrast: Standard. */
  STANDARD(
    light = lightColorScheme(
      primary = Color(0xFF096780),
      onPrimary = Color(0xFFFFFFFF),
      primaryContainer = Color(0xFFB8EAFF),
      onPrimaryContainer = Color(0xFF004D61),
      secondary = Color(0xFF1A6585),
      onSecondary = Color(0xFFFFFFFF),
      secondaryContainer = Color(0xFFC2E8FF),
      onSecondaryContainer = Color(0xFF004D68),
      tertiary = Color(0xFF01677D),
      onTertiary = Color(0xFFFFFFFF),
      tertiaryContainer = Color(0xFFB2EBFF),
      onTertiaryContainer = Color(0xFF004E5F),
      error = Color(0xFFBA1A1A),
      onError = Color(0xFFFFFFFF),
      errorContainer = Color(0xFFFFDAD6),
      onErrorContainer = Color(0xFF93000A),
      background = Color(0xFFF5FAFD),
      onBackground = Color(0xFF171C1F),
      surface = Color(0xFFF5FAFD),
      onSurface = Color(0xFF171C1F),
      surfaceVariant = Color(0xFFDCE4E8),
      onSurfaceVariant = Color(0xFF40484C),
      outline = Color(0xFF70787C),
      outlineVariant = Color(0xFFBFC8CC),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFF2C3134),
      inverseOnSurface = Color(0xFFEDF1F4),
      inversePrimary = Color(0xFF88D0ED),
      surfaceDim = Color(0xFFD6DBDE),
      surfaceBright = Color(0xFFF5FAFD),
      surfaceContainerLowest = Color(0xFFFFFFFF),
      surfaceContainerLow = Color(0xFFF0F4F7),
      surfaceContainer = Color(0xFFEAEEF2),
      surfaceContainerHigh = Color(0xFFE4E9EC),
      surfaceContainerHighest = Color(0xFFDEE3E6),
    ),
    dark = darkColorScheme(
      primary = Color(0xFF88D0ED),
      onPrimary = Color(0xFF003544),
      primaryContainer = Color(0xFF004D61),
      onPrimaryContainer = Color(0xFFB8EAFF),
      secondary = Color(0xFF8ECFF2),
      onSecondary = Color(0xFF003548),
      secondaryContainer = Color(0xFF004D68),
      onSecondaryContainer = Color(0xFFC2E8FF),
      tertiary = Color(0xFF86D1EA),
      onTertiary = Color(0xFF003642),
      tertiaryContainer = Color(0xFF004E5F),
      onTertiaryContainer = Color(0xFFB2EBFF),
      error = Color(0xFFFFB4AB),
      onError = Color(0xFF690005),
      errorContainer = Color(0xFF93000A),
      onErrorContainer = Color(0xFFFFDAD6),
      background = Color(0xFF0F1416),
      onBackground = Color(0xFFDEE3E6),
      surface = Color(0xFF0F1416),
      onSurface = Color(0xFFDEE3E6),
      surfaceVariant = Color(0xFF40484C),
      onSurfaceVariant = Color(0xFFBFC8CC),
      outline = Color(0xFF8A9296),
      outlineVariant = Color(0xFF40484C),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFFDEE3E6),
      inverseOnSurface = Color(0xFF2C3134),
      inversePrimary = Color(0xFF096780),
      surfaceDim = Color(0xFF0F1416),
      surfaceBright = Color(0xFF353A3D),
      surfaceContainerLowest = Color(0xFF0A0F11),
      surfaceContainerLow = Color(0xFF171C1F),
      surfaceContainer = Color(0xFF1B2023),
      surfaceContainerHigh = Color(0xFF252B2D),
      surfaceContainerHighest = Color(0xFF303638),
    ),
  ),

  /** Branded color contrast: Medium. */
  MEDIUM(
    light = lightColorScheme(
      primary = Color(0xFF003C4B),
      onPrimary = Color(0xFFFFFFFF),
      primaryContainer = Color(0xFF25768F),
      onPrimaryContainer = Color(0xFFFFFFFF),
      secondary = Color(0xFF003B50),
      onSecondary = Color(0xFFFFFFFF),
      secondaryContainer = Color(0xFF2E7494),
      onSecondaryContainer = Color(0xFFFFFFFF),
      tertiary = Color(0xFF003C49),
      onTertiary = Color(0xFFFFFFFF),
      tertiaryContainer = Color(0xFF21768C),
      onTertiaryContainer = Color(0xFFFFFFFF),
      error = Color(0xFF740006),
      onError = Color(0xFFFFFFFF),
      errorContainer = Color(0xFFCF2C27),
      onErrorContainer = Color(0xFFFFFFFF),
      background = Color(0xFFF5FAFD),
      onBackground = Color(0xFF171C1F),
      surface = Color(0xFFF5FAFD),
      onSurface = Color(0xFF0D1214),
      surfaceVariant = Color(0xFFDCE4E8),
      onSurfaceVariant = Color(0xFF2F373B),
      outline = Color(0xFF4C5458),
      outlineVariant = Color(0xFF666E72),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFF2C3134),
      inverseOnSurface = Color(0xFFEDF1F4),
      inversePrimary = Color(0xFF88D0ED),
      surfaceDim = Color(0xFFC2C7CA),
      surfaceBright = Color(0xFFF5FAFD),
      surfaceContainerLowest = Color(0xFFFFFFFF),
      surfaceContainerLow = Color(0xFFF0F4F7),
      surfaceContainer = Color(0xFFE4E9EC),
      surfaceContainerHigh = Color(0xFFD9DDE1),
      surfaceContainerHighest = Color(0xFFCDD2D5),
    ),
    dark = darkColorScheme(
      primary = Color(0xFFA7E5FF),
      onPrimary = Color(0xFF002A36),
      primaryContainer = Color(0xFF509AB4),
      onPrimaryContainer = Color(0xFF000000),
      secondary = Color(0xFFB3E3FF),
      onSecondary = Color(0xFF00293A),
      secondaryContainer = Color(0xFF5798BA),
      onSecondaryContainer = Color(0xFF000000),
      tertiary = Color(0xFF9FE7FF),
      onTertiary = Color(0xFF002A34),
      tertiaryContainer = Color(0xFF4E9BB2),
      onTertiaryContainer = Color(0xFF000000),
      error = Color(0xFFFFD2CC),
      onError = Color(0xFF540003),
      errorContainer = Color(0xFFFF5449),
      onErrorContainer = Color(0xFF000000),
      background = Color(0xFF0F1416),
      onBackground = Color(0xFFDEE3E6),
      surface = Color(0xFF0F1416),
      onSurface = Color(0xFFFFFFFF),
      surfaceVariant = Color(0xFF40484C),
      onSurfaceVariant = Color(0xFFD5DEE2),
      outline = Color(0xFFABB3B7),
      outlineVariant = Color(0xFF899296),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFFDEE3E6),
      inverseOnSurface = Color(0xFF252B2D),
      inversePrimary = Color(0xFF004F63),
      surfaceDim = Color(0xFF0F1416),
      surfaceBright = Color(0xFF404548),
      surfaceContainerLowest = Color(0xFF04080A),
      surfaceContainerLow = Color(0xFF191E21),
      surfaceContainer = Color(0xFF23292B),
      surfaceContainerHigh = Color(0xFF2E3336),
      surfaceContainerHighest = Color(0xFF393E41),
    ),
  ),

  /** Branded color contrast: Medium. */
  HIGH(
    light = lightColorScheme(
      primary = Color(0xFF00313E),
      onPrimary = Color(0xFFFFFFFF),
      primaryContainer = Color(0xFF005064),
      onPrimaryContainer = Color(0xFFFFFFFF),
      secondary = Color(0xFF003043),
      onSecondary = Color(0xFFFFFFFF),
      secondaryContainer = Color(0xFF004F6B),
      onSecondaryContainer = Color(0xFFFFFFFF),
      tertiary = Color(0xFF00313C),
      onTertiary = Color(0xFFFFFFFF),
      tertiaryContainer = Color(0xFF005062),
      onTertiaryContainer = Color(0xFFFFFFFF),
      error = Color(0xFF600004),
      onError = Color(0xFFFFFFFF),
      errorContainer = Color(0xFF98000A),
      onErrorContainer = Color(0xFFFFFFFF),
      background = Color(0xFFF5FAFD),
      onBackground = Color(0xFF171C1F),
      surface = Color(0xFFF5FAFD),
      onSurface = Color(0xFF000000),
      surfaceVariant = Color(0xFFDCE4E8),
      onSurfaceVariant = Color(0xFF000000),
      outline = Color(0xFF252D31),
      outlineVariant = Color(0xFF424A4E),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFF2C3134),
      inverseOnSurface = Color(0xFFFFFFFF),
      inversePrimary = Color(0xFF88D0ED),
      surfaceDim = Color(0xFFB4B9BC),
      surfaceBright = Color(0xFFF5FAFD),
      surfaceContainerLowest = Color(0xFFFFFFFF),
      surfaceContainerLow = Color(0xFFEDF1F4),
      surfaceContainer = Color(0xFFDEE3E6),
      surfaceContainerHigh = Color(0xFFD0D5D8),
      surfaceContainerHighest = Color(0xFFC2C7CA),
    ),
    dark = darkColorScheme(
      primary = Color(0xFFDCF4FF),
      onPrimary = Color(0xFF000000),
      primaryContainer = Color(0xFF85CCE8),
      onPrimaryContainer = Color(0xFF000D13),
      secondary = Color(0xFFE1F3FF),
      onSecondary = Color(0xFF000000),
      secondaryContainer = Color(0xFF8ACBEE),
      onSecondaryContainer = Color(0xFF000D15),
      tertiary = Color(0xFFD9F5FF),
      onTertiary = Color(0xFF000000),
      tertiaryContainer = Color(0xFF82CDE5),
      onTertiaryContainer = Color(0xFF000D12),
      error = Color(0xFFFFECE9),
      onError = Color(0xFF000000),
      errorContainer = Color(0xFFFFAEA4),
      onErrorContainer = Color(0xFF220001),
      background = Color(0xFF0F1416),
      onBackground = Color(0xFFDEE3E6),
      surface = Color(0xFF0F1416),
      onSurface = Color(0xFFFFFFFF),
      surfaceVariant = Color(0xFF40484C),
      onSurfaceVariant = Color(0xFFFFFFFF),
      outline = Color(0xFFE9F1F6),
      outlineVariant = Color(0xFFBCC4C8),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFFDEE3E6),
      inverseOnSurface = Color(0xFF000000),
      inversePrimary = Color(0xFF004F63),
      surfaceDim = Color(0xFF0F1416),
      surfaceBright = Color(0xFF4B5154),
      surfaceContainerLowest = Color(0xFF000000),
      surfaceContainerLow = Color(0xFF1B2023),
      surfaceContainer = Color(0xFF2C3134),
      surfaceContainerHigh = Color(0xFF373C3F),
      surfaceContainerHighest = Color(0xFF42484A),
    ),
  ),
  ;

  /**
   * Utility functions for enum class.
   *
   * @author marlonlom
   */
  companion object {

    /**
     * Returns the selected color contrast color scheme by name and if dark theme is applied.
     *
     * @param colorContrast Selected color contrast name.
     * @param darkTheme True/False is dark theme is applied.
     * @return Selected color contrast scheme.
     */
    fun findColorScheme(colorContrast: String, darkTheme: Boolean): ColorScheme = valueOf(colorContrast).let {
      if (darkTheme) it.dark else it.light
    }
  }
}
