package com.example.lotinkrill

import Cache.MySharedPreference.init
import Cache.MySharedPreference.lotinKrill
import Cache.MySharedPreference.matn1
import Cache.MySharedPreference.matn2
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog.view.*
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        init(this)

        edt1.setText(matn1)
        edt2.setText(matn2)

        if (lotinKrill == "latin") {
            edt1.hint = "Lotin"
            edt2.hint = "Крилл"
        } else {
            edt1.hint = "Крилл"
            edt2.hint = "Lotin"
        }

        del_1.setOnClickListener { edt1.text.clear(); matn1 = "" }
        del_2.setOnClickListener { edt2.text.clear(); matn2 = "" }
        copy1.setOnClickListener { copyCliboard(edt1.text.toString()) }
        copy2.setOnClickListener { copyCliboard(edt2.text.toString()) }
        paste1.setOnClickListener { pasteCliborad1() }
        paste2.setOnClickListener { pasteCliborad2() }

        more_img.setOnClickListener { popupMenu() }

        edt1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (lotinKrill == "latin") {
                    val text = edt1.text.toString().replace("yu", "ю").replace("YU", "Ю").replace("""g'""", "ғ").replace("""G'""", "Ғ").replace("ye", "е").replace("Ye", "Е").replace("ch", "ч").replace("Ch", "Ч").replace("CH", "Ч").replace("cH", "ч").replace("sh", "ш").replace("Sh", "Ш").replace("sH", "ш").replace("SH", "Ш").replace("o'", "ў").replace("O'", "Ў").replace("yU", "Ю").replace("yo", "ё").replace("Yo", "Ё").replace("yO", "Ё").replace("ya", "я").replace("Ya", "Я").replace("yA", "я").replace("a", "а").replace("A", "А").replace("b", "б").replace("B", "Б").replace("v", "в").replace("V", "В").replace("g", "г").replace("G", "Г").replace("d", "д").replace("D", "Д").replace("j", "ж").replace("J", "Ж").replace("z", "з").replace("Z", "З").replace("i", "и").replace("I", "И").replace("y", "й").replace("Y", "Й").replace("k", "к").replace("K", "К").replace("l", "л").replace("L", "Л").replace("m", "м").replace("M", "М").replace("n", "н").replace("N", "Н").replace("o", "о").replace("O", "О").replace("p", "п").replace("P", "П").replace("s", "с").replace("S", "С").replace("t", "т").replace("T", "Т").replace("u", "у").replace("U", "У").replace("f", "ф").replace("F", "Ф").replace("x", "х").replace("X", "Х").replace("e", "э").replace("E", "Э").replace("q", "қ").replace("Q", "Қ").replace("h", "х").replace("H", "Х").replace("R", "Р").replace("r", "р").replace("'", "ъ")
                    edt2.setText(text)
                    matn1 = edt1.text.toString()
                    matn2 = edt2.text.toString()
                } else {
                    val text2 = edt1.text.toString().replace("а", "a").replace("А", "A").replace("б", "b").replace("Б", "B").replace("в", "V").replace("В", "V").replace("г", "g").replace("Г", "G").replace("д", "d").replace("Д", "D").replace("е", "ye").replace("Е", "Ye").replace("ё", "yo").replace("Ё", "YO").replace("ж", "j").replace("Ж", "J").replace("з", "z").replace("З", "Z").replace("и", "i").replace("И", "I").replace("й", "y").replace("Й", "Y").replace("к", "k").replace("К", "K").replace("л", "l").replace("Л", "L").replace("м", "m").replace("М", "M").replace("н", "n").replace("Н", "N").replace("о", "o").replace("О", "O").replace("п", "p").replace("П", "P").replace("с", "s").replace("С", "S").replace("т", "t").replace("Т", "t").replace("у", "u").replace("У", "U").replace("ф", "f").replace("Ф", "F").replace("х", "x").replace("Х", "X").replace("ц", "s").replace("Ц", "S").replace("ч", "ch").replace("Ч", "CH").replace("ш", "sh").replace("Щ", "SH").replace("щ", "sh").replace("Щ", "SH").replace("э", "e").replace("Э", "E").replace("ю", "yu").replace("Ю", "YU").replace("я", "ya").replace("Я", "YA").replace("ў", "o'").replace("Ў", "O'").replace("қ", "q").replace("Қ", "Q").replace("ғ", "g'").replace("Ғ", "G'").replace("ы", "").replace("ъ", "'").replace("ь", "").replace("р", "r").replace("Р", "R")
                    edt2.setText(text2)
                    matn1 = edt1.text.toString()
                    matn2 = edt2.text.toString()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

    }

    private fun popupMenu() {
        val popupMenu = android.widget.PopupMenu(this, more_img)
        popupMenu.inflate(R.menu.menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {

                R.id.krill_lotin -> {
                    lotinKrill = "krill"
                    val matn_1 = edt1.text.toString()
                    val matn_2 = edt2.text.toString()

                    edt1.setText(matn_2)
                    edt2.setText(matn_1)

                    edt1.hint = "Крилл"
                    edt2.hint = "Lotin"
                    true
                }
                R.id.lotin_krill -> {
                    lotinKrill = "latin"
                    val matn_1 = edt1.text.toString()
                    val matn_2 = edt2.text.toString()

                    edt1.setText(matn_2)
                    edt2.setText(matn_1)

                    edt1.hint = "Lotin"
                    edt2.hint = "Крилл"
                    true
                }
                R.id.about -> {

                    val view = View.inflate(this, R.layout.dialog, null)
                    val builder = AlertDialog.Builder(this)
                    builder.setView(view)
                    val dialog = builder.create()
                    dialog.show()
                    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                    view.root.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim1))
                    view.close.setOnClickListener {
                        val anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2)
                        view.root.startAnimation(anim2)
                        anim2.setAnimationListener(object : Animation.AnimationListener {
                            override fun onAnimationStart(animation: Animation?) {

                            }

                            override fun onAnimationEnd(animation: Animation?) {
                                dialog.hide()
                            }

                            override fun onAnimationRepeat(animation: Animation?) {

                            }

                        })
                    }

                    true
                }

                else -> true
            }
        }

        more_img.setOnClickListener {
            try {
                val popup: Field = android.widget.PopupMenu::class.java.getDeclaredField("mPopup")
                popup.isAccessible = true
                val menu = popup.get(popupMenu)
                menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(menu, true)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                popupMenu.show()
            }
        }
    }

    private fun copyCliboard(text: String) {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("clipboard", text)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this, "Nusxalab olindi", Toast.LENGTH_SHORT).show()
    }

    private fun pasteCliborad1() {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        edt1.setText(clipboardManager.primaryClip?.getItemAt(0)?.text.toString())
    }

    private fun pasteCliborad2() {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        edt2.setText(clipboardManager.primaryClip?.getItemAt(0)?.text.toString())
    }
}