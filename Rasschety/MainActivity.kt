package com.example.lr_calc_2026
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
class MainActivity : ComponentActivity()
{
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Restore.create()
        setContent { Screens.Screen(this) }
    }
    override fun onStart() { super.onStart() }
    override fun onPause() { super.onPause() }
    override fun onStop() { super.onStop() }
    override fun onRestart() { super.onRestart() }
    override fun onResume() { super.onResume() }
    override fun onDestroy() { Restore.destroy(); super.onDestroy() }
}
