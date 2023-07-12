package com.example.khatabook.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khatabook.Adapter.Adapter
import com.example.khatabook.Class.DatabaseHelper
import com.example.khatabook.Modal.ModalClass
import com.example.khatabook.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityCategoryBinding
    var list = ArrayList<ModalClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

        var database = DatabaseHelper(this,"CategoryTable.db",null,1)
        binding.btnApply.setOnClickListener {
            val name = binding.edtCategoryName.text.toString()
            if (name.isEmpty())
            {

                Toast.makeText(this, "Please Enter Your Category Name ", Toast.LENGTH_SHORT).show()
            }

            else
            {
                database.InsertData(name)
                Toast.makeText(this, "Your Data Add SuccesFully", Toast.LENGTH_SHORT).show()
                list = database.DisplayCategory(name)
            }

        }

        var adapter = Adapter(this,list)
        var manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.imgBack.setOnClickListener {

            onBackPressed()
        }




    }
}