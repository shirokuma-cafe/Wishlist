package com.example.wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var items: ArrayList<Item>
    lateinit var wishlistRV: RecyclerView
    lateinit var button: Button
    lateinit var itemName: EditText
    lateinit var itemPrice: EditText
    lateinit var itemURL: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(android.R.style.Theme_Light);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = ArrayList()
        button = findViewById<Button>(R.id.button)
        wishlistRV = findViewById<RecyclerView>(R.id.wishListRV)
        itemName = findViewById<EditText>(R.id.itemNameET)
        itemPrice = findViewById<EditText>(R.id.itemPriceET)
        itemURL = findViewById<EditText>(R.id.itemURLET)

        button.setOnClickListener {

            // Will hide the keyboard when button is pressed
            this.currentFocus?.let { view ->
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }

            val newItem = Item(itemName.text.toString(), itemPrice.text.toString(), itemURL.text.toString())
            items.add(newItem)

            // clear text field
            findViewById<EditText>(R.id.itemNameET).text.clear()
            findViewById<EditText>(R.id.itemPriceET).text.clear()
            findViewById<EditText>(R.id.itemURLET).text.clear()

            // binding adapter to RecyclerView
            val adapter = ItemAdapter(items)
            wishlistRV.adapter = adapter
            wishlistRV.layoutManager = LinearLayoutManager(this)

        }
    }
}