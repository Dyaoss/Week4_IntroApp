package com.example.loginandintroduce

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signUp = findViewById<Button>(R.id.btn_signup2)
        val closeSignUp = findViewById<Button>(R.id.btn_close2)

        val nameInfo = findViewById<EditText>(R.id.et_sign_up_name)
        val idInfo = findViewById<EditText>(R.id.et_sign_up_ID)
        val passWordInfo = findViewById<EditText>(R.id.et_sign_up_password)
        val passsWordAgainInfo = findViewById<EditText>(R.id.et_sign_up_password_again)

        signUp.setOnClickListener {
            var getSignUpName = nameInfo.text.toString()
            var getSignUpId = idInfo.text.toString()
            var getSignUpPW = passWordInfo.text.toString()
            var getSignUpPWAgain = passsWordAgainInfo.text.toString()

            if(getSignUpName.isEmpty() || getSignUpId.isEmpty() || getSignUpPW.isEmpty() || getSignUpPWAgain.isEmpty()){
                Toast.makeText(applicationContext, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                if (getSignUpPW != getSignUpPWAgain){
                    Toast.makeText(applicationContext, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(applicationContext, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

        closeSignUp.setOnClickListener {
            finish()
        }

    }
}