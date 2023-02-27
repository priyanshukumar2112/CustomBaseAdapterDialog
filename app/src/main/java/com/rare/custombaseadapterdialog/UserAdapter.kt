package com.rare.custombaseadapterdialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter

class UserAdapter(var arrayList: ArrayList<UserModel>) : BaseAdapter() {
    override fun getCount(): Int {
      return  arrayList.size
    }

    override fun getItem(position: Int): UserModel {
        return arrayList[position]
    }
    override fun getItemId(position: Int): Long {

        return 123
    }
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.stu_list,parent,false)


        return view
    }
}