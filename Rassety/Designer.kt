package com.example.lr_calc_2026
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp

object Designer
{
    @Composable
    fun colorB(f: Color): ButtonColors { return ButtonDefaults.buttonColors(containerColor = f) }
    @Composable
    fun StyledButton(onClick: () -> Unit, text: String, textColor: Color, colk: List<Color>)
    {
        Button(onClick={ onClick(); }, colors= colorB(Color.Transparent), modifier = Modifier.fillMaxWidth())
        {
            Box(modifier=Modifier.background(Brush.horizontalGradient(colk)).fillMaxWidth().height(38.dp),
                contentAlignment = Alignment.Center) { Text(text, color=textColor, fontSize = 34.sp) }
        }
    }
    @Composable
    fun StyledButtonDefault(onClick: () -> Unit, text: String)
    {
        StyledButton(onClick = { onClick(); }, text=text,
        textColor=Color.White, colk=listOf(Color.Black, Color.DarkGray, Color.Red) )
    }
    @Composable
    fun SuperText(text: String, pv: PaddingValues, s: Int, modifier: Modifier)
    {
        Text(
            text, modifier = modifier.padding(pv).fillMaxWidth(),
            fontSize = s.sp, textAlign = TextAlign.Center
        )
    }
}
