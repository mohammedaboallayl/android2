package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.ModelViews.LoginViewModel


class Login : Fragment() {
    private lateinit var loginbtn: Button
    private lateinit var signuppage: TextView
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var validation:Array<Actions>
    private var email = ""
    private var password = ""
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        observeStates()
        loginbtn.setOnClickListener {
            var check=true
            for (i in validation){
                if (i.CheckMatching()){
                    continue
                }else{
                    check=false
                    break
                }
            }
            if(check){
                postData()
            }

        }
        signuppage.setOnClickListener {

            findNavController().navigate(R.id.action_login2_to_signUp)
        }
    }
    private fun init(view:View){

        loginbtn=view.findViewById(R.id.m1loginBtn)
        signuppage=view.findViewById(R.id.m1signup)
        emailEt=view.findViewById(R.id.m1phoneNumEd)
        passwordEt=view.findViewById(R.id.m1passEd)
        validation= arrayOf(
                Actions(emailEt, "([a-zA-Z]|[0-9]|\\.|\\-|\\_)+\\@([a-zA-Z]|[0-9])+\\.com","Phone Number must be eleven number"),
                Actions(passwordEt, "([a-zA-Z0-9]){8,}","password must be more than 8 and contains digits and letters"),
        )
    }
    public fun Actions.CheckMatching():Boolean{
        if(!this.IsMatch()){
            Toast.makeText(context,this.EMessage, Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
    private fun getValue() {
        email = emailEt.text.toString()
        password = passwordEt.text.toString()
    }
    private fun postData() {
            getValue()
            viewModel.login(email, password)
    }
    private fun observeStates() {
        viewModel.loginLiveData.observe(viewLifecycleOwner) {
            if(it.status==true){
                findNavController().navigate(R.id.action_login2_to_commingSoonReciqule)
            }else
            {
                Toast.makeText(requireContext(),"Email Or Password Is Incorrect",Toast.LENGTH_LONG).show()
            }
        }


        viewModel.loginErrorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

    }
}