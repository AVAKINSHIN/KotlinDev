package com.example.lr_calc_2026
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Icon
class Komponenta(val text: String)
{
    var w by mutableStateOf(false)
    var po by mutableStateOf("")
    @ExperimentalMaterial3Api
    @Composable
    fun Show(modifier: Modifier)
    {
        if (w)
        {
            AlertDialog(
                onDismissRequest = { w = false }, modifier = modifier,
                title = { Text("Мы не можем рассчитать прогноз по следующим причинам") },
                icon = { Icon(Icons.Default.Notifications, "") },
                text = {
                    Text("В поле $text должно быть число\nПожалуйста, уберите посторонние символы с полей.")
                       },
                iconContentColor = Color.Magenta, shape = AlertDialogDefaults.shape,
                confirmButton = { Designer.StyledButtonDefault(onClick = { w = false; }, text = "ОК") },
                containerColor = Color.White, titleContentColor = Color.Black, textContentColor = Color.Blue,
            )
        }
        OutlinedTextField(value = po, onValueChange = { po = it }, label = { Text(text) }, modifier = modifier)
    }
}
