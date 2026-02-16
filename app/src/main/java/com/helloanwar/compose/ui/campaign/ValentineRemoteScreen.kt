package com.helloanwar.compose.ui.campaign

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.remote.creation.compose.capture.rememberRemoteDocument
import androidx.compose.remote.creation.compose.layout.RemoteAlignment
import androidx.compose.remote.creation.compose.layout.RemoteColumn
import androidx.compose.remote.creation.compose.layout.RemoteRow
import androidx.compose.remote.creation.compose.layout.RemoteText
import androidx.compose.remote.creation.compose.layout.RemoteArrangement
import androidx.compose.remote.creation.compose.action.HostAction
import androidx.compose.remote.creation.compose.modifier.RemoteModifier
import androidx.compose.remote.creation.compose.modifier.background
import androidx.compose.remote.creation.compose.modifier.clickable
import androidx.compose.remote.creation.compose.modifier.fillMaxWidth
import androidx.compose.remote.creation.compose.modifier.padding
import androidx.compose.remote.creation.compose.modifier.clip
import androidx.compose.remote.creation.compose.modifier.fillMaxSize
import androidx.compose.remote.creation.compose.modifier.height
import androidx.compose.remote.creation.compose.modifier.width
import androidx.compose.remote.creation.compose.modifier.rememberRemoteScrollState
import androidx.compose.remote.creation.compose.modifier.verticalScroll
import androidx.compose.remote.creation.compose.state.RemoteColor
import androidx.compose.remote.creation.compose.state.asRdp
import androidx.compose.remote.creation.compose.state.rs
import androidx.compose.remote.player.compose.RemoteDocumentPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

@SuppressLint("RestrictedApi")
@Composable
fun ValentineRemoteScreen() {
    val density = LocalDensity.current

    // Updated Darker Theme Colors
    val colorBackground = RemoteColor.fromARGB(1f, 0.10f, 0.04f, 0.10f) // #1A0A1A
    val colorPrimary = RemoteColor.fromARGB(1f, 0.93f, 0.17f, 0.36f) // #EE2B5B
    val colorSurface = RemoteColor.fromARGB(1f, 0.18f, 0.08f, 0.13f) // #2D1520
    val colorTextWhite = RemoteColor.fromARGB(1f, 1f, 1f, 1f)
    val colorTextGray = RemoteColor.fromARGB(1f, 0.8f, 0.8f, 0.8f)

    val document by rememberRemoteDocument {
        // Enable Scrolling
        val scrollState = rememberRemoteScrollState()

        RemoteColumn(
            modifier = RemoteModifier
                .fillMaxSize()
                .background(colorBackground)
                .verticalScroll(scrollState) // Scrollable Container
                .padding(all = 16.dp)
        ) {
            // --- Header ---
            RemoteColumn(
                modifier = RemoteModifier.fillMaxWidth(),
                horizontalAlignment = RemoteAlignment.CenterHorizontally
            ) {
                // Badge
                RemoteText(
                    text = "❤️ LIMITED TIME OFFER ❤️".rs,
                    color = colorTextWhite,
                    fontSize = 10.sp,
                    modifier = RemoteModifier
                        .background(RemoteColor.fromARGB(1f, 0.3f, 0.1f, 0.2f))
                        .padding(left = 12.dp, top = 6.dp, right = 12.dp, bottom = 6.dp)
                        .clip(RoundedCornerShape(size = 50.dp))
                )
                
                // Title
                RemoteText(
                    text = "Code Your".rs,
                    color = colorTextWhite,
                    fontSize = 32.sp,
                    modifier = RemoteModifier.padding(top = 16.dp)
                )
                RemoteText(
                    text = "Heart Out".rs,
                    color = colorPrimary,
                    fontSize = 32.sp
                )

                RemoteText(
                    text = "Fall in love with Python this Valentine's.".rs,
                    color = colorTextGray,
                    fontSize = 14.sp,
                    modifier = RemoteModifier.padding(top = 8.dp),
                    textAlign = TextAlign.Center
                )
                 RemoteText(
                    text = "Special pricing for you and your coding partner.".rs,
                    color = colorTextGray,
                    fontSize = 14.sp,
                    modifier = RemoteModifier.padding(top = 4.dp),
                    textAlign = TextAlign.Center
                )
            }

            // --- Countdown ---
            RemoteRow(
                modifier = RemoteModifier
                    .fillMaxWidth()
                    .padding(left = 0.dp, top = 24.dp, right = 0.dp, bottom = 24.dp),
                horizontalArrangement = RemoteArrangement.CenterHorizontally
            ) {
                CountdownItem("02", "DAYS", colorSurface, colorTextWhite, colorTextGray)
                CountdownItem("14", "HRS", colorSurface, colorTextWhite, colorTextGray)
                CountdownItem("38", "MINS", colorSurface, colorTextWhite, colorTextGray)
            }

            // --- Pricing Cards ---
            RemoteColumn(
                modifier = RemoteModifier.fillMaxWidth(),
                horizontalAlignment = RemoteAlignment.CenterHorizontally
            ) {
                // Free Tier - The Single Bracket
                PricingCard(
                    title = "The Single Bracket",
                    subtitle = "For those just starting to script.",
                    price = "$0",
                    period = "/mo",
                    features = listOf("🔘 Access to 5 Intro Lessons", "🔘 Basic Syntax Cheat Sheet", "🔘 Community Support"),
                    action = "free_tier",
                    colors = PricingColors(colorSurface, colorTextWhite, colorTextGray, colorPrimary),
                    icon = "< >"
                )

                // Single Premium - Committed Coder
                PricingCard(
                    title = "Committed Coder",
                    subtitle = "Ready to merge to main.",
                    price = "$14",
                    period = "/mo",
                    strikePrice = "$29/mo",
                    features = listOf("❤️ Full Python Mastery Path", "❤️ Web Dev Bootcamp", "❤️ Unlimited Certificates", "❤️ Offline Downloads"),
                    action = "single_premium",
                    colors = PricingColors(colorSurface, colorTextWhite, colorTextGray, colorPrimary),
                    highlightText = "MOST LOVED",
                    modifier = RemoteModifier.padding(top = 16.dp),
                    icon = "❤️"
                )

                // Pair Premium - Pair Programming
                PricingCard(
                    title = "Pair Programming",
                    subtitle = "Better together. 2 Accounts.",
                    price = "$19",
                    period = "/mo",
                    strikePrice = "$45/mo",
                    features = listOf("🟣 2 Premium Accounts", "🟣 Shared Progress Dashboard", "🟣 Pair Programming Challenges"),
                    action = "claim_offer",
                    colors = PricingColors(colorSurface, colorTextWhite, colorTextGray, colorPrimary),
                    highlightText = "SAVE 50%",
                    highlightColor = RemoteColor.fromARGB(1f, 0.6f, 0.2f, 0.8f), // Purple accent
                    modifier = RemoteModifier.padding(top = 16.dp),
                    icon = "👤👤"
                )
            }
            
            // --- Why Developers Love Us Section ---
             RemoteColumn(
                modifier = RemoteModifier.fillMaxWidth().padding(top=32.dp, bottom=16.dp),
                horizontalAlignment = RemoteAlignment.CenterHorizontally
            ) {
                 RemoteText("WHY DEVELOPERS LOVE US".rs, color = colorTextGray, fontSize = 12.sp, modifier = RemoteModifier.padding(bottom=16.dp))
                 
                 RemoteRow(modifier = RemoteModifier.fillMaxWidth(), horizontalArrangement = RemoteArrangement.SpaceBetween) {
                     FeatureBox("Interactive", "Console", "💻", colorSurface, colorTextWhite)
                     FeatureBox("Expert", "Mentors", "🎓", colorSurface, colorTextWhite)
                 }
            }


            // --- CTA Button (Sticky-ish bottom) ---
            RemoteColumn(
                modifier = RemoteModifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 32.dp)
                    .background(colorPrimary)
                    .clip(RoundedCornerShape(50.dp))
                    .clickable(HostAction("claim_offer".rs))
                    .padding(left = 0.dp, top = 16.dp, right = 0.dp, bottom = 16.dp),
                horizontalAlignment = RemoteAlignment.CenterHorizontally
            ) {
                 RemoteRow(verticalAlignment = RemoteAlignment.CenterVertically) {
                     RemoteText("Claim Offer".rs, color = colorTextWhite, fontSize = 18.sp)
                     RemoteText(" ➡️".rs, color = colorTextWhite, fontSize = 18.sp)
                 }
            }
            
             RemoteText(
                text = "Offer ends Feb 15th. Cancel anytime.".rs,
                color = colorTextGray,
                fontSize = 10.sp,
                modifier = RemoteModifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
    
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val widthPx =
            with(density) { constraints.maxWidth.let { if (it == Int.MAX_VALUE) 1080 else it } }
        val heightPx =
            with(density) { constraints.maxHeight.let { if (it == Int.MAX_VALUE) 1920 else it } }

        if (document != null) {
            RemoteDocumentPlayer(
                document = document!!,
                documentWidth = widthPx,
                documentHeight = heightPx,
                modifier = Modifier.fillMaxSize(),
                onNamedAction = { name, value, _ ->
                    println("Action: $name, Value: $value")
                }
            )
        } else {
            Text("Loading Valentine's Offer...")
        }
    }
}

data class PricingColors(
    val surface: RemoteColor,
    val textWhite: RemoteColor,
    val textGray: RemoteColor,
    val primary: RemoteColor
)

@SuppressLint("RestrictedApi")
@Composable
fun PricingCard(
    title: String,
    subtitle: String,
    price: String,
    period: String,
    features: List<String>,
    action: String,
    colors: PricingColors,
    highlightText: String? = null,
    highlightColor: RemoteColor? = null,
    strikePrice: String? = null,
    icon: String = "",
    modifier: RemoteModifier = RemoteModifier
) {
    RemoteColumn(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.surface)
            .clip(RoundedCornerShape(size = 16.dp))
            .clickable(HostAction(action.rs))
            .padding(all = 24.dp)
    ) {
         RemoteRow(
            modifier = RemoteModifier.fillMaxWidth(),
            horizontalArrangement = RemoteArrangement.SpaceBetween
        ) {
            RemoteColumn {
                if (highlightText != null) {
                     RemoteText(
                        text = highlightText.rs, 
                        color = colors.textWhite, 
                        fontSize = 10.sp, 
                        modifier = RemoteModifier
                            .background(highlightColor ?: colors.primary)
                            .padding(left = 8.dp, top = 4.dp, right = 8.dp, bottom = 4.dp)
                            .clip(RoundedCornerShape(50.dp))
                    )
                     // Spacer
                    RemoteColumn(modifier = RemoteModifier.height(8.dp.asRdp())) {}
                }
                
                RemoteText(title.rs, color = colors.textWhite, fontSize = 18.sp)
                RemoteText(subtitle.rs, color = colors.textGray, fontSize = 12.sp)
            }
            if (icon.isNotEmpty()) {
                 RemoteText(icon.rs, fontSize = 24.sp)
            }
        }

        RemoteRow(
            modifier = RemoteModifier.padding(top = 16.dp),
            verticalAlignment = RemoteAlignment.Bottom
        ) {
            RemoteText(price.rs, color = colors.textWhite, fontSize = 36.sp)
            RemoteText(period.rs, color = colors.textGray, fontSize = 14.sp, modifier = RemoteModifier.padding(bottom = 6.dp))
             if (strikePrice != null) {
                 RemoteText(strikePrice.rs, color = colors.primary, fontSize = 12.sp, modifier = RemoteModifier.padding(left = 8.dp, bottom=6.dp))
             }
        }

        // Spacer
        RemoteColumn(modifier = RemoteModifier.height(16.dp.asRdp())) {}

        features.forEach { feature ->
            RemoteText(feature.rs, color = colors.textGray, fontSize = 14.sp, modifier = RemoteModifier.padding(left = 0.dp, top = 4.dp, right = 0.dp, bottom = 4.dp))
        }
    }
}


@SuppressLint("RestrictedApi")
@Composable
fun CountdownItem(
    value: String, 
    label: String, 
    bg: RemoteColor, 
    textColor: RemoteColor, 
    labelColor: RemoteColor
) {
    RemoteColumn(
        modifier = RemoteModifier
            .width(60.dp.asRdp())
            .background(bg) // Using same surface color for consistency
            .clip(RoundedCornerShape(8.dp))
            .padding(left = 0.dp, top = 12.dp, right = 0.dp, bottom = 12.dp),
        horizontalAlignment = RemoteAlignment.CenterHorizontally
    ) {
        RemoteText(value.rs, color = textColor, fontSize = 24.sp)
        RemoteText(label.rs, color = labelColor, fontSize = 10.sp)
    }
}

@SuppressLint("RestrictedApi")
@Composable
fun FeatureBox(
    line1: String,
    line2: String,
    icon: String,
    bg: RemoteColor,
    textColor: RemoteColor
) {
    RemoteRow(
        modifier = RemoteModifier
            .width(160.dp.asRdp())
            .background(bg)
            .clip(RoundedCornerShape(8.dp))
            .padding(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp),
        verticalAlignment = RemoteAlignment.CenterVertically
    ) {
        RemoteText(icon.rs, fontSize = 24.sp, modifier = RemoteModifier.padding(right = 12.dp))
        RemoteColumn {
            RemoteText(line1.rs, color = textColor, fontSize = 14.sp)
            RemoteText(line2.rs, color = textColor, fontSize = 14.sp)
        }
    }
}
