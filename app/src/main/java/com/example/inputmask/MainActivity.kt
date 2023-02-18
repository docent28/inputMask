package com.example.inputmask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.inputmask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtInputMask.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var text = ""
                binding.txtInputMask.text.toString().split(' ').forEach { text += it }
                val digits = text.length
                if (s?.length!! < 10) {
                    if (binding.txtInputMask.text.length == 5 && digits == 5) {
                        val numbers = binding.txtInputMask.text.toString()
                        val result = "${numbers[0]}${numbers[1]}${numbers[2]}${numbers[3]} ${numbers[4]}"

                        binding.txtInputMask.setText(result)
                        binding.txtInputMask.setSelection(binding.txtInputMask.text.length)
                    }
                    else if (digits == 4 && binding.txtInputMask.text.length > 4) {
                        var txt = binding.txtInputMask.text.toString()
                        txt = txt.replace(" ", "")
                        binding.txtInputMask.setText(txt)
                        binding.txtInputMask.setSelection(binding.txtInputMask.text.length)
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}