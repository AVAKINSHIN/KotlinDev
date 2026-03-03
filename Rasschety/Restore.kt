package com.example.lr_calc_2026
import com.example.lr_calc_2026.BaseCalculator.g
object Restore
{
    val p = ArrayList<String>()
    fun destroy() { for (d in g) { p.add(d.po) }; p.add(Screens.ket); g.clear() }
    fun create()
    {
        BaseCalculator.writeColumns()
        if (p.isEmpty()) { return; }
        for (d in 0..g.size) { try { g[d].po = p[d]; } catch(e: Exception) { print(e); break; } }
        if (p.size <= g.size) { p.clear(); return }
        try { Screens.ket = p[g.size + 1]; } catch(e: Exception) { print(e); p.clear(); return; }; p.clear()
    }
    fun clear() { BaseCalculator.x.clear(); for (d in g) { d.po = "" }; Screens.ket = "" }
}
