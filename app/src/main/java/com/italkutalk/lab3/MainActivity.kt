package com.italkutalk.lab3
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.ed_name)//以下宣告變數名稱
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        btn_mora.setOnClickListener {
            if (ed_name.length() < 1)//判斷玩家是否輸入姓名
            {
                tv_text.text = "請輸入玩家姓名"
                return@setOnClickListener
            }
            val playerName = ed_name.text
            val comMora = (Math.random() * 3).toInt()//產生亂數
            val playerMoraText = when//讀取玩家出拳
            {
                btn_scissor.isChecked -> "剪刀"
                btn_stone.isChecked -> "石頭"
                else -> "布"
            }
            val comMoraText = when(comMora)//讀取電腦出拳
            {
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }
            tv_name.text = "名字\n$playerName"
            tv_mmora.text = "我方出拳\n$playerMoraText"
            tv_cmora.text = "電腦出拳\n$comMoraText"
            when
            {
                btn_scissor.isChecked && comMora == 2 ||//判斷及顯示輸贏結果
                btn_stone.isChecked && comMora == 0 ||
                btn_paper.isChecked && comMora == 1 ->
                {
                    tv_winner.text = "勝利者\n$playerName"
                    tv_text.text = "恭喜你獲勝了！！！"
                }
                btn_scissor.isChecked && comMora == 1 ||//判斷及顯示輸贏結果
                btn_stone.isChecked && comMora == 2 ||
                btn_paper.isChecked && comMora == 0 ->
                {
                    tv_winner.text = "勝利者\n 電腦"
                    tv_text.text = "可惜，電腦獲勝了！"
                }
                else ->//判斷及顯示輸贏結果
                {
                    tv_winner.text = "勝利者\n 平手"
                    tv_text.text = "平局，請再試一次！"
                }
            }
            String name = "你好好好";
            var name = "你好好好"
        }
    }
}