package com.example.checkoutcal

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val etScore = findViewById<EditText>(R.id.etScore)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val etDart1 = findViewById<EditText>(R.id.etdart1)
        val btnDart1 = findViewById<Button>(R.id.btnDart1)
        val tvResult2 = findViewById<TextView>(R.id.tvResult)
        val cbDouble = findViewById<CheckBox>(R.id.cbDouble)
        val cbTriple = findViewById<CheckBox>(R.id.cbTriple)
        val llDart2 = findViewById<LinearLayout>(R.id.llDart2)
        val btnDart2 = findViewById<Button>(R.id.btnDart2)
        val etDart2 = findViewById<EditText>(R.id.etdart2)
        val cbDouble2 = findViewById<CheckBox>(R.id.cbDouble2)
        val cbTriple2 = findViewById<CheckBox>(R.id.cbTriple2)
        val llCheckboxes = findViewById<LinearLayout>(R.id.llCheckboxes)
        val llDart3 = findViewById<LinearLayout>(R.id.llDart3)
        val btnDart3 = findViewById<Button>(R.id.btnDart3)
        val etDart3 = findViewById<EditText>(R.id.etdart3)
        val cbDouble3 = findViewById<CheckBox>(R.id.cbDouble3)
        val cbTriple3 = findViewById<CheckBox>(R.id.cbTriple3)
        val btnHistory = findViewById<Button>(R.id.btnHistory)
        val history = arrayListOf<String>()

        var score = 0
        var originalScore = 0

        val checkouts = mapOf(
            41  to "9, D16",
            42  to "10, D16",
            43  to "3, D20",
            44  to "4, D20",
            45  to "13, D16",
            46  to "6, D20",
            47  to "7, D20",
            48  to "16, D16",
            49  to "17, D16",
            50  to "18, D16",
            51  to "19, D16",
            52  to "20, D16",
            53  to "13, D20",
            54  to "14, D20",
            55  to "15, D20",
            56  to "16, D20",
            57  to "17, D20",
            58  to "18, D20",
            59  to "19, D20",
            60  to "20, D20",
            61  to "T15, D8",
            62  to "T10, D16",
            63  to "T13, D12",
            64  to "T16, D8",
            65  to "T19, D4",
            66  to "T14, D12",
            67  to "T17, D8",
            68  to "T20, D4",
            69  to "T19, D6",
            70  to "T18, D8",
            71  to "T13, D16",
            72  to "T16, D12",
            73  to "T19, D8",
            74  to "T14, D16",
            75  to "T17, D12",
            76  to "T20, D8",
            77  to "T19, D10",
            78  to "T18, D12",
            79  to "T19, D11",
            80  to "T20, D10",
            81  to "T19, D12",
            82  to "Bull, D16",
            83  to "T17, D16",
            84  to "T20, D12",
            85  to "T15, D20",
            86  to "T18, D16",
            87  to "T17, D18",
            88  to "T20, D14",
            89  to "T19, D16",
            90  to "T20, D15",
            91  to "T17, D20",
            92  to "T20, D16",
            93  to "T19, D18",
            94  to "T18, D20",
            95  to "T19, D19",
            96  to "T20, D18",
            97  to "T19, D20",
            98  to "T20, D19",
            100 to "T20, D20",

            // 3 dart finishes
            99  to "T19, 10, D16",
            101 to "T20, 9, D16",
            102 to "T16, 14, D20",
            103 to "T19, 6, D20",
            104 to "T16, 16, D20",
            105 to "T20, 13, D16",
            106 to "T20, 6, D20",
            107 to "T19, 10, D20",
            108 to "T20, 16, D16",
            109 to "T20, 17, D16",
            110 to "T20, 10, D20",
            111 to "T19, 14, D20",
            112 to "T20, 20, D16",
            113 to "T19, 16, D20",
            114 to "T20, 14, D20",
            115 to "T20, 15, D20",
            116 to "T20, 16, D20",
            117 to "T20, 17, D20",
            118 to "T20, 18, D20",
            119 to "T19, 12, Bull",
            120 to "T20, 20, D20",
            121 to "T20, 11, Bull",
            122 to "T18, 18, Bull",
            123 to "T19, 16, Bull",
            124 to "T20, 14, Bull",
            125 to "25, T20, D20",
            126 to "T19, 19, Bull",
            127 to "T20, 17, Bull",
            128 to "18, T20, Bull",
            129 to "19, T20, Bull",
            130 to "T20, 20, Bull",
            131 to "T20, T13, D16",
            132 to "25, T19, Bull",
            133 to "T20, T19, D8",
            134 to "T20, T14, D16",
            135 to "25, T20, Bull",
            136 to "T20, T20, D8",
            137 to "T20, T19, D10",
            138 to "T20, T18, D12",
            139 to "T19, T14, D20",
            140 to "T20, T20, D10",
            141 to "T20, T19, D12",
            142 to "T20, T14, D20",
            143 to "T20, T17, D16",
            144 to "T20, T20, D12",
            145 to "T20, T15, D20",
            146 to "T20, T18, D16",
            147 to "T20, T17, D18",
            148 to "T20, T20, D14",
            149 to "T20, T19, D16",
            150 to "T20, T18, D18",
            151 to "T20, T17, D20",
            152 to "T20, T20, D16",
            153 to "T20, T19, D18",
            154 to "T20, T18, D20",
            155 to "T20, T19, D19",
            156 to "T20, T20, D18",
            157 to "T20, T19, D20",
            158 to "T20, T20, D19",
            160 to "T20, T20, D20",
            161 to "T20, T17, Bull",
            164 to "T20, T18, Bull",
            167 to "T20, T19, Bull",
            170 to "T20, T20, Bull"
        )

        btnCalculate.setOnClickListener {
            val input = etScore.text.toString()

            if (input.isEmpty()) {
                etScore.error = "Upiši broj!"
                return@setOnClickListener
            }

            score = input.toInt()
            originalScore = score



            val result = checkouts[score]



            if (result == null) {
                tvResult.text = "❌ Nema checkoutu za $score"
            } else {
                tvResult.text = "✅ $result"
            }

            if (score < 2 || score > 170) {
                etScore.error = "Broj mora biti između 2 i 170!"
                return@setOnClickListener
            }
            val etDart1 = findViewById<EditText>(R.id.etdart1)
            val btnDart1 = findViewById<Button>(R.id.btnDart1)
            val tvResult2 = findViewById<TextView>(R.id.tvResult)



            llCheckboxes.visibility = View.VISIBLE
            btnDart1.visibility = View.VISIBLE
            tvResult2.visibility = View.VISIBLE

            etDart1.setText("")
            etDart2.setText("")
            etDart3.setText("")
            cbDouble.isChecked = false
            cbTriple.isChecked = false
            cbDouble2.isChecked = false
            cbTriple2.isChecked = false
            cbDouble3.isChecked = false
            cbTriple3.isChecked = false
        }
        btnDart1.setOnClickListener {
            val dart1Input = etDart1.text.toString()

            if (dart1Input.isEmpty()) {
                etDart1.error = "Upiši što si pogodio!"
                return@setOnClickListener
            }

            val dart1Value = dart1Input.toInt()

            val dart1Score = when {
                cbTriple.isChecked -> dart1Value * 3
                cbDouble.isChecked -> dart1Value * 2
                else -> dart1Value
            }

            score -= dart1Score  // ← ažuriraj score

            when {
                score == 0 -> {
                    llCheckboxes.visibility = View.GONE
                    history.add("✅ $originalScore → CHECKOUT!")

                    AlertDialog.Builder(this)
                        .setTitle("🎯 CHECKOUT!")
                        .setMessage("Čestitamo! Završio si!")
                        .setPositiveButton("Nova igra") { _, _ ->
                            etScore.setText("")
                            tvResult.text = ""
                            score = 0

                        }
                        .setNegativeButton("Zatvori", null)
                        .show()
                    return@setOnClickListener

                }
                score < 0 -> {
                    score += dart1Score  // vrati stari score
                    llCheckboxes.visibility = View.GONE
                    tvResult.text = "💥 BUST! Ostaje $score"
                    etScore.setText(score.toString())
                    return@setOnClickListener
                }
            }

            // sakrij dart1, pokaži dart2
            llCheckboxes.visibility = View.GONE
            btnDart1.visibility = View.GONE
            etDart1.setText("")
            cbDouble.isChecked = false
            cbTriple.isChecked = false

            llDart2.visibility = View.VISIBLE
            btnDart2.visibility = View.VISIBLE

            val result = checkouts[score]
            tvResult.text = if (result != null) "✅ $result" else "❌ Nema checkoutu za $score"
            }

        btnDart2.setOnClickListener {
            val dart2Input = etDart2.text.toString()

            if (dart2Input.isEmpty()) {
                etDart2.error = "Upiši što si pogodio!"
                return@setOnClickListener
            }

            val dart2Value = dart2Input.toInt()

            val dart2Score = when {
                cbTriple2.isChecked -> dart2Value * 3
                cbDouble2.isChecked -> dart2Value * 2
                else -> dart2Value
            }

            score -= dart2Score

            when {
                score == 0 -> {
                    llDart2.visibility = View.GONE
                    history.add("✅ $originalScore → CHECKOUT!")

                    AlertDialog.Builder(this)
                        .setTitle("🎯 CHECKOUT!")
                        .setMessage("Čestitamo! Završio si!")
                        .setPositiveButton("Nova igra") { _, _ ->
                            etScore.setText("")
                            tvResult.text = ""
                            score = 0

                        }
                        .setNegativeButton("Zatvori", null)
                        .show()
                    return@setOnClickListener
                }
                score < 0 -> {
                    score += dart2Score  // vrati stari score
                    llDart2.visibility = View.GONE
                    tvResult.text = "💥 BUST! Ostaje $score"
                    etScore.setText(score.toString())
                    return@setOnClickListener
                }
            }

            // sakrij dart2, pokaži dart3
            llDart2.visibility = View.GONE
            btnDart2.visibility = View.GONE
            etDart2.setText("")
            cbDouble2.isChecked = false
            cbTriple2.isChecked = false

            llDart3.visibility = View.VISIBLE
            btnDart3.visibility = View.VISIBLE

            val result = checkouts[score]
            tvResult.text = if (result != null) "✅ $result" else "❌ Nema checkoutu za $score"
        }

        btnDart3.setOnClickListener {
            val dart3Input = etDart3.text.toString()

            if (dart3Input.isEmpty()) {
                etDart3.error = "Upiši što si pogodio!"
                return@setOnClickListener
            }

            val dart3Value = dart3Input.toInt()

            val dart3Score = when {
                cbTriple3.isChecked -> dart3Value * 3
                cbDouble3.isChecked -> dart3Value * 2
                else -> dart3Value
            }

            val finalScore = score - dart3Score

            // sakrij dart3
            llDart3.visibility = View.GONE


            when {
                finalScore == 0 -> {
                    llDart3.visibility = View.GONE
                    history.add("✅ $originalScore → CHECKOUT!")

                    AlertDialog.Builder(this)
                        .setTitle("🎯 CHECKOUT!")
                        .setMessage("Čestitamo! Završio si!")
                        .setPositiveButton("Nova igra") { _, _ ->
                            etScore.setText("")
                            tvResult.text = ""
                            score = 0

                        }
                        .setNegativeButton("Zatvori", null)
                        .show()
                }
                finalScore < 0 -> {
                    llDart3.visibility = View.GONE
                    tvResult.text = "💥 BUST! Ostaje $score"
                    etScore.setText(score.toString())
                    // pokaži dart1 opet za novi pokušaj
                    llCheckboxes.visibility = View.VISIBLE
                }
                else -> {
                    llDart3.visibility = View.GONE
                    score = finalScore
                    etScore.setText(score.toString())
                    val result = checkouts[score]
                    tvResult.text = if (result != null) "✅ $result" else "❌ Nema checkoutu za $score"
                }
            }

            }
        btnHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            intent.putStringArrayListExtra("history", history)
            startActivity(intent)
        }
        }

    }
