package com.example.graphtraversalvisualization

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.gridlayout.widget.GridLayout
import androidx.fragment.app.DialogFragment
import java.sql.Types.NULL

class GridActivity : AppCompatActivity() {
    var start = -1
    var finish = -1
    lateinit var startButton : Button
    lateinit var gridLayout: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        gridLayout = findViewById(R.id.play_grid)
        startButton = findViewById(R.id.start_btn)
        init(this)
    }

    fun init(activity: Activity){
        var childCount = gridLayout.childCount
        for (i in 0 until childCount){
            val curButton = gridLayout.getChildAt(i) as Button
            curButton.setBackgroundResource(android.R.drawable.btn_default)
            curButton.setOnClickListener{
                Toast.makeText(this," "+i,Toast.LENGTH_SHORT).show()
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setTitle("Choose Cell Type")
                        .setItems(arrayOf("Start","Bolcked","Finish","None"),DialogInterface.OnClickListener { dialog, which ->
                            if(which == 0 && start == -1){
                                curButton.setBackgroundResource(R.drawable.blue_button)
                                start = i
                                if(finish == i) finish = -1
                            }
                            else if(which == 1){
                                curButton.setBackgroundColor(Color.BLACK)
                                if(start == i) start = -1
                                if(finish == i) finish = -1
                            }
                            else if(which == 2 && finish == -1){
                                curButton.setBackgroundResource(R.drawable.green_button)
                                finish = i
                                if(start == i) start = -1
                            }
                            else if(which == 3){
                                curButton.setBackgroundResource(android.R.drawable.btn_default)
                                if(start == i) start = -1
                                if(finish == i) finish = -1
                            }

                        })
                dialogBuilder.create()
                dialogBuilder.show()
            }
        }
    }


}
