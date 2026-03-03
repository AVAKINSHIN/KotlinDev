package com.example.lr_calc_2026
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import com.example.lr_calc_2026.ui.theme.LR_calc_2026Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
object Screens
{
    var ket by mutableStateOf("")
    @ExperimentalMaterial3Api
    @Composable
    fun Screen(q: ComponentActivity)
    {
        LR_calc_2026Theme {
            Scaffold { innerPadding ->
                Column(verticalArrangement = Arrangement.Center)
                {
                    Designer.SuperText(
                        BaseCalculator.NAME, pv=innerPadding, s=35,
                        Modifier.align(Alignment.CenterHorizontally)
                    )
                    Designer.SuperText("Введите данные и нажмите Рассчитать", pv=innerPadding, s=18, Modifier)
                    LazyColumn {
                        for (d in BaseCalculator.g)
                        { item { d.Show(Modifier.fillMaxWidth()) } }
                        if (ket != "") { item { Designer.SuperText(ket, pv=innerPadding, s=18, Modifier) } }
                        item { Designer.StyledButtonDefault(onClick = {
                            ket = BaseCalculator.result();
                                                                      }, text = "Рассчитать") }
                        item { Designer.StyledButtonDefault(onClick = { Restore.clear() }, text = "Сброс") }
                        item { Designer.StyledButtonDefault(onClick = { q.finish() }, text = "Выход") }
                    }

                }
            }
        }
    }
}
