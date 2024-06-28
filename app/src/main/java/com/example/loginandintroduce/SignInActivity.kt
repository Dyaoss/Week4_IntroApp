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

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val logIn = findViewById<Button>(R.id.btn_login)
        val sign = findViewById<Button>(R.id.btn_signup)

        val signInidInfo = findViewById<EditText>(R.id.et_id) // id editText의 입력값을 extra에 저장
        val signInPW = findViewById<EditText>(R.id.et_password)

        logIn.setOnClickListener {

            var getId = signInidInfo.text.toString()
            var getPassWord = signInPW.text.toString()

            if (getId.isEmpty()) {
                Toast.makeText(applicationContext, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if (getPassWord.isEmpty()) {
                Toast.makeText(applicationContext, "패스워드를 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("idData",getId)
                startActivity(intent) // 로그인 버튼을 누르면 HomeActivity로 넘어감
                Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
            }
        }

            sign.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            } // 회원가입 버튼을 누르면 SignInActivity로 넘어감
        }
    }