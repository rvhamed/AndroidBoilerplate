package com.hamedrahimvand.launchers

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.hamedrahimvand.ui.BaseFragment

/**
 *
 *@author Hamed.Rahimvand
 *@since 4/9/21
 */
class LaunchersListFragment : BaseFragment(R.layout.fragment_launchers_list){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO just for test
        view.findViewById<Button>(R.id.button).setOnClickListener {
//            findNavController().navigate(LaunchersListFragmem)
        }
    }
}