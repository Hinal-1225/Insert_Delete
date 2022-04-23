package com.example.insert_delete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_all.*

class ViewAllActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)

        refreshRecycler()
    }
    private fun refreshRecycler() {
        var db=DBHelper(this)
        var arr=db.retriveAll()
        var employeeadapter = EmployeeAdapter(this,arr)
        myrecycle.adapter = employeeadapter
    }
    fun delete(position:Int)
    {
        var db=DBHelper(this)
        var arr:ArrayList<Employee> = db.retriveAll()
        var employee=arr.get(position)
        db.delete(employee.em_id)
        refreshRecycler()
    }
}
