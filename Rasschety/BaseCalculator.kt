package com.example.lr_calc_2026
import android.annotation.SuppressLint
import kotlin.math.exp
object BaseCalculator
{
    const val NAME = "Калькулятор Когана"
    val g = ArrayList<Komponenta>()
    val x = ArrayList<Double>()
    var metel = 0.0
    var ytki = true
    var pod = ""
    var format = 0.0
    fun writeColumns()
    {
        g.clear()
        g.add(Komponenta("Сексуальность (общий балл)"))
        g.add(Komponenta("Объём ПЖ (куб. см)"))
        g.add(Komponenta("Уровень ПСА (нг/мл)"))
    }
    @SuppressLint("DefaultLocale")
    fun result(): String
    {
        ytki = true
        x.clear()
        for (d in g)
        {
            try { x.add(d.po.toDouble()) }
            catch(e: Exception)
            {
                pod = d.po.replace(',', '.'); print(e)
                try { x.add(pod.toDouble()) }
                catch(e: Exception)
                {
                    print(e); try { d.po = d.po.split(" ")[0]; }
                    catch(e: Exception) { d.w = true; print(e); ytki = false; break; }
                    pod = d.po.replace(',', '.')
                    try { x.add(pod.toDouble()) }
                    catch(e: Exception) { d.w = true; print(e); ytki = false; break; }
                }
            }
        }
        if (!ytki) { return "Во всех полях должны быть ТОЛЬКО числа. Пожалуйста, уберите все посторонние символы."}
        metel = exp(-3.56+0.079*x[0]+0.141*x[1]-2.03*x[2])
        format = metel / (1 + metel)
        if (format < 0.5)
        {
            return "Результат рассчёта: Рак ПЖ\nВероятность: " + String.format("%.2f", (1 - format) * 100) + "%"
        }
        return "Результат рассчёта: ДГПЖ\nВероятность: " + String.format("%.2f", format * 100) + "%"
    }
}
